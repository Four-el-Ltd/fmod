package hlab.hmod.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import hlab.hmod.core.util.SanityManager;
import hlab.hmod.core.util.SanityManagerAccesor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements SanityManagerAccesor {
  private SanityManager sanityManager = new SanityManager();

  protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
    super(entityType, world);
  }

  @Inject(method = "writeCustomDataToNbt", at = @At(value = "RETURN"))
  public void hmod$writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
    this.sanityManager.writeNbt(nbt);
  }

  @Inject(method = "readCustomDataFromNbt", at = @At(value = "RETURN"))
  public void hmod$readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
    this.sanityManager.readNbt(nbt);
  }

  @Override
  public SanityManager getSanityManager() {
    return this.sanityManager;
  }

  @Inject(method = "tick()V", at = @At(value = "RETURN"))
  public void hmod$UpdateSanity() {
    PlayerEntity player = (PlayerEntity) (Object) this;
    this.sanityManager.update(player);
  }

}
