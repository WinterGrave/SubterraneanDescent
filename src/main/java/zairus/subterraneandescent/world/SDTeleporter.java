package zairus.subterraneandescent.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class SDTeleporter extends Teleporter
{
	private final WorldServer tWorld;
	
	public SDTeleporter(WorldServer world)
	{
		super(world);
		this.tWorld = world;
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entity, float rotationYaw)
	{
		if (entity instanceof EntityPlayerMP)
		{
			((EntityPlayerMP)entity).connection.setPlayerLocation(entity.posX, 120, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		}
		else
		{
			entity.setLocationAndAngles(entity.posX, 120, entity.posZ, entity.rotationYaw, entity.rotationPitch);
		}
		
		BlockPos pos = new BlockPos(entity.posX, 120, entity.posZ);
		
		for (int x = -10; x < 11; ++x)
		{
			for (int z = -10; z < 11; ++z)
			{
				for (int y = 7; y >= 0; --y)
				{
					IBlockState state = this.tWorld.getBlockState(pos.add(x, y, z));
					
					if (state != Blocks.BEDROCK.getDefaultState() && state != Blocks.AIR.getDefaultState())
					{
						if (this.tWorld.rand.nextInt(3) == 0 || ((x > - 7 && x < 7) && (z > -7 && z < 7)))
							this.tWorld.setBlockToAir(pos.add(x, y, z));
					}
				}
			}
		}
		
		return true;
	}
}
