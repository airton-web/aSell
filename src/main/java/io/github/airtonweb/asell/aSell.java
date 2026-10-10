package io.github.airtonweb.asell;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Classe principal do plugin.
 *
 * - "package" precisa bater com as pastas onde o arquivo está:
 *   src/main/java/io/github/airtonweb/asell/
 * - "extends JavaPlugin" faz a classe herdar tudo que um plugin precisa.
 * - O nome desta classe (aSell) precisa ser IGUAL, letra por letra,
 *   ao final do campo "main" do plugin.yml.
 */
public final class aSell extends JavaPlugin {


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§2[aSell] §aPlugin ativado com sucesso!");
        Bukkit.getConsoleSender().sendMessage("§2[aSell] §aVersão do Plugin: " +  getPluginMeta().getVersion());
        getCommand("vender").setExecutor(new VenderCommand());
    }

    // Chamado quando o servidor desliga o plugin
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§4[aSell] §cPlugin desligado!");
    }
}

