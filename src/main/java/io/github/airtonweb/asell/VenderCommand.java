package io.github.airtonweb.asell;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


public class VenderCommand implements CommandExecutor  {
    private final Prices prices = new Prices();


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
        PlayerInventory inventory = player.getInventory();
        ItemStack[] contents = inventory.getStorageContents();

        double total = 0;
        int soldItems = 0;
        for (int slot = 0; slot < contents.length; slot++) {
            ItemStack item = contents[slot];
            if (item == null) {
                continue;
            }
            double price = prices.getPrice(item.getType());
            if (price <= 0) {
                continue;
            }
            total += price * item.getAmount();
            soldItems += item.getAmount();
            inventory.setItem(slot, null);
        }
        player.sendMessage("§7Você vendeu §a" + soldItems + " itens §7por §a" + total + " coins§7.");
        return true;
    }
}



