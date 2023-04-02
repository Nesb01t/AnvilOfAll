package icu.nesb01t.anvilofall.events;

import icu.nesb01t.anvilofall.AnvilOfAll;
import icu.nesb01t.anvilofall.utils.AnvilUtils;
import org.bukkit.Bukkit;
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
        // GUI 类型为铁砧
        if (event.getInventory().getType() == InventoryType.ANVIL) {
            // 点击第0、1个槽位
            Inventory anvil = event.getClickedInventory();
            if (event.getSlot() != 2) {
                AnvilUtils.setAnvilOutItem(anvil); // 设置铁砧第二格物品
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.getLogger().info("111");
                    }
                }.runTaskLater(AnvilOfAll.plugin, 10L);

            } else {
                // 点击第2个槽位
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