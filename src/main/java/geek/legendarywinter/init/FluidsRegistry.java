package geek.legendarywinter.init;

import geek.legendarywinter.LegendaryWinter;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;


public class FluidsRegistry {
	/**
	 *
	 */
	public static final Fluid FluidSnow = new Fluid("FluidSnow",
			new ResourceLocation(LegendaryWinter.MODID, "blocks/FluidSnow_still"),
			new ResourceLocation(LegendaryWinter.MODID, "blocks/FluidSnow_flow"));

	/**
	 *
	 */

	public static void init() {
		FluidSnow.setDensity(1);
		FluidSnow.setViscosity(1);
		FluidSnow.setTemperature(0);
		FluidSnow.setLuminosity(200);
		FluidSnow.setUnlocalizedName(LegendaryWinter.MODID + "." + "FluidSnow");
		FluidRegistry.registerFluid(FluidSnow);
		FluidRegistry.addBucketForFluid(FluidSnow);
	}
}
