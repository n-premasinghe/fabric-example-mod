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
        if (world.isClient()) {
            world.addParticle(ParticleTypes.DAMAGE_INDICATOR, player.getX(),player.getY(), player.getZ(), aim.x, aim.y, aim.z);
            System.out.println("Right Clicked!");
        }
        return super.use(world, player, hand);
    }
}
