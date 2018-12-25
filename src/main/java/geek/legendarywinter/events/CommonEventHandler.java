package geek.legendarywinter.events;

import geek.legendarywinter.LegendaryWinter;
import geek.legendarywinter.blocks.FakeSnow;
import geek.legendarywinter.blocks.OreSnowstone;
import geek.legendarywinter.blocks.SnowFurnace;
import geek.legendarywinter.blocks.Winterstone;
import geek.legendarywinter.init.BlocksRegistry;
import geek.legendarywinter.init.FluidsRegistry;
import geek.legendarywinter.items.FakeSnowball;
import geek.legendarywinter.items.IngotSnowstone;
import geek.legendarywinter.tileentity.WinterFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = {Side.CLIENT, Side.SERVER}, modid = LegendaryWinter.MODID)
public final class CommonEventHandler {

	/**
	 *
	 */
	
	
	
	private CommonEventHandler() {
		
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapBlock(final RegistryEvent.MissingMappings<Block> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Block> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void onRemapItem(final RegistryEvent.MissingMappings<Item> event) {
		for (final RegistryEvent.MissingMappings.Mapping<Item> mapping : event.getMappings()) {
			mapping.ignore();
		}
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(setupBlock(new OreSnowstone(), "snowstone_ore"));
		event.getRegistry().register(setupBlock(new FakeSnow(), "fakesnow"));
		event.getRegistry().register(setupBlock(new Winterstone(), "winterstone"));
		event.getRegistry().register(setupBlock(new SnowFurnace(false), "snowfurnace"));
		event.getRegistry().register(setupBlock(new SnowFurnace(true), "lit_snowfurnace"));
		GameRegistry.registerTileEntity(WinterFurnace.class, new ResourceLocation(LegendaryWinter.MODID + ":snowfurnace"));
		event.getRegistry().register(setupBlock(
				new BlockFluidClassic(FluidsRegistry.FluidSnow, Material.WATER), "fluidsnow"));
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(setupItemBlock(BlocksRegistry.OreSnow));
		event.getRegistry().register(setupItemBlock(BlocksRegistry.WinterStone));
		event.getRegistry().register(setupItemBlock(BlocksRegistry.FakeSnow));
		event.getRegistry().register(setupItemBlock(BlocksRegistry.SnowFurnace));
	  //event.getRegistry().register(setupItemBlock(BlocksRegistry.FluidSnow));
		event.getRegistry().register(setupItem(new FakeSnowball(), "fakesnowballitem"));
		event.getRegistry().register(setupItem(new IngotSnowstone(), "snowstone_ingot"));
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		//
	}

	/**
	 *
	 * @param block The Block.
	 * @param name The Name.
	 * @return The Block
	 */
	private static Block setupBlock(final Block block, final String name) {
		block.setRegistryName(name);
		block.setTranslationKey(LegendaryWinter.MODID + "." + name);
		return block;
	}

	/**
	 *
	 * @param block The Block.
	 * @return The ItemBlock.
	 */
	private static ItemBlock setupItemBlock(final Block block) {
		final ItemBlock itemBlock = new ItemBlock(block);
		final ResourceLocation name = block.getRegistryName();
		itemBlock.setRegistryName(name);
		LegendaryWinter.logger.fatal("!#!#!#! block registered as " + block.getRegistryName());

		return itemBlock;
	}

	/**
	 *
	 * @param item The Item.
	 * @param name The Name.
	 * @return The Item.
	 */
	private static Item setupItem(final Item item, final String name) {
		item.setRegistryName(name);
		item.setTranslationKey(LegendaryWinter.MODID + "." + name);
		LegendaryWinter.logger.fatal("!#!#!#! item registered as " + item.getRegistryName());

		return item;
	}
	
	
}