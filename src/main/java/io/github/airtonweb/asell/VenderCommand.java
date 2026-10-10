package io.github.airtonweb.asell;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VenderCommand implements CommandExecutor  {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      sender.sendMessage("Selling system coming soon!");
      return true;

    }
}



