package zairus.subterraneandescent;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import zairus.subterraneandescent.command.server.CommandTeleport;
import zairus.subterraneandescent.world.SDDimensions;

@Mod(modid = SDConstants.MOD_ID, name = SDConstants.MOD_ID, version = SDConstants.MOD_VERSION)
public class SubterraneanDescent
{
	@Mod.Instance(SDConstants.MOD_ID)
	public static SubterraneanDescent instance;
	
	@SidedProxy(clientSide = SDConstants.CLIENT_PROXY, serverSide = SDConstants.COMMON_PROXY)
	public static SDProxy proxy;
	
	//public static PacketPipeline packetPipeline = new PacketPipeline();
	
	private static Logger logger;
	
	//Creative tabs
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		SDConfig.init(event.getSuggestedConfigurationFile());
		
		SubterraneanDescent.proxy.preInit(event);
		
		SDDimensions.register();
		
		//SDSoundEvents.register();
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
		SubterraneanDescent.proxy.init(event);
		//SubterraneanDescent.packetPipeline.initalise();
		
		SubterraneanDescent.proxy.initBuiltinShapes();
		
		//SDCraftingHandler.addRecipes();
		/*
		SDEvents eventHandler = new SDEvents();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		MinecraftForge.TERRAIN_GEN_BUS.register(eventHandler);
		MinecraftForge.ORE_GEN_BUS.register(eventHandler);
		
		SDAchievementList.initPages();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(SubterraneanDescent.instance, new GuiHandler());
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
		event.registerServerCommand(new CommandTeleport());
	}
	
	public static void logInfo(String message)
	{
		logger.info(message);
	}
}
