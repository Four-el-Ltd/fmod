package hlab.hmod.core.util;

import hlab.hmod.core.network.ModPackets;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.network.PacketByteBuf;

public class MindData {
  public static int addMind(IEntityModNbtSaver player, int value) {
    NbtCompound nbt = player.getHmodData();
    int mind = nbt.getInt("mind");
    if (mind + value >= 50) {
      mind = 50;
    } else {
      mind += value;
    }
    nbt.putInt("mind", mind);
    return mind;
  }

  public static int removeMind(IEntityModNbtSaver player, int value) {
    NbtCompound nbt = player.getHmodData();
    int mind = nbt.getInt("mind");
    if (mind - value < 0) {
      mind = 0;
    } else {
      mind -= value;
    }
    nbt.putInt("mind", mind);
    return mind;
  }

  public static void syncMind(int mind, ServerPlayerEntity player) {
    PacketByteBuf buf = PacketByteBufs.create();
    buf.writeInt(mind);
    ServerPlayNetworking.send(player, ModPackets.MIND_SYNC_ID, buf);
  }
}
