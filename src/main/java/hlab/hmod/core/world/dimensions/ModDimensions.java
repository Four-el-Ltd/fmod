package hlab.hmod.core.world.dimensions;

import hlab.hmod.core.ExampleMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
  public static final RegistryKey<World> SUPER_DIM_KEY = RegistryKey.of(RegistryKeys.WORLD,
      new Identifier(ExampleMod.MODID, "super_world"));
  public static final RegistryKey<DimensionType> SUPER_DIM_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
      SUPER_DIM_KEY.getValue());

  public static void register() {

  }
}
