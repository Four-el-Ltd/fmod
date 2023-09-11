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

  }

  @Override
  public SanityManager getSanityManager() {
    return this.sanityManager;
  }

}
