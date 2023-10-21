package hlab.hmod.core.energy;

import net.minecraft.block.entity.BlockEntity;

public interface IEnergyConductor extends IEnergyConnector {
  public IPowerNet getPowerNet();

  public void setPowerNet(IPowerNet network);

  public default int getId() {
    return getIdFromBlockEntity((BlockEntity) this);
  }

  public static int getIdFromBlockEntity(BlockEntity be) {
    return getIdFromCoord(be.getPos().getX(), be.getPos().getY(), be.getPos().getZ());
  }

  public static int getIdFromCoord(int x, int y, int z) {
    final int prime = 99999;
    int result = 1;

    result = prime * result + x;
    result = prime * result + y;
    result = prime * result + z;
    return result;
  }
}
