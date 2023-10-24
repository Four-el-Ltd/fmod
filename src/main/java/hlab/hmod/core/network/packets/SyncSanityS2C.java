package hlab.hmod.core.network.packets;

import hlab.hmod.core.mixin.PlayerEntityMixin;
import hlab.hmod.core.util.SanityManager;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;

public class SyncSanityS2C {

  public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf,
      PacketSender responseSender) {
    int sanityLevel = buf.readInt();
    PlayerEntity player = (PlayerEntity) client.player;
    SanityManager sanityManager = ((PlayerEntityMixin) (Object) player).getSanityManager();
    sanityManager.setSanity(sanityLevel);
  }
}
