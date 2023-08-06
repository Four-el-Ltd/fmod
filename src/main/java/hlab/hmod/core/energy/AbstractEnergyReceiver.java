package hlab.hmod.core.energy;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public abstract class AbstractEnergyReceiver extends Block implements IEnergyBaseNode, IEnergyReceiver {
  protected float energy = 0;

  private AbstractEnergyReceiver(AbstractBlock.Settings settings) {
    super(settings);
  }

  @Override
  public final void addEnergy(float energy) {
    this.energy += energy;
  }

  public final boolean receive(float e) {
    if (e <= getMaxEnergy() - energy) {
      addEnergy(e);
      return true;
    } else {
      return false;
    }
  }
}
