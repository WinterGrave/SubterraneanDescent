package zairus.subterraneandescent.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import zairus.subterraneandescent.world.SDDimensions;

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
			
			SDDimensions.teleportPlayerToDimension(server, player, SDDimensions.SD_LEVEL1);
		}
	}
}
