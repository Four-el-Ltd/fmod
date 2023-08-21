package hlab.hmod.core.network.packet;

import hlab.hmod.core.util.IEntityModNbtSaver;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class MindSyncPacket {
  public static void send(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf,
      PacketSender sender) {
    ((IEntityModNbtSaver) client.player).getHmodData().putInt("mind", buf.readInt());
  }
}
