package zairus.subterraneandescent.world;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import zairus.subterraneandescent.SDConfig;
import zairus.subterraneandescent.SDConstants;

public class SDDimensions
{
	public static final DimensionType SD_LEVEL1 = DimensionType.register(
			SDConstants.MODID, 
			"_level1", 
			SDConfig.dimension1_id, 
			SDWorldProviderBase.class, 
			false);
	
	public static void register()
	{
		DimensionManager.registerDimension(SDConfig.dimension1_id, SD_LEVEL1);
	}
	
	public static void teleportPlayerToDimension(MinecraftServer server, EntityPlayerMP player, DimensionType dimension)
	{
		SDTeleporter teleporter = new SDTeleporter(server.worldServerForDimension(SDConfig.dimension1_id));
		PlayerList players = server.getPlayerList();
		players.transferPlayerToDimension(player, dimension.getId(), teleporter);
	}
}
