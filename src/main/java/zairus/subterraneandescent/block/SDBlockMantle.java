package zairus.subterraneandescent.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SDBlockMantle extends Block
{
	protected SDBlockMantle()
	{
		super(Material.ROCK);
		setHardness(1.5F);
		setResistance(12.0F);
		setSoundType(SoundType.STONE);
		
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
