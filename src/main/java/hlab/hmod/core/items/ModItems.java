package hlab.hmod.core.items;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Rarity;
import hlab.hmod.core.ExampleMod;

public class ModItems implements ItemRegistryContainer {
  public static final Item debugpick = new PickaxeItem(ToolMaterials.NETHERITE, 4, 1.0f,
      new OwoItemSettings().fireproof().group(ExampleMod.INSTRUMENTS_GROUP).rarity(Rarity.EPIC));
}
