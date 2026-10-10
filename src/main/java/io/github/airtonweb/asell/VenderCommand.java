package io.github.airtonweb.asell;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class VenderCommand implements CommandExecutor  {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando");
            return true;
        }

        if ( !sender.hasPermission("asell.vender")) {
            sender.sendMessage("§cvocê não tem permissão para usar este comando.");
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage("§4§lMAGMAMC §8➜ §7Venda realizada com sucesso!");
        player.sendMessage("§7seus itens foram vendidos por §a%valor% coins§7.");
         return true;
    }
}



