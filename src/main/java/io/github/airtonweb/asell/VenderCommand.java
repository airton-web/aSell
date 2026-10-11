package io.github.airtonweb.asell;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.function.Function;

public class VenderCommand implements CommandExecutor {

    private final Prices prices = new Prices();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando");
            return true;
        }

        if (!sender.hasPermission("asell.vender")) {
            sender.sendMessage("§cVocê não tem permissão para usar este comando.");
            return true;
        }

        Player player = (Player) sender;

        // /vender sozinho: ensina como usar
        if (args.length == 0) {
            player.sendMessage("§cUse: /vender minerios ou /vender farm");
            return true;
        }

        if (args[0].equalsIgnoreCase("minerios")) {
            sell(player, prices::getOrePrice);
        } else if (args[0].equalsIgnoreCase("farm")) {
            sell(player, prices::getFarmPrice);
        } else {
            player.sendMessage("§cUse: /vender minerios ou /vender farm");
        }

        return true;
    }

    // Vende os itens do inventário usando a "forma de achar o preço" recebida
    private void sell(Player player, Function<Material, Double> priceFinder) {
        PlayerInventory inventory = player.getInventory();
        ItemStack[] contents = inventory.getStorageContents();

        double total = 0;
        int soldItems = 0;

        for (int slot = 0; slot < contents.length; slot++) {
            ItemStack item = contents[slot];
            if (item == null) {
                continue;
            }

            double price = priceFinder.apply(item.getType());
            if (price <= 0) {
                continue;
            }

            total += price * item.getAmount();
            soldItems += item.getAmount();
            inventory.setItem(slot, null);
        }

        player.sendMessage("§7Você vendeu §a" + soldItems + " itens §7por §a" + total + " coins§7.");
    }
}