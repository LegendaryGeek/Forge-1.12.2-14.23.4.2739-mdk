package geek.legendarywinter.util;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.init.ItemsRegistery;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GeekTab extends CreativeTabs {

	public static GeekTab instance = null;

	public GeekTab() {
		super(LegendaryWinter.MODID);

		// TODO Auto-generated constructor stub
	}

	public static void init() {
		instance = new GeekTab();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemsRegistery.polarium_ingot);
	}

	public CreativeTabs getCTab() {
		return this;
	}

}
