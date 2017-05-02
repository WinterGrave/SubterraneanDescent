package zairus.subterraneandescent.world;

import java.util.List;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.storage.WorldInfo;

public class SDBiomeProvider extends BiomeProvider
{
	public SDBiomeProvider(WorldInfo info)
	{
		super(info);
	}
	
	@Override
	public List<Biome> getBiomesToSpawnIn()
	{
		return super.getBiomesToSpawnIn();
	}
}
