package fr.lobbycore.xloxtv.events;

import fr.lobbycore.xloxtv.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TeleportEvent implements Listener {

    Main main;


    private ItemStack getItem(String name, Material material, String[] lore) {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta m = it.getItemMeta();
        m.setDisplayName(name);
        m.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        m.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        m.setLore(Arrays.asList(lore));
        it.setItemMeta(m);
        return it;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack itm = e.getItem();
            if(itm.getType() == Material.NETHER_STAR) {
                Inventory inv = Bukkit.createInventory(null, 27, "§cMenu de téléportation");

                inv.setItem(12, getItem("§cServeur RolePlay", Material.DIAMOND_SWORD, new String[] {"§cINFO:", "§4test"}));

                e.getPlayer().openInventory(inv);
            }
        }
    }




}
