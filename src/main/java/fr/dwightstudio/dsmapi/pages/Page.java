package fr.dwightstudio.dsmapi.pages;

import com.sun.istack.internal.Nullable;
import fr.dwightstudio.dsmapi.MenuView;
import org.bukkit.inventory.ItemStack;

public interface Page {

    /**
     * Get the name of the page.
     * If the name is null, the name of the menu would be used.
     *
     * @return the name of the page
     */
    String getName();

    /**
     * Get the whole content of the page at this moment (it may be animated).
     *
     * @return an array of the items
     */
    ItemStack[] getContent();

    /**
     * @return the type of the page
     */
    PageType getType();

    /**
     * Method called when the player click on a slot.
     *
     * @param slot the index of the clicked slot
     */
    void onClick(MenuView view, int slot);

    /**
     * Method called when the player click on an item.
     * This item can be null.
     *
     * @param itemStack the clicked item
     */
    void onClick(MenuView view, @Nullable ItemStack itemStack);
}
