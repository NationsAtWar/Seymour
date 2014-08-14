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
	public static final String MODID = "Nations At War: Seymour";
	public static final String VERSION = "1.0";
	
	public static int startHeal;
	public static int stopHeal;
	
	//for 1.7
	//SeymourFeedMeHandler seymourEvents;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		startHeal = config.getBlock("StartHealing", 18).getInt();
		stopHeal = config.getBlock("StopHealing", 20).getInt();
		config.save();
	}
	
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	 //this.seymourEvents = new SeymourFeedMeHandler();
    	 //MinecraftForge.EVENT_BUS.register(this.seymourEvents);
    }
}