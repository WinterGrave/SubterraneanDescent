package zairus.subterraneandescent.block;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.subterraneandescent.SubterraneanDescent;

public class SDBlocks
{
	static
	{
		;
	}
	
	public static void register()
	{
		;
	}
	
	protected static void registerBlock(Block block, String name, Class<? extends TileEntity> teClazz, String id, boolean model)
	{
		SubterraneanDescent.proxy.registerBlock(block, name, teClazz, id, model);
	}
	
	@SuppressWarnings("unused")
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
