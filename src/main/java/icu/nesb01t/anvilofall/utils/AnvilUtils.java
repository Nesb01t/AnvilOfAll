package icu.nesb01t.anvilofall.utils;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class AnvilUtils {
    /**
     * 设置铁砧产出物品
     */
    public static void setAnvilOutItem(Inventory inv) {
        if (inv.getType() == InventoryType.ANVIL) {
            ItemStack confirm = new ItemStack(Material.PAPER);
            inv.setItem(2, confirm);
        }
    }

    /**
     * 判断需要修复的物品类型
     */
    static List<String> keyItems = Arrays.asList("WOODEN", "STONE", "GOLDEN", "IRON", "DIAMOND");

    public static String getFixItemType(Inventory inv) {
        if (inv.getType() == InventoryType.ANVIL) {
            String name = inv.getItem(0).getType().name();
            for (String key : keyItems) {
                if (name.contains(key)) {
                    return name;
                }
            }
        }
        return "NONE";
    }
}
