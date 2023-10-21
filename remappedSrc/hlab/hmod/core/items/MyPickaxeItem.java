package hlab.hmod.core.items;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ItemStack;

public class MyPickaxeItem extends PickaxeItem {
  private boolean _isenchantable;

  public MyPickaxeItem(ToolMaterial material, int AttackDamage, float attackSpeed, Item.Settings settings,
      boolean _isenchantable) {
    super(material, AttackDamage, attackSpeed, settings);
    this._isenchantable = _isenchantable;
  }

  @Override
  public boolean isEnchantable(ItemStack stack) {
    return _isenchantable;
  }
}
