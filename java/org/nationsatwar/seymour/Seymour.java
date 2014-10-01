package org.nationsatwar.seymour;

import java.util.Arrays;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Seymour.MODID, version = Seymour.VERSION, name = Seymour.MODID)
public class Seymour {
	public static final String MODID = "Nations At War - Seymour";
	public static final String VERSION = "1.0.1";

	public static int startHeal;
	public static int stopHeal;
	private SeymourFeedMeHandler seymourEvents;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		startHeal = config.get(config.CATEGORY_GENERAL, "startHealing", 2).getInt(2);
		stopHeal = config.get(config.CATEGORY_GENERAL, "stopHealing", 20).getInt(20);
		config.save();
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	System.out.println("Registered and loaded with heals at" + Seymour.startHeal + "-" + Seymour.stopHeal);
    	this.seymourEvents = new SeymourFeedMeHandler();
		MinecraftForge.EVENT_BUS.register(this.seymourEvents);
    }
}
