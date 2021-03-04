package fr.dwightstudio.dsmapi.commands;

import fr.dwightstudio.dsmapi.Menu;
import fr.dwightstudio.dsmapi.MenuView;
import fr.dwightstudio.dsmapi.pages.Page;
import fr.dwightstudio.dsmapi.pages.PageType;
import fr.dwightstudio.dsmapi.utils.ItemCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TestMenu extends Menu {

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

                content[1][4] = new ItemCreator(Material.APPLE).setName("Give Apple").getItem();
                content[2][8] = new ItemCreator(Material.ARROW).setName("Next Page").getItem();

                return getType().flatten(content);
            }

            @Override
            public PageType getType() {
                return PageType.CHEST;
            }

            @Override
            public void onClick(MenuView view, ClickType clickType, int slot, ItemStack itemStack) {
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

                ItemStack[][] content = getType().getBlank2DArray();

                content[1][4] = new ItemCreator(Material.OAK_SIGN).setName("Apparently, it is working").getItem();
                content[3][0] = new ItemCreator(Material.ARROW).setName("Previous Page").getItem();
                content[3][8] = new ItemCreator(Material.ARROW).setName("Next Page").getItem();

                return getType().flatten(content);
            }

            @Override
            public PageType getType() {
                return PageType.CHEST_PLUS;
            }

            @Override
            public void onClick(MenuView view, ClickType clickType, int slot, ItemStack itemStack) {
                switch (itemStack.getType()) {
                    case OAK_SIGN:
                        view.getPlayer().sendMessage("Yes, it is working well.");
                        break;
                    case ARROW:
                        if (itemStack.getItemMeta().getDisplayName().equals("Next Page")) {
                            view.nextPage();
                        } else {
                            view.previousPage();
                        }
                        break;
                }
            }
        };

        pages[2] = new Page() {
            @Override
            public String getName() {
                return ChatColor.GREEN + "" + ChatColor.ITALIC + "DSMAPI testing menu last page";
            }

            @Override
            public ItemStack[] getContent() {
                ItemStack[][] content = getType().getBlank2DArray();

                content[1][1] = new ItemCreator(Material.BEACON).setName("Run away!").getItem();
                content[2][0] = new ItemCreator(Material.ARROW).setName("Previous Page").getItem();

                return getType().flatten(content);
            }

            @Override
            public PageType getType() {
                return PageType.DISPENSER;
            }

            @Override
            public void onClick(MenuView view, ClickType clickType, int slot, ItemStack itemStack) {
                switch (itemStack.getType()) {
                    case BEACON:
                        view.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, true));
                        break;
                    case ARROW:
                        view.previousPage();
                        break;
                }
            }
        };

        return pages;
    }

    @Override
    public int getPageCount() {
        return 3;
    }
}
