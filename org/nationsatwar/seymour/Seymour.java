package org.nationsatwar.seymour;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Seymour.MODID, version = Seymour.VERSION)
public class Seymour extends DummyModContainer {
	public static final String MODID = "Nations At War - Seymour";
	public static final String VERSION = "alpha-1.0";
	
	public static int startHeal;
	public static int stopHeal;
	private SeymourFeedMeHandler seymourEvents;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		startHeal = config.get("Healrate", "StartHealing", 2).getInt();
		stopHeal = config.get("Healrate", "StopHealing", 18).getInt();
		config.save();
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	 this.seymourEvents = new SeymourFeedMeHandler();
    	 MinecraftForge.EVENT_BUS.register(this.seymourEvents);
    }
}
