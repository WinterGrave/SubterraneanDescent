package zairus.subterraneandescent.world;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zairus.subterraneandescent.world.gen.SDChunkProviderBase;

public class SDWorldProviderBase extends WorldProvider
{
	@Override
	public DimensionType getDimensionType()
	{
		return SDDimensions.SD_LEVEL1;
	}
	
	@Override
	protected void init()
	{
		super.init();
		this.hasSkyLight = false;
		this.biomeProvider = new SDBiomeProvider(this.world.getWorldInfo());
	}
	
	@Override
	public IChunkGenerator createChunkGenerator()
	{
		return new SDChunkProviderBase(this.world);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float x, float z)
	{
		return new Vec3d(0.231372549D, 0.180392157D, 0.121568627D);
	}
	
	@Override
	protected void generateLightBrightnessTable()
	{
		for (int i = 0; i <= 15; ++i)
		{
			float f1 = 1.0F - (float)i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 0.9F + 0.1F;
		}
	}
	
	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}
	
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks)
	{
		return 0.5F;
	}
	
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z)
	{
		return true;
	}
}
