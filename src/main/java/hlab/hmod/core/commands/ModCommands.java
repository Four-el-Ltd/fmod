package hlab.hmod.core.commands;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static net.minecraft.server.command.CommandManager.literal;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.*;

import hlab.hmod.core.ExampleMod;
import hlab.hmod.core.util.SanityManager;
import hlab.hmod.core.util.SanityManagerAccesor;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class ModCommands {

  public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
    dispatcher.register(literal("setsanity")
        .then(argument("amount", integer(0, 20))
            .executes(ctx -> {
                ServerPlayerEntity player = ctx.getSource().getPlayer();
                if(player == null ) return 1;
                SanityManager sm = ((SanityManagerAccesor) player).getSanityManager();
                sm.setSanity(getInteger(ctx, "amount"));

                ctx.getSource().sendMessage(Text.of("Команд компмлитет епта"));
                return 1;

            })));
  }
}
