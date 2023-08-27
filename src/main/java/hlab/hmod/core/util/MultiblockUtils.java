package hlab.hmod.core.util;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MultiblockUtils {

  public static boolean isAvalibleForStructure(int startxCoord, int startyCoord, int startzCoord, int endxCoord,
      int endyCoord, int endzCoord, World world) {
    for (int x = startxCoord; x < endxCoord; x++) {
      for (int y = startyCoord; y < endyCoord; y++) {
        for (int z = startzCoord; z < endzCoord; z++) {
          if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.AIR) {

          } else {
            return false;
          }
        }
      }
    }
    return true;
  }
}
