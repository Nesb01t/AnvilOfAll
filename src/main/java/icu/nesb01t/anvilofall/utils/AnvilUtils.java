package icu.nesb01t.anvilofall.utils;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AnvilUtils {
    public static void setAnvilOutItem(Inventory inv) {
        if (inv.getType() == InventoryType.ANVIL) {
            ItemStack confirm = new ItemStack(Material.PAPER);
            inv.setItem(2, confirm);
        }
    }
}
