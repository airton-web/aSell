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
        player.sendMessage("§4§lMAGMAMC §8» §7Venda realizada com sucesso!");
        player.sendMessage("§7Seus itens foram vendidos por §a%valor% coins§7.");

        return true;

    }
}



