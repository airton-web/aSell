package io.github.airtonweb.asell;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class Prices {

    // Tabela de minérios e tabela de farm: tipo do item -> preço de 1 unidade
    private final Map<Material, Double> orePrices = new HashMap<>();
    private final Map<Material, Double> farmPrices = new HashMap<>();

    public Prices() {
        // Minérios.
        orePrices.put(Material.COAL, 1.0);
        orePrices.put(Material.COPPER_INGOT, 5.0);
        orePrices.put(Material.IRON_INGOT, 10.0);
        orePrices.put(Material.GOLD_INGOT, 20.0);
        orePrices.put(Material.LAPIS_LAZULI, 30.0);
        orePrices.put(Material.REDSTONE, 40.0);
        orePrices.put(Material.QUARTZ, 50.0);
        orePrices.put(Material.AMETHYST_SHARD, 60.0);
        orePrices.put(Material.DIAMOND, 70.0);
        orePrices.put(Material.EMERALD, 80.0);
        orePrices.put(Material.NETHERITE_INGOT, 90.0);

        // Plantações.
        farmPrices.put(Material.WHEAT, 1.0);
        farmPrices.put(Material.CARROT, 1.0);
        farmPrices.put(Material.POTATO, 1.0);
        farmPrices.put(Material.BEETROOT, 1.0);
        farmPrices.put(Material.SUGAR_CANE, 1.5);
        farmPrices.put(Material.PUMPKIN, 2.0);
        farmPrices.put(Material.MELON_SLICE, 0.5);
        farmPrices.put(Material.CACTUS, 1.0);
        farmPrices.put(Material.BAMBOO, 0.5);
        farmPrices.put(Material.NETHER_WART, 3.0);
        farmPrices.put(Material.COCOA_BEANS, 2.0);
    }

    // Devolve o preço de 1 minério, ou 0 se não for vendável
    public double getOrePrice(Material material) {
        return orePrices.getOrDefault(material, 0.0);
    }

    // Devolve o preço de 1 item de farm, ou 0 se não for vendável
    public double getFarmPrice(Material material) {
        return farmPrices.getOrDefault(material, 0.0);
    }
}