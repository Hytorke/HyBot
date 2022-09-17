package fr.hytorke;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class HyBot {

    private final ShardManager shardManager;
    private final Dotenv config;

    public HyBot() throws LoginException {
        config = Dotenv.configure().load();

        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token)
                .setActivity(Activity.watching("Hybot SNAPSHOT-V1.0"))
                .setStatus(OnlineStatus.ONLINE);

        shardManager = builder.build();
    }

    public static void main(String[] args) {
        try {
            HyBot bot = new HyBot();
        } catch (LoginException e) {
            System.out.println("ERROR AT LAUNCHING : The provided token is invalide");
        }
    }
}
