package hlab.hmod.core.network;

import hlab.hmod.core.ExampleMod;
import hlab.hmod.core.network.packets.SyncSanityS2C;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
  public static final Identifier SANITY_S2C_SYNC = new Identifier(ExampleMod.MODID, "sanity_sync");

  public static void registerS2CPackets() {
    ClientPlayNetworking.registerGlobalReceiver(SANITY_S2C_SYNC, SyncSanityS2C::receive);
  }

  public static void registerC2SPackets() {

  }
}
