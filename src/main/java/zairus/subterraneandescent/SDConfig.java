package zairus.subterraneandescent;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class SDConfig
{
	public static Configuration configuration;
	
	public static int dimension1_id = 572;
	
	public static void init(File cFile)
	{
		configuration = new Configuration(cFile);
		
		configuration.load();
		
		dimension1_id = configuration.getInt("dimension1_id", "DIMENSIONS", dimension1_id, 1, Integer.MAX_VALUE, "Sets dimension ID for dimension 1.");
		
		configuration.save();
	}
}
