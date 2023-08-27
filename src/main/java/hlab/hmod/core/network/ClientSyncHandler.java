package hlab.hmod.core.network;

import hlab.hmod.core.util.IEntityModNbtSaver;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ClientSyncHandler {
  @Environment(EnvType.CLIENT)
  public static void init() {
    ClientPlayNetworking.registerGlobalReceiver(SyncHandler.MIND_SYNC_ID, (client, handler, buf, respondeSender) -> {
      int mind = buf.readInt();
      client.execute(() -> {
        IEntityModNbtSaver player = (IEntityModNbtSaver) client.player;
        player.getHmodData().putInt("mind", mind);
      });

    }

    );
  }

}
