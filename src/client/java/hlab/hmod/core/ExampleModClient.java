package hlab.hmod.core;

import net.fabricmc.api.ClientModInitializer;
import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		SpecialModelLoaderEvents.LOAD_SCOPE
				.register(location -> ExampleMod.MODID.equals(location.getNamespace()));

		// This entrypoint is suitable for setting up client-specific logic, such as
		// rendering.
	}
}
