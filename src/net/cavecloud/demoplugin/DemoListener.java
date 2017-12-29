package net.cavecloud.demoplugin;

import net.cavecloud.cloud.plugin.eventloader.EventHandler;
import net.cavecloud.cloud.plugin.eventloader.EventPriority;
import net.cavecloud.cloud.plugin.eventloader.Listener;
import net.cavecloud.cloud.plugin.events.CloudCommandEvent;
import net.cavecloud.cloud.plugin.events.ServerStartEvent;
import net.cavecloud.cloud.server.Server;

public class DemoListener implements Listener {

    /*
     * This methode will be executed when the user types in a command.
     *
     * You can set an EventPriority to change the priority of this listener.
     * (Default: NORMAL)
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCloudCommandEvent(CloudCommandEvent event) {

        // Check the command string
        if (event.getCommand().equalsIgnoreCase("mycommand")) {
            /*
             * Check the argument lenght
             *
             * In this case as example: mycommand arg1 arg2
             */
            if (event.getArguments().length == 2) {
                // Execute what you want to do.
                System.out.println("Command: mycommand");
                System.out.println("Arguments: " + event.getArguments().toString());
            } else {
                // Send help page if the arguments are not right.
                event.sendHelp();
            }
        }
    }


    /*
     * This mehtode will be executed when a server starts.
     */
    @EventHandler
    public void onServerStartEvent(ServerStartEvent event) {
        // Execute your code here!

        Server server = event.getServer();
        System.out.println("ServerStartEvent: " + server.serverGroup.getName() + "-" + server.id);
    }

}