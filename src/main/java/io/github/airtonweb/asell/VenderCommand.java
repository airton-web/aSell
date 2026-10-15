package io.github.airtonweb.asell;

import io.github.airtonweb.aeconomy.api.Economy;                 // ← NOVO (1)
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
    private final Economy economy;                               // ← NOVO (2)

    // Construtor: recebe a economia que a classe principal encontrou
    public VenderCommand(Economy economy) {                      // ← NOVO (2)
        this.economy = economy;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // Porteiro 1: só jogadores
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando");
            return true;
        }

        // Porteiro 2: permissão geral do comando
        if (!sender.hasPermission("asell.vender")) {
            sender.sendMessage("§cVocê não tem permissão para usar este comando.");
            return true;
        }

        Player player = (Player) sender;

        // /vender sozinho: ensina como usar
        if (args.length == 0) {
            player.sendMessage("§cUse: /vender minerios, /vender farm ou /vender tudo");
            return true;
        }

        if (args[0].equalsIgnoreCase("minerios")) {
            // Porteiro 3: permissão da categoria minérios
            if (!player.hasPermission("asell.vender.minerios")) {
                player.sendMessage("§cVocê não tem permissão para vender minérios.");
                return true;
            }
            sell(player, prices::getOrePrice);

        } else if (args[0].equalsIgnoreCase("farm")) {
            // Porteiro 3: permissão da categoria farm
            if (!player.hasPermission("asell.vender.farm")) {
                player.sendMessage("§cVocê não tem permissão para vender itens de farm.");
                return true;
            }
            sell(player, prices::getFarmPrice);

        } else if (args[0].equalsIgnoreCase("tudo")) {
            // Porteiro 3: permissão própria do /vender tudo
            if (!player.hasPermission("asell.vender.tudo")) {
                player.sendMessage("§cVocê não tem permissão para vender tudo.");
                return true;
            }
            sell(player, prices::getAnyPrice);

        } else {
            player.sendMessage("§cUse: /vender minerios, /vender farm ou /vender tudo");
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

        if (soldItems == 0) {
            player.sendMessage("§cVocê não tem itens para vender.");
            return;
        }

        // O dinheiro vai para o saldo do jogador no aEconomy      // ← NOVO (3)
        economy.addBalance(player.getUniqueId(), "coins", total);

        player.sendMessage("§7Você vendeu §a" + soldItems + " itens §7por §a" + total + " coins§7.");
    }
}