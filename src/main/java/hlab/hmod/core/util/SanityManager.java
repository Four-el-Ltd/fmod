package hlab.hmod.core.util;

import hlab.hmod.core.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SanityManager {
  private int sanityLevel = 20;
  private int timerDark = 0;
  private int timerCamp = 0;
  private int maxSanity = 20;

  public int getSanityLevel() {
    return this.sanityLevel;
  }

  public int getMaxSanity() {
    return this.maxSanity;
  }

  public void setMaxSanity(int amount) {
    this.maxSanity = amount;
  }

  public void addMaxSanity(int amount) {
    this.maxSanity += amount;
  }

  public void removeMaxSanity(int amount) {
    this.maxSanity -= amount;
  }

  public void addSanity(int amount) {
    this.sanityLevel = Math.min(amount + this.sanityLevel, maxSanity);
  }

  public void removeSanity(int amount) {
    this.sanityLevel = Math.max(this.sanityLevel - amount, 0);
  }

  public void setSanity(int amount) {
    if (amount <= 0) {
      this.sanityLevel = 0;
      return;
    }
    this.sanityLevel = Math.min(amount, maxSanity);
  }

  public void writeNbt(NbtCompound nbt) {
    NbtCompound compound = nbt.getCompound(ExampleMod.MODID);
    compound.putInt("Sanity", sanityLevel);
    nbt.put(ExampleMod.MODID, compound);
  }

  public void readNbt(NbtCompound nbt) {
    NbtCompound compound = nbt.getCompound(ExampleMod.MODID);
    this.setSanity(compound.getInt("Sanity"));
  }

  public void update(PlayerEntity player) {
    if (player.isCreative()) {
      this.setSanity(this.maxSanity);
      return;
    }
    if (this.sanityLevel == 0) {
      player.addStatusEffect(
          new StatusEffectInstance(Registries.STATUS_EFFECT.get(new Identifier("minecraft", "blindness")), 20));
    }
    if (this.timerDark > 120 && this.sanityLevel > 0) {
      this.removeSanity(1);
      this.timerDark = 0;
    } else if (this.sanityLevel == 0) {
      this.timerDark = 0;
    }

    if (player.getWorld().getLightLevel(player.getBlockPos()) <= 1) {
      this.timerDark++;
    }
    for (int x = player.getBlockX() - 16; x <= player.getBlockX() + 16; x++) {
      for (int z = player.getBlockZ() - 16; z <= player.getBlockZ() + 16; z++) {
        for (int y = player.getBlockY() - 1; y <= player.getBlockY() + 1; y++) {
          World world = player.getWorld();
          BlockPos pos = new BlockPos(x, y, z);
          BlockState state = world.getBlockState(pos);
          Block block = state.getBlock();
          if (block instanceof CampfireBlock) {
            this.timerCamp++;
            if (player.getName() == Text.of("darkemperorchik")) {
              player.getWorld().getServer().sendMessage(Text.of("Ы"));
            }
            if (this.timerCamp > 120) {
              this.timerCamp = 0;
              this.addSanity(1);
            }
            break;
          }
        }
      }
    }
  }
}
