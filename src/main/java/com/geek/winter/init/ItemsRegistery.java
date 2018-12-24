package com.geek.winter.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import com.geek.winter.items.*;

public class ItemsRegistery {
	
	/**
	 *
	 */
	@ObjectHolder("winter:fakesnowballitem")
	public static final Item FakeSnowBallItem = new FakeSnowBallItem();
	
	@ObjectHolder("winter:snowstone_ingot")
	public static final Item IngotSnowy = new IngotSnowy();

}
