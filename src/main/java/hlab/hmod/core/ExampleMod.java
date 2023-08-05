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

import hlab.hmod.core.items.ModItems;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("hmod-core");
	public static final OwoItemGroup INSTRUMENTS_GROUP = OwoItemGroup.builder(new Identifier("hmod", "instruments"),
			() -> Icon.of(new ItemStack(Items.IRON_PICKAXE))).build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		INSTRUMENTS_GROUP.initialize();
		FieldRegistrationHandler.register(ModItems.class, "hmod", false);
	}
}
