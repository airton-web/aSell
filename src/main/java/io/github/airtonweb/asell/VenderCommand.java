package io.github.airtonweb.asell;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class VenderCommand implements CommandExecutor  {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Apenas jogadores podem executar este comando");
            return true;
        }
            Player player = (Player) sender;
            player.sendMessage("Olá " + player.getName() + " Seu comando foi executado com sucesso");
            return true;
    }
}



