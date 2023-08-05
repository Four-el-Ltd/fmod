package hlab.hmod.core.items;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Items;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Rarity;
import hlab.hmod.core.ExampleMod;

public class ModItems implements ItemRegistryContainer {
  public static final Item debugpick = new PickaxeItem(GodToolMaterial.INSTANCE, 4, 1.0f,
      new OwoItemSettings().fireproof().group(ExampleMod.INSTRUMENTS_GROUP).rarity(Rarity.EPIC));
}

class GodToolMaterial implements ToolMaterial {
  @Override
  public int getDurability() {
    return -1;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return 20.0F;
  }

  @Override
  public float getAttackDamage() {
    return 20;
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
    return /* Ingredient.ofItems(Items.AIR); */ null;
  }

  public static final GodToolMaterial INSTANCE = new GodToolMaterial();
}
