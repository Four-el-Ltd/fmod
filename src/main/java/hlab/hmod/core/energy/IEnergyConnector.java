package hlab.hmod.core.energy;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public interface IEnergyConnector {
  public long transferPower(long power);

  public long getPower();

  public long getMaxPower();

  public long getTransferWeight();

  public default void trySubscribe(World world, int x, int y, int z) {
    final BlockEntity be = world.getBlockEntity(new BlockPos(x, y, z));
    if (be instanceof IEnergyConductor) {
      IEnergyConductor con = (IEnergyConductor) be;
      if (con.getPowerNet() != null) {
        con.getPowerNet().subscribe(this);
      }
    }
  }
}
