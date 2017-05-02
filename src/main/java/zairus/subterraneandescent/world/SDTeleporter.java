package zairus.subterraneandescent.world;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class SDTeleporter extends Teleporter
{
	public SDTeleporter(WorldServer world)
	{
		super(world);
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entity, float rotationYaw)
	{
		return true;
	}
}
