package io.github.airtonweb.asell;

import io.github.airtonweb.aeconomy.api.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class aSell extends JavaPlugin {

    @Override
    public void onEnable() {
        // Pergunta ao servidor: "quem oferece o serviço Economy?"
        RegisteredServiceProvider<Economy> registration =
                getServer().getServicesManager().getRegistration(Economy.class);

        if (registration == null) {
            getLogger().severe("aEconomy não encontrado! Desativando o aSell.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        Economy economy = registration.getProvider();

        // Entrega a economia ao comando
        getCommand("vender").setExecutor(new VenderCommand(economy));

        Bukkit.getConsoleSender().sendMessage("§2[aSell] §aPlugin ativado com sucesso!");
        Bukkit.getConsoleSender().sendMessage("§2[aSell] §aVersão do Plugin: " + getPluginMeta().getVersion());
        Bukkit.getConsoleSender().sendMessage("§2[aSell] §aVersão Minecraft: " + Bukkit.getMinecraftVersion());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§4[aSell] §cPlugin desligado!");
    }
}