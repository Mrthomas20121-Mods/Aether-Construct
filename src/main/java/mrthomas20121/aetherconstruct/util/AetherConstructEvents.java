package mrthomas20121.aetherconstruct.util;

import com.aetherteam.aether.capability.player.AetherPlayer;
import com.aetherteam.aether.mixin.mixins.common.accessor.ServerGamePacketListenerImplAccessor;
import mrthomas20121.aetherconstruct.AetherConstruct;
import mrthomas20121.aetherconstruct.AetherMaterialIds;
import mrthomas20121.aetherconstruct.AetherModifierIds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.materials.definition.MaterialVariant;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = AetherConstruct.MOD_ID)
public class AetherConstructEvents {

    @SubscribeEvent
    public static void onInventoryTick(TickEvent.PlayerTickEvent event) {
        if(!event.isCanceled()) {
            Player player = event.player;

            if(player.isInWaterOrBubble() || player.isUnderWater()) {
                for(ItemStack stack: player.getArmorSlots()) {
                    if(stack.is(TinkerTags.Items.ARMOR)) {
                        ToolStack tool = ToolStack.from(stack);

                        for(int i = 0; i<tool.getMaterials().size(); i++) {
                            MaterialVariant mat = tool.getMaterial(i);
                            if(mat.getId().equals(AetherMaterialIds.PHOENIX)) {
                                tool.replaceMaterial(i, AetherMaterialIds.OBSIDIAN);
                            }
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if(!event.isCanceled()) {
            valkyrieFlight(entity);
            boostLavaSwimming(entity);
            boostVerticalLavaSwimming(entity);
        }
    }

    static void valkyrieFlight(LivingEntity entity) {
        if (entity instanceof Player player && !player.getAbilities().flying) {
            for(ItemStack stack: player.getArmorSlots()) {
                if(stack.is(TinkerTags.Items.ARMOR)) {
                    ToolStack armor = ToolStack.from(stack);

                    ModifierEntry modifierEntry = armor.getModifier(AetherModifierIds.FLIGHT_OF_THE_BUMBLEBEE);

                    // if it's not empty
                    if(modifierEntry.getLevel() > 0) {
                        AetherPlayer.get(player).ifPresent(aetherPlayer -> {
                            Vec3 deltaMovement = player.getDeltaMovement();
                            if (aetherPlayer.isJumping() && !onGround(player)) { // Checks if the player is off the ground and holding the jump key (space bar by default).
                                if (aetherPlayer.getFlightModifier() >= aetherPlayer.getFlightModifierMax()) { // Limits the flight modifier to a maximum value.
                                    aetherPlayer.setFlightModifier(aetherPlayer.getFlightModifierMax());
                                }
                                if (aetherPlayer.getFlightTimer() > 2) { // Starts allowing the player to fly after a 2 tick delay of being off the ground.
                                    if (aetherPlayer.getFlightTimer() < aetherPlayer.getFlightTimerMax()) { // Allows the player to fly until the maximum value is hit.
                                        aetherPlayer.setFlightModifier(aetherPlayer.getFlightModifier() + 0.10F*modifierEntry.getEffectiveLevel());
                                        aetherPlayer.setFlightTimer(aetherPlayer.getFlightTimer() + 1);
                                    }
                                } else {
                                    aetherPlayer.setFlightTimer(aetherPlayer.getFlightTimer() + 1);
                                }
                            } else if (!aetherPlayer.isJumping()) {
                                // Resets only the modifier if the player stops holding the jump key midair. The timer doesn't reset though and remains frozen, and will continue where it left off when the key is held again, preventing infinite flight.
                                aetherPlayer.setFlightModifier(1.0F);
                            }
                            if (onGround(player)) { // Resets both timer and modifier if the player is on the ground.
                                aetherPlayer.setFlightTimer(0);
                                aetherPlayer.setFlightModifier(1.0F);
                            }
                            // Modifies the player's upwards movement based on the set flight modifier and timer values.
                            if (aetherPlayer.isJumping() && !onGround(player) && aetherPlayer.getFlightTimer() > 2 && aetherPlayer.getFlightTimer() < aetherPlayer.getFlightTimerMax() && aetherPlayer.getFlightModifier() > 1.0F) {
                                player.setDeltaMovement(deltaMovement.x(), 0.025F * aetherPlayer.getFlightModifier(), deltaMovement.z());
                            }
                            if (player instanceof ServerPlayer serverPlayer) { // Prevents the player from being kicked for flying.
                                ServerGamePacketListenerImplAccessor serverGamePacketListenerImplAccessor = (ServerGamePacketListenerImplAccessor) serverPlayer.connection;
                                serverGamePacketListenerImplAccessor.aether$setAboveGroundTickCount(0);
                            }
                        });
                    }
                }
            }
        }
    }

    static void boostVerticalLavaSwimming(LivingEntity entity) {
        int modifierLevel = ModifierUtil.getModifierLevel(entity.getMainHandItem(), AetherModifierIds.REBORN);
        if (modifierLevel > 0) {
            entity.clearFire();
            if (entity.isInLava()) {
                entity.resetFallDistance();
                if (entity instanceof Player player) {
                    AetherPlayer.get(player).ifPresent((aetherPlayer) -> {
                        float defaultBoost = 1f+modifierLevel;
                        aetherPlayer.setPhoenixSubmergeLength(Math.min(aetherPlayer.getPhoenixSubmergeLength() + 0.1, 1.0));
                        defaultBoost *= (float) aetherPlayer.getPhoenixSubmergeLength();
                        if (entity.getDeltaMovement().y() > 0 || entity.isCrouching()) {
                            entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, defaultBoost, 1.0));
                        }
                    });
                } else {
                    float defaultBoost = 1f+modifierLevel;
                    if (entity.getDeltaMovement().y() > 0 || entity.isCrouching()) {
                        entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, defaultBoost, 1.0));
                    }
                }
            }
        }
    }

    static void boostLavaSwimming(LivingEntity entity) {
        int modifierLevel = ModifierUtil.getModifierLevel(entity.getMainHandItem(), AetherModifierIds.REBORN);
        boolean hasModifier = modifierLevel > 0;
        if (hasModifier) {
            entity.clearFire();
            if (entity.isInLava()) {
                entity.resetFallDistance();
                if (entity instanceof Player player) {
                    AetherPlayer.get(player).ifPresent((aetherPlayer) -> {
                        float defaultBoost = 1F+modifierLevel;
                        aetherPlayer.setPhoenixSubmergeLength(Math.min(aetherPlayer.getPhoenixSubmergeLength() + 0.1, 1.0));
                        defaultBoost *= (float) aetherPlayer.getPhoenixSubmergeLength();
                        entity.moveRelative(0.04F * defaultBoost, new Vec3(entity.xxa, entity.yya, entity.zza));
                    });
                } else {
                    float defaultBoost = 1f+modifierLevel;
                    entity.moveRelative(0.04F * defaultBoost, new Vec3(entity.xxa, entity.yya, entity.zza));
                }
            }
            if (entity.level() instanceof ServerLevel level) {
                level.sendParticles(ParticleTypes.FLAME,
                        entity.getX() + (level.getRandom().nextGaussian() / 5.0),
                        entity.getY() + (level.getRandom().nextGaussian() / 3.0),
                        entity.getZ() + (level.getRandom().nextGaussian() / 5.0),
                        1, 0.0, 0.0, 0.0, 0.0F);
            }
        }
        if (!hasModifier || !entity.isInLava()) {
            if (entity instanceof Player player) {
                AetherPlayer.get(player).ifPresent((aetherPlayer) -> aetherPlayer.setPhoenixSubmergeLength(0.0));
            }
        }
    }

    private static boolean onGround(Player player) {
        return player.onGround() || player.isInFluidType();
    }
}
