package hlab.hmod.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import hlab.hmod.core.util.IEntityModNbtSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements IEntityModNbtSaver {
  @Unique
  public NbtCompound HmodData;

  @Override
  public NbtCompound getHmodData() {
    if (this.HmodData == null) {
      this.HmodData = new NbtCompound();
    }
    return HmodData;
  }

  @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
  public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo info) {
    nbt.put("HmodData", HmodData);
  }

  @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
  public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo info) {
    HmodData = nbt.getCompound("HmodData");
  }

}
