package org.bill.bot;

import net.dv8tion.jda.api.JDA;
import org.bill.bot.BotLogger;

public class CommandCleaner {

    public static void clearGlobalCommands(JDA jda) {
        BotLogger.logInfo("Clearing all global slash commands...");
        jda.updateCommands().queue(commands -> {
            commands.forEach(command -> {
                BotLogger.logInfo("Deleting global command: " + command.getName());
                command.delete().queue();
            });
            BotLogger.logInfo("All global commands cleared!");
        });
    }
}
