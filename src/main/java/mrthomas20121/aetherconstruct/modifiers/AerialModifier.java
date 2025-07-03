package mrthomas20121.aetherconstruct.modifiers;

import com.aetherteam.aether.item.combat.abilities.weapon.GravititeWeapon;
import com.aetherteam.aether.item.tools.abilities.GravititeTool;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.BlockInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

public class AerialModifier extends Modifier implements BlockInteractionModifierHook, MeleeHitModifierHook, ProjectileHitModifierHook, GravititeTool, GravititeWeapon {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, ModifierHooks.BLOCK_INTERACT).addHook(this, ModifierHooks.MELEE_HIT).addHook(this, ModifierHooks.PROJECTILE_HIT);
    }

    @Override
    public InteractionResult afterBlockUse(IToolStackView tool, ModifierEntry modifier, UseOnContext context, InteractionSource source) {
        if(!this.floatBlock(context)) {
            return BlockInteractionModifierHook.super.afterBlockUse(tool, modifier, context, source);
        }
        else {
            return InteractionResult.sidedSuccess(context.getLevel().isClientSide());
        }
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {

        if(context.getLivingTarget() != null) {
            this.launchEntity(context.getAttacker(), context.getLivingTarget());
        }

        MeleeHitModifierHook.super.afterMeleeHit(tool, modifier, context, damageDealt);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {

        // launch the entity if it's not null
        if(attacker != null && target != null) {
            this.launchEntity(attacker, target);
        }
        return ProjectileHitModifierHook.super.onProjectileHitEntity(modifiers, persistentData, modifier, projectile, hit, attacker, target);
    }
}
