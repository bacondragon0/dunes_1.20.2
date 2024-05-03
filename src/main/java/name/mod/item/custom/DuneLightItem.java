package name.mod.item.custom;

import name.mod.entity.ModEntities;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DuneLightItem extends Item {


    public DuneLightItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isDay() && world instanceof ServerWorld serverWorld && user.getWorld().getBiome(user.getBlockPos()).isIn(BiomeTags.DESERT_PYRAMID_HAS_STRUCTURE)) {
            user.getWorld().playSoundFromEntity(null,user,SoundEvents.ENTITY_WITHER_SPAWN,SoundCategory.PLAYERS,1,1);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS,60,0,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,120,0,false,false));
            ModEntities.SANDWARRIOR.spawn(serverWorld, BlockPos.ofFloored(user.getPos().add(ThreadLocalRandom.current().nextInt(5,  10),5,ThreadLocalRandom.current().nextInt(5,  10))), SpawnReason.MOB_SUMMONED);
            ModEntities.SANDWARRIOR.spawn(serverWorld, BlockPos.ofFloored(user.getPos().add(ThreadLocalRandom.current().nextInt(10,  15),5,ThreadLocalRandom.current().nextInt(5,  10))), SpawnReason.MOB_SUMMONED);
            ModEntities.SANDWARRIOR.spawn(serverWorld, BlockPos.ofFloored(user.getPos().add(ThreadLocalRandom.current().nextInt(7,  12),5,ThreadLocalRandom.current().nextInt(5,  10))), SpawnReason.MOB_SUMMONED);
            user.getStackInHand(hand).decrement(1);
        }
        return super.use(world, user, hand);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.dune_tales.dune_light.tooltip").formatted(Formatting.DARK_PURPLE));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
