package org.bill;

import org.bill.bot.BotConfig;
import org.bill.bot.BotLogger;
import org.bill.commands.PingCommand;
import net.dv8tion.jda.api.JDA;
import org.bill.bot.CommandCleaner;

public class Main {

    public static void main(String[] args) {
        String guildId = BotConfig.getGuildId();

        if (guildId == null) {
            BotLogger.logError("Guild ID is not set. Please check your environment variables.");
            return;
        }

        try {
            JDA jda = BotConfig.getBuilder(BotConfig.getToken())
                    .addEventListeners(new PingCommand())
                    .build();
            BotLogger.logInfo("Bot is running!");

            CommandCleaner.clearGlobalCommands(jda);
        } catch (Exception e) {
            BotLogger.logError("Failed to start the bot: " + e.getMessage());
            // e.printStackTrace();
        }
    }
}
