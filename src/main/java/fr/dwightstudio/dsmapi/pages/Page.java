package fr.dwightstudio.dsmapi.pages;

import fr.dwightstudio.dsmapi.MenuView;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public interface Page {

    /**
     * Gets the name of the page.
     * If the name is null, the name of the menu would be used.
     *
     * @return the name of the page
     */
    String getName();

    /**
     * Gets the whole content of the page at this moment (it may be animated).
     *
     * @return an array of the items
     */
    ItemStack[] getContent();

    /**
     * @return the type of the page
     */
    PageType getPageType();

    /**
     * Method called when the player click on an item.
     * This item can be null.
     *
     * @param view the current MenuView
     * @param clickType the type of the click
     * @param slot the slot when the click was located
     * @param itemStack the clicked item
     */
    void onClick(MenuView view, ClickType clickType, int slot, ItemStack itemStack);
}
