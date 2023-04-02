package icu.nesb01t.anvilofall.events;

import icu.nesb01t.anvilofall.utils.AnvilUtils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AnvilOpenEvent implements Listener {
    @EventHandler
    public void onAnvilOpen(InventoryOpenEvent event) {
        if (event.getInventory().getType() == InventoryType.ANVIL) {
            Inventory anvil = event.getInventory();
            AnvilUtils.setAnvilOutItem(anvil); // 设置铁砧第二格物品
        }
    }
}
