package hlab.hmod.core.registry;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Rarity;
import hlab.hmod.core.ExampleMod;
import hlab.hmod.core.items.*;
import hlab.hmod.core.items.guns.GunItem;
import hlab.hmod.core.items.materials.GodToolMaterial;
import hlab.hmod.core.items.rawores.TinRawOre;

public class ModItems implements ItemRegistryContainer {
  public static final Item debugpick = new MyPickaxeItem(GodToolMaterial.INSTANCE, 4, 1.0f,
      new OwoItemSettings().fireproof().group(ExampleMod.INSTRUMENTS_GROUP).rarity(Rarity.EPIC), true);
  public static final Item a = new Item(new OwoItemSettings());
  public static final GunItem xyi = new GunItem(new OwoItemSettings(), 100, 10000);
  public static final Item stick = new SwordItem(GodToolMaterial.INSTANCE, 2147483647, 2.0f,
      new OwoItemSettings().group(ExampleMod.INSTRUMENTS_GROUP).rarity(Rarity.EPIC));
  public static final Item raw_zinc = new Item(new OwoItemSettings());
  public static final Item raw_tungsten = new Item(new OwoItemSettings());
  public static final Item raw_aluminium = new Item(new OwoItemSettings());
  public static final Item raw_lead = new Item(new OwoItemSettings());
  public static final Item raw_tin = new TinRawOre(new OwoItemSettings());
  public static final Item zinc_ingot = new Item(new OwoItemSettings());
  public static final Item tungsten_ingot = new Item(new OwoItemSettings());
  public static final Item aluminium_ingot = new Item(new OwoItemSettings());
  public static final Item lead_ingot = new Item(new OwoItemSettings());
  public static final Item tin_ingot = new Item(new OwoItemSettings());
}
