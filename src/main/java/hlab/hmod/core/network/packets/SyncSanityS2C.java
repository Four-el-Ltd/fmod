package hlab.hmod.core.network.packets;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;

public class SyncSanityS2C {

  public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf,
      PacketSender responseSender) {
    int sanityLevel = buf.readInt();

  }
}
