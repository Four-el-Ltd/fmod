package hlab.hmod.core.util;

import hlab.hmod.core.ExampleMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public class SanityManager {
  public int sanityLevel = 20;

  public void addSanity(int amount) {
    this.sanityLevel = Math.min(amount + this.sanityLevel, 20);
  }

  public void setSanity(int amount) {
    this.sanityLevel = amount;
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
    if (this.sanityLevel == 0) {
      player.kill();
    }
  }
}
