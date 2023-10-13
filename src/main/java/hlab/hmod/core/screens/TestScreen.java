package hlab.hmod.core.screens;

import hlab.hmod.core.ExampleMod;
import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.FlowLayout;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TestScreen extends BaseUIModelScreen<FlowLayout> {

  public TestScreen() {
    super(FlowLayout.class, DataSource.asset(new Identifier(ExampleMod.MODID, "test_ui")));
  }

  @Override
  protected void build(FlowLayout rootComponent) {
    rootComponent.childById(ButtonComponent.class, "the-knopka").onPress(button -> {
      ExampleMod.LOGGER.info(MinecraftClient.getInstance().getSession().getUsername());
    });
  }

}
