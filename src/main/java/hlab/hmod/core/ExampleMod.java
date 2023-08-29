package hlab.hmod.core;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import hlab.hmod.core.blocks.ModBlocks;
import hlab.hmod.core.items.ModItems;
import hlab.hmod.core.world.dimensions.ModDimensions;

public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("hmod-core");
	public static final String MODID = "hmod-core";
	public static final OwoItemGroup INSTRUMENTS_GROUP = OwoItemGroup.builder(new Identifier(MODID, "instruments"),
			() -> Icon.of(new ItemStack(Items.IRON_PICKAXE))).build();

	@Override
	public void onInitialize() {
		/*
		 * while (true) {
		 * Math.acos(Math.asin(Math.atan(Math.random() * 100 - 2 + 1)));
		 * }
		 */

		LOGGER.info("H-mod started");
		INSTRUMENTS_GROUP.initialize();
		FieldRegistrationHandler.register(ModItems.class, MODID, false);
		FieldRegistrationHandler.register(ModBlocks.class, MODID, false);

		ModDimensions.register();

	}
}
