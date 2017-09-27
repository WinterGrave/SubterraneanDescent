package zairus.subterraneandescent.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zairus.subterraneandescent.SDConstants;
import zairus.subterraneandescent.SDProxy;
import zairus.subterraneandescent.block.SDBlocks;

@Mod.EventBusSubscriber(modid = SDConstants.MOD_ID)
public class SDProxyClient extends SDProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}
	
	@Override
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		SDBlocks.registerModels();
	}
	/*
	public void registerModel(Item item, int meta, String name)
	{
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation(SDConstants.MOD_ID + ":" + name, "inventory");
		
		renderItem.getItemModelMesher().register(item, meta, modelResourceLocation);
		
		if (meta == 0)
			ModelBakery.registerItemVariants(item, new ResourceLocation(SDConstants.MOD_ID, name));
	}
	*/
	@Override
	public void initBuiltinShapes()
	{
		MinecraftForge.EVENT_BUS.register(this);
		
		BlockModelShapes shapes = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes();
		
		shapes.registerBuiltInBlocks(new Block[] { });
	}
}
