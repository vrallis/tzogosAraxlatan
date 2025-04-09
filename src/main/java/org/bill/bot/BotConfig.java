package org.bill.bot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import java.util.EnumSet;

public class BotConfig {
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static JDABuilder getBuilder(String token) {
        return JDABuilder.createDefault(token, EnumSet.of(
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_VOICE_STATES
        ));
    }

    public static String getToken() {
        return dotenv.get("DISCORD_BOT_TOKEN");
    }

    // Fetch the guild ID from the environment variables
    public static String getGuildId() {
        return dotenv.get("DISCORD_GUILD_ID");
    }
}
