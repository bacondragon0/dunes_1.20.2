package name.mod.item.custom;

import name.mod.item.ModToolMaterial;
import name.mod.particle.ModParticles;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.sensor.NearestLivingEntitiesSensor;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.structure.StrongholdGenerator;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.io.Console;

import static net.minecraft.entity.damage.DamageTypes.PLAYER_ATTACK;

public class SandWindStaffItem extends SwordItem {

    private boolean canjump = false;
    public SandWindStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(ModToolMaterial.DUNES, 5, -2, settings);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity.isOnGround()) {canjump = true;}
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, SoundEvents.ITEM_TRIDENT_HIT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        canjump = true;
        target.addVelocity(0,0.7,0);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,10,1,false,false));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,10,5,false,false));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,10,1,false,false));
        stack.damage(1, attacker, p -> p.sendToolBreakStatus(attacker.getActiveHand()));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (canjump) {
            canjump = false;
            user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(user.getActiveHand()));
            user.addVelocity(user.getRotationVector().x * 0.1,(user.getRotationVector().y * 1.1) + 0.05,user.getRotationVector().z * 0.1);
            for(int i = 0; i < 60; i++) {
                if(i % 2 == 0) {
                    world.addParticle(ModParticles.SANDWIND_PARTICLE,
                            user.getX() + 0, user.getY() -0.2, user.getZ() + 0,
                            Math.cos(i) * 0.1d, 0.0d, Math.sin(i) * 0.1d);
                }
            }
        }
        return super.use(world, user, hand);
    }
}
