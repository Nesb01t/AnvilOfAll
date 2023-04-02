package icu.nesb01t.anvilofall.events;

import icu.nesb01t.anvilofall.AnvilOfAll;
import icu.nesb01t.anvilofall.utils.AnvilUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class AnvilClickEvent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.ANVIL) {
            Inventory anvil = event.getClickedInventory();
            if (event.getSlot() == 0) { // 第一格
                return;
            } else if (event.getSlot() == 1) { // 第二格
                ItemStack item = event.getInventory().getItem(1);
                Player player = (Player) event.getWhoClicked();
                player.sendMessage(item.getItemMeta().getDisplayName());
            } else { // 确认
                ItemStack item = event.getInventory().getItem(0);
                ItemStack material = event.getInventory().getItem(1);
                if (item != null && material != null) {
                    item.setDurability((short) 0); // 耐久设置
                    event.getInventory().setItem(0, item); // 恢复物品
                    event.setCancelled(true); // 取消事件
                }
            }
        }
    }
}