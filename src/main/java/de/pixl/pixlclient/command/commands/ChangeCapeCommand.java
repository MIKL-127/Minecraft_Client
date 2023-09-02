package de.pixl.pixlclient.command.commands;

import de.pixl.pixlclient.Client;
import de.pixl.pixlclient.command.AbstractCommand;
import de.pixl.pixlclient.cosmetics.cape.Cape;

public class ChangeCapeCommand extends AbstractCommand {
    @Override
    protected void execute(String command, String[] args) {
        if (args.length != 1) {
            chat("§cUsage: !cape <Cape>");
            return;
        }
        Cape cape = Cape.fromName(args[0]);
        if (cape == null) {
            chat("§cThis Cape does not exist!");
            return;
        }
        Client.capeManager.setActive(cape);
        chat("§aSuccessfully changed cape!");
    }
}
