/*
 * package hlab.hmod.core.util;
 * 
 * import hlab.hmod.core.network.SyncHandler;
 * import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
 * import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
 * import net.minecraft.nbt.NbtCompound;
 * import net.minecraft.server.network.ServerPlayerEntity;
 * import net.minecraft.util.Identifier;
 * import net.minecraft.network.PacketByteBuf;
 * import net.minecraft.network.packet.s2c.play.CustomPayloadS2CPacket;
 * 
 * public class MindData {
 * 
 * public static int addMind(IEntityModNbtSaver player, int value) {
 * NbtCompound nbt = player.getPersistanceData();
 * int mind = nbt.getInt("mind");
 * if (mind + value >= 50) {
 * mind = 50;
 * } else {
 * mind += value;
 * }
 * nbt.putInt("mind", mind);
 * syncMind(mind, (ServerPlayerEntity) player);
 * return mind;
 * }
 * 
 * public static int removeMind(IEntityModNbtSaver player, int value) {
 * NbtCompound nbt = player.getPersistanceData();
 * int mind = nbt.getInt("mind");
 * if (mind - value < 0) {
 * mind = 0;
 * } else {
 * mind -= value;
 * }
 * nbt.putInt("mind", mind);
 * syncMind(mind, (ServerPlayerEntity) player);
 * return mind;
 * }
 * 
 * public static void syncMind(int mind, ServerPlayerEntity player) {
 * PacketByteBuf buf = PacketByteBufs.create();
 * buf.writeInt(mind);
 * player.networkHandler.sendPacket(new
 * CustomPayloadS2CPacket(SyncHandler.MIND_SYNC_ID, buf));
 * }
 * }
 */
