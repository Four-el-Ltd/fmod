package hlab.hmod.core.blocks;

import io.wispforest.owo.registration.reflect.BlockRegistryContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModBlocks implements BlockRegistryContainer {
  @NoBlockItem
  public static final Block EMPTY_BLOCK = new Block(FabricBlockSettings.create()) {
    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
      return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
      return BlockRenderType.INVISIBLE;
    }
  };

  @Override
  public BlockItem createBlockItem(Block block, String identifier) {
    return new BlockItem(block, new Item.Settings());
  }

}
