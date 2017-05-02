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
		
		configuration.save();
	}
}
