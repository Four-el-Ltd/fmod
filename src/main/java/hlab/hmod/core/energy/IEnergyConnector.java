package hlab.hmod.core.energy;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public interface IEnergyConnector {
  public long transferPower(long power);

  public long getPower();

  public long getMaxPower();

  public default void tryConnect(World world, int x, int y, int z) {
    final BlockEntity be = world.getBlockEntity(new BlockPos(x, y, z));
    if (be instanceof IEnergyConnector) {
      IEnergyConnector con = (IEnergyConnector) be;
    }
  }
}
