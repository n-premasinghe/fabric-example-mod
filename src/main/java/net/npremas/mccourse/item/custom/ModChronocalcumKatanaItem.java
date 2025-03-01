package net.npremas.mccourse.item.custom;

import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;

import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ModChronocalcumKatanaItem extends SwordItem {
    public ModChronocalcumKatanaItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

//        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 200, 2), attacker);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        Vec3d aim = player.getRotationVector();

        player.getItemCooldownManager().set(this, 7);
        

        if (world.isClient()) {

            for (float i = -2; i < 2; i+= 0.05) {
                world.addParticle(ParticleTypes.DAMAGE_INDICATOR, player.getX(), player.getY() + 0.5D, player.getZ(), aim.x * 10 + i, aim.y * 10 + i, aim.z * 10 + i);
            }
//
//            for (float i = 2; i < -2; i-= 0.05) {
//                world.addParticle(ParticleTypes.DAMAGE_INDICATOR, player.getX(), player.getY() + 0.5D, player.getZ(), aim.x * 10 - i, aim.y * 10 - i, aim.z * 10 - i);
//            }
        }
        return super.use(world, player, hand);
    }
}
