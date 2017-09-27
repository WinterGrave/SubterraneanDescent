package zairus.subterraneandescent.block;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import zairus.subterraneandescent.SDConstants;

@ObjectHolder(SDConstants.MOD_ID)
public class SDBlocks
{
	@ObjectHolder("mantle_stone")
	public static final Block MANTLE;
	
	static
	{
		MANTLE = new Block(Material.ROCK).setRegistryName(new ResourceLocation(SDConstants.MOD_ID, "mantle_stone")).setUnlocalizedName("mantle_stone");
	}
	
	public static void initialize()
	{
		;
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModels()
	{
		final Item[] blocks = {
				Item.getItemFromBlock(MANTLE)
		};
		
		for (final Item block : blocks)
		{
			ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation(SDConstants.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
		}
	}
	
	@Mod.EventBusSubscriber(modid = SDConstants.MOD_ID)
	public static class BlockRegistry
	{
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<ItemBlock>();
		
		@SubscribeEvent
		public static void newRegistry(final RegistryEvent.NewRegistry event)
		{
			;
		}
		
		@SubscribeEvent
		public static void register(final RegistryEvent.Register<Block> event)
		{
			final IForgeRegistry<Block> registry = event.getRegistry();
			
			final Block[] blocks = {
					MANTLE
			};
			
			registry.registerAll(blocks);
			
			/*for (final Block block : blocks)
			{
				registry.register(block);
				BLOCKS.add(block);
				
				initialize();
			}*/
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event)
		{
			final IForgeRegistry<Item> registry = event.getRegistry();
			
			final ItemBlock[] items = {
					new ItemBlock(MANTLE)
			};
			
			for (final ItemBlock item : items)
			{
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
		}
	}
	
	/*
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
	*/
}
