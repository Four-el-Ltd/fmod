package hlab.hmod.core.items.guns;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

import net.minecraft.world.World;

public class GunItem extends Item {
  int damage;
  int distance;

  public GunItem(Settings s, int distance, int damage) {
    super(s);
    this.distance = distance;
    this.damage = damage;
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack itemStack = user.getActiveItem();
    HitResult hit = user.raycast(this.distance, 1.0F, false);
    switch (hit.getType()) {
      case MISS:
        break;

      case BLOCK:
        break;

      case ENTITY:
        EntityHitResult entityHit = (EntityHitResult) hit;
        entityHit.getEntity().damage(null, this.damage);

    }
    return TypedActionResult.success(itemStack);
  }

}
