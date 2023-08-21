package hlab.hmod.core.items;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Rarity;
import hlab.hmod.core.ExampleMod;
import hlab.hmod.core.items.materials.GodToolMaterial;

public class ModItems implements ItemRegistryContainer {
  public static final Item debugpick = new MyPickaxeItem(GodToolMaterial.INSTANCE, 4, 1.0f,
      new OwoItemSettings().fireproof().group(ExampleMod.INSTRUMENTS_GROUP).rarity(Rarity.EPIC), true);
  public static final Item a = new Item(new OwoItemSettings());
  public static final Item stick = new SwordItem(GodToolMaterial.INSTANCE, 2147483647, 2.0f,
      new OwoItemSettings().group(ExampleMod.INSTRUMENTS_GROUP).rarity(Rarity.EPIC));
}
