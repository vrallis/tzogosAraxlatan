package org.bill.commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.bill.bot.BotLogger;
import org.bill.bot.BotConfig;

public class PingCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            event.reply("Pong!").queue();
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        JDA jda = event.getJDA();
        String guildId = BotConfig.getGuildId();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Guild guild = jda.getGuildById(guildId);
        if (guild != null) {
            BotLogger.logInfo("Registering slash commands for guild: " + guild.getName());

            // Clear existing commands to prevent duplicates
            guild.updateCommands().queue(v -> {
                BotLogger.logInfo("Cleared old commands");
                guild.updateCommands().addCommands(
                        Commands.slash("ping", "Replies with Pong!")
                ).queue();
            });
        } else {
            BotLogger.logError("Guild not found with ID: " + guildId);
        }
    }
}
