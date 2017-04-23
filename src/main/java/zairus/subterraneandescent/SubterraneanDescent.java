package zairus.subterraneandescent;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import zairus.subterraneandescent.block.SDBlocks;
import zairus.subterraneandescent.item.SDItems;
import zairus.subterraneandescent.proxy.CommonProxy;

@Mod(modid = SDConstants.MODID, name = SDConstants.MODID, version = SDConstants.VERSION)
public class SubterraneanDescent
{
	@Mod.Instance(SDConstants.MODID)
	public static SubterraneanDescent instance;
	
	@SidedProxy(clientSide = SDConstants.CLIENT_PROXY, serverSide = SDConstants.COMMON_PROXY)
	public static CommonProxy proxy;
	
	//public static PacketPipeline packetPipeline = new PacketPipeline();
	
	public static Logger logger;
	
	//Creative tabs
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		SDConfig.init(event.getSuggestedConfigurationFile());
		
		SubterraneanDescent.proxy.preInit(event);
		
		//HTSoundEvents.register();
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
		SubterraneanDescent.proxy.init(event);
		//Hermitron.packetPipeline.initalise();
		
		SDItems.register();
		SDBlocks.register();
		
		SubterraneanDescent.proxy.initBuiltinShapes();
		
		//HTCraftingHandler.addRecipes();
		/*
		HTEvents eventHandler = new HTEvents();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		MinecraftForge.TERRAIN_GEN_BUS.register(eventHandler);
		MinecraftForge.ORE_GEN_BUS.register(eventHandler);
		
		HTAchievementList.initPages();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Hermitron.instance, new GuiHandler());
		*/
    }
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		SubterraneanDescent.proxy.postInit(event);
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		//event.registerServerCommand(new CommandScore());
	}
}
