package hlab.hmod.core.blocks.machines;

import com.mojang.serialization.MapCodec;
import hlab.hmod.core.blocks.entities.BlastFurnaceEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BlastFurnace extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<BlastFurnace> CODEC = createCodec(BlastFurnace::new);

    public BlastFurnace(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlastFurnaceEntity(pos, state);
    }

}
