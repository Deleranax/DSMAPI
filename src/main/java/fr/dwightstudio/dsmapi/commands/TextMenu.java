package fr.dwightstudio.dsmapi.commands;

import fr.dwightstudio.dsmapi.Menu;
import fr.dwightstudio.dsmapi.MenuView;
import fr.dwightstudio.dsmapi.pages.Page;
import fr.dwightstudio.dsmapi.pages.PageType;
import fr.dwightstudio.dsmapi.utils.ItemCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TextMenu extends Menu {

    @Override
    public String getName() {
        return ChatColor.GREEN + "" + ChatColor.ITALIC + "DSMAPI testing menu";
    }

    @Override
    public Page[] getPages() {
        Page[] pages = new Page[3];

        pages[0] = new Page() {
            @Override
            public String getName() {
                return ChatColor.GREEN + "" + ChatColor.ITALIC + "DSMAPI testing menu page 1";
            }

            @Override
            public ItemStack[] getContent() {

                ItemStack[][] content = getType().getBlank2DArray();

                content[4][1] = new ItemCreator(Material.APPLE).setName("Give Apple").getItem();
                content[8][2] = new ItemCreator(Material.ARROW).setName("Next Page").getItem();

                return getType().flatten(content);
            }

            @Override
            public PageType getType() {
                return PageType.CHEST;
            }

            @Override
            public void onClick(MenuView view, int slot) {

            }

            @Override
            public void onClick(MenuView view, ItemStack itemStack) {
                switch (itemStack.getType()) {
                    case APPLE:
                        view.getPlayer().getInventory().addItem(new ItemStack(Material.APPLE));
                        break;
                    case ARROW:
                        view.nextPage();
                        break;
                }
            }
        };

        pages[1] = new Page() {
            @Override
            public String getName() {
                return ChatColor.GREEN + "" + ChatColor.ITALIC + "DSMAPI testing menu page 2";
            }

            @Override
            public ItemStack[] getContent() {
                return new ItemStack[0];
            }

            @Override
            public PageType getType() {
                return PageType.CHEST_PLUS;
            }

            @Override
            public void onClick(MenuView view, int slot) {

            }

            @Override
            public void onClick(MenuView view, ItemStack itemStack) {

            }
        };

        pages[2] = new Page() {
            @Override
            public String getName() {
                return ChatColor.GREEN + "" + ChatColor.ITALIC + "DSMAPI testing menu last page";
            }

            @Override
            public ItemStack[] getContent() {
                return new ItemStack[0];
            }

            @Override
            public PageType getType() {
                return PageType.DISPENSER;
            }

            @Override
            public void onClick(MenuView view, int slot) {

            }

            @Override
            public void onClick(MenuView view, ItemStack itemStack) {

            }
        };

        return pages;
    }

    @Override
    public int getPageCount() {
        return 0;
    }
}
