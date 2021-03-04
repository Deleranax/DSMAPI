package fr.dwightstudio.dsmapi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;

public class EventListener implements Listener {

    static private final HashMap<Player, MenuView> views = new HashMap<>();

    public static void register(MenuView view, Player player) {
        views.put(player, view);
    }

    public static void forget(MenuView view) {
        views.remove(view.getPlayer());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (views.containsKey((Player) event.getView().getPlayer())) {

            Player player = (Player) event.getView().getPlayer();

            MenuView view = views.get(player);

            if (event.getInventory() == view.getInventoryView().getTopInventory()) {

                DSMAPI.getInstance().getServer().getScheduler().runTask(DSMAPI.getInstance(), () -> view.getCurrentPage().onClick(view, event.getClick(), event.getRawSlot(), event.getCurrentItem()));

                event.setCancelled(true);
            }

        }
    }
}
