package hlab.hmod.core.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GodToolMaterial implements ToolMaterial {

  @Override
  public int getDurability() {
    return 999999999;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return 20f;
  }

  @Override
  public float getAttackDamage() {
    return 20f;
  }

  @Override
  public int getMiningLevel() {
    return 8;
  }

  @Override
  public int getEnchantability() {
    return 60;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return null;
  }

  public static final GodToolMaterial INSTANCE = new GodToolMaterial();
}
