package hlab.hmod.core.network;

import hlab.hmod.core.ExampleMod;
import hlab.hmod.core.network.packet.MindSyncPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
  public static final Identifier MIND_SYNC_ID = new Identifier(ExampleMod.MODID, "mind_sync");

  public static void registerS2CPackets() {
    ClientPlayNetworking.registerGlobalReceiver(MIND_SYNC_ID, MindSyncPacket::send);
  }
}
