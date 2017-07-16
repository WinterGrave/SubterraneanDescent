package zairus.subterraneandescent.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.subterraneandescent.SDConstants;
import zairus.subterraneandescent.SubterraneanDescent;

public class SDBlocks
{
	public static final Block MANTLE;
	
	static
	{
		MANTLE = new Block(Material.ROCK).setRegistryName(new ResourceLocation(SDConstants.MODID, "mantle_stone")).setUnlocalizedName("mantle_stone");
	}
	
	public static void register()
	{
		registerBlock(MANTLE, "mantle_stone");
	}
	
	protected static void registerBlock(Block block, String name, Class<? extends TileEntity> teClazz, String id, boolean model)
	{
		SubterraneanDescent.proxy.registerBlock(block, name, teClazz, id, model);
	}
	
	private static void registerBlock(Block block, String name)
	{
		SubterraneanDescent.proxy.registerBlock(block, name, true);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient()
	{
		;
	}
}
