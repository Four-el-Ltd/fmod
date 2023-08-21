package hlab.hmod.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
  @Unique
  public int mindValue = 50;

  @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
  public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo info) {
    nbt.putInt("mind", mindValue);
  }

  @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
  public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo info) {
    mindValue = nbt.getInt("mind");
  }

  public void setMind(int value) {
    if (value <= 50 && value >= 0) {
      mindValue = value;
    }
  }

}
