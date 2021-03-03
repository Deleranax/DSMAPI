package fr.dwightstudio.dsmapi.utils;

import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCreator {

	private ItemStack item;
	private Player possesseur;
	private String creator_name;
	private ArrayList<String> tag;
	private int slot;

	private ArrayList<Pattern> patterns;

	public ItemCreator(Material material) {
		item = new ItemStack(material);
	}

	public ItemStack getItem() {
		return item;
	}

	public Material getMaterial() {
		return item.getType();
	}

	public ItemCreator setUnbreakable(Boolean unbreakable) {
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(unbreakable);
		item.setItemMeta(meta);
		return this;
	}
	
	public ItemCreator setMaterial(Material material) {
		if (item == null) {
			item = new ItemStack(material);
		} else {
			item.setType(material);
		}
		return this;
	}

	public Integer getAmount() {
		return item.getAmount();
	}

	public ItemCreator setAmount(Integer amount) {
		item.setAmount(amount);
		return this;
	}

	public Short getDurability() {
		return item.getDurability();
	}

	public Integer getDurabilityInteger() {
		return (int) item.getDurability();
	}

	public ItemCreator setDurability(Short durability) {
		item.setDurability(durability);
		return this;
	}

	public ItemCreator setDurability(Integer durability) {
		Short shortdurability = ((short) ((int) durability));
		item.setDurability(shortdurability);
		return this;
	}

	public ItemMeta getMeta() {
		return item.getItemMeta();
	}

	public ItemCreator setMeta(ItemMeta meta) {
		item.setItemMeta(meta);
		return this;
	}

	public String getName() {
		return item.getItemMeta().getDisplayName();
	}

	public ItemCreator setName(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}

	public ArrayList<String> getLores() {
		return (ArrayList<String>) item.getItemMeta().getLore();
	}

	public ItemCreator setLores(List<String> list) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(list);
		item.setItemMeta(meta);
		return this;
	}

	public ItemCreator clearLores() {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(new ArrayList<String>());
		item.setItemMeta(meta);
		return this;
	}

	public ItemCreator insertLores(String lore, Integer position) {
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lores = (ArrayList<String>) meta.getLore();
		if (lores == null) {
			lores = new ArrayList<>();
		}
		lores.add(position, lore);
		meta.setLore(lores);
		item.setItemMeta(meta);
		return this;
	}

	public ItemCreator addLore(String lore) {
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lores = (ArrayList<String>) meta.getLore();
		if (lores == null) {
			lores = new ArrayList<>();
		}
		if (lore != null) {
			lores.add(lore);
		} else {
			lores.add(" ");
		}
		meta.setLore(lores);
		item.setItemMeta(meta);
		return this;
	}

	public ItemCreator removeLore(String lore) {
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lores = (ArrayList<String>) meta.getLore();
		if (lores != null) {
			if (lores.contains(lore)) {
				lores.remove(lore);
				meta.setLore(lores);
				item.setItemMeta(meta);
			}
		}
		return this;
	}

	public String[] getTableauLores() {
		String[] tableaulores = new String[] {};
		if (item.getItemMeta().getLore() != null) {
			Integer i = 0;
			for (String lore : item.getItemMeta().getLore()) {
				tableaulores[i] = lore;
				i++;
			}
		}
		return tableaulores;
	}

	public ItemCreator setTableauLores(String[] lores) {
		ArrayList<String> tableaulores = new ArrayList<>();
		for (String lore : lores) {
			tableaulores.add(lore);
		}
		ItemMeta meta = item.getItemMeta();
		meta.setLore(tableaulores);
		item.setItemMeta(meta);
		return this;
	}

	public ItemCreator replaceallLores(String replacelore, String newlore) {
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lores = (ArrayList<String>) meta.getLore();
		if (lores != null) {
			if (lores.contains(replacelore)) {
				for (Integer i = 0; i < lores.size(); i++) {
					String lore = lores.get(i);
					if (lore.equals(replacelore)) {
						lores.remove(i);
						lores.add(i, newlore);
					}
				}
				meta.setLore(lores);
				item.setItemMeta(meta);
			}
		}
		return this;
	}

	public ItemCreator replaceoneLore(Integer ligne, String newlore) {
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lores = (ArrayList<String>) meta.getLore();
		if (lores != null) {
			if (lores.get(ligne) != null) {
				lores.remove(ligne);
				lores.add(ligne, newlore);
				meta.setLore(lores);
				item.setItemMeta(meta);
			}
		}
		return this;
	}

	public ItemCreator replacefirstLores(String replacelore, String newlore, Integer nombre) {
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lores = (ArrayList<String>) meta.getLore();
		if (lores != null) {
			if (lores.contains(replacelore)) {
				Integer replaced = 0;
				for (Integer i = 0; i < lores.size(); i++) {
					if (lores.get(i).equals(replacelore)) {
						lores.remove(i);
						lores.add(i, newlore);
						replaced++;
						if (replaced >= nombre) {
							break;
						}
					}
				}
				meta.setLore(lores);
				item.setItemMeta(meta);
			}
		}
		return this;
	}

	public ItemCreator replacelastLores(String replacelore, String newlore, Integer nombre) {
		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lores = (ArrayList<String>) meta.getLore();
		if (lores != null) {
			if (lores.contains(replacelore)) {
				Integer replaced = 0;
				for (Integer i = lores.size() - 1; i >= 0; i--) {
					if (lores.get(i).equals(replacelore)) {
						lores.remove(i);
						lores.add(i, newlore);
						replaced++;
						if (replaced >= nombre) {
							break;
						}
					}
				}
				meta.setLore(lores);
				item.setItemMeta(meta);
			}
		}
		return this;
	}
}