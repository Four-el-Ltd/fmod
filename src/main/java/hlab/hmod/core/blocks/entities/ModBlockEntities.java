package hlab.hmod.core.blocks.entities;

import com.mojang.datafixers.types.Type;
import hlab.hmod.core.ExampleMod;
import hlab.hmod.core.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModBlockEntities {
    public static final BlockEntityType<BlastFurnaceEntity> BLAST_FURNACE_ENTITY_BLOCK_ENTITY_TYPE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ExampleMod.MODID, "blast_furnace"), FabricBlockEntityTypeBuilder.create(BlastFurnaceEntity::new, ModBlocks.blast_furnace).build());
}
