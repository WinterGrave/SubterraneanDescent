package zairus.subterraneandescent.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import zairus.subterraneandescent.SDConfig;
import zairus.subterraneandescent.world.SDTeleporter;

public class CommandTeleport extends CommandBase
{
	@Override
	public String getName()
	{
		return "sd_teleport";
	}
	
	@Override
	public String getUsage(ICommandSender sender)
	{
		return "";
	}
	
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (sender != null && sender instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)sender;
			
			SDTeleporter teleporter = new SDTeleporter(server.worldServerForDimension(SDConfig.dimension1_id));
			
			PlayerList players = server.getPlayerList();
			players.transferPlayerToDimension(player, SDConfig.dimension1_id, teleporter);
		}
	}
}
