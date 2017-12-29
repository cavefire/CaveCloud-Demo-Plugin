package net.cavecloud.demoplugin;

import net.cavecloud.cloud.CloudAPI;
import net.cavecloud.cloud.command.Command;
import net.cavecloud.cloud.plugin.CloudPlugin;
import net.cavecloud.cloud.server.Server;
import net.cavecloud.cloud.server.ServerGroup;
import net.cavecloud.cloud.utils.LogLevel;

public class Main extends CloudPlugin {

    @Override
    public void onEnable() {
        /*
         * This methode will be executed when the plugin is loaded by the cloud.
         */
        System.out.println(LogLevel.INFO + ": Demo plugin loaded!");

        /*
         * REGISTER A COMMAND
         *
         * Command Arguments:
         * 1. Command
         * 2. Argument placeholders "<Argument1> <Argument2>"
         * 3. Text for the help page
         *
         * When the command is executed by a user, the "CloudCommandEvent" is called. So you have to register
         * a listener to recognize the command.
         *
         */
        Command command = new Command("mycommand", "<Argument1> <Argument2>", "This is the help text.") {
        };
        CloudAPI.registerCommand(command);

        /*
         * Register a listener
         */
        CloudAPI.getPluginManager().registerEvents(this, new DemoListener());
    }

    @Override
    public void onDisable() {
        /*
         * This methode will be exeucted when the plugin is unloaded by the cloud.
         */
        System.out.println(LogLevel.INFO + ": Demo plugin unloaded!");
    }

    public void startServer() {
        ServerGroup serverGroup = CloudAPI.getServerGroup("LOBBY");
        Server server = CloudAPI.createServer(serverGroup);

        CloudAPI.startServer(server);
    }
}
