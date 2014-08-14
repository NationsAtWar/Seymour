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
public class Seymour extends DummyModContainer {
	public static final String MODID = "Nations At War - Seymour";
	public static final String VERSION = "1.0";
	
	public static int startHeal;
	public static int stopHeal;
	private SeymourFeedMeHandler seymourEvents;
	
	public Seymour() {
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = Seymour.MODID;
		meta.name = Seymour.MODID;
		meta.version = Seymour.VERSION;
		meta.credits = "";
		meta.authorList = Arrays.asList("Nations At War Team");
		meta.description = "";
		meta.url = "https://github.com/NationsAtWar/Seymour";
		meta.updateUrl = "";
		meta.screenshots = new String[0];
		meta.logoFile = "";
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		startHeal = config.getBlock("StartHealing", 2).getInt();
		stopHeal = config.getBlock("StopHealing", 20).getInt();
		config.save();
	}
	
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	 this.seymourEvents = new SeymourFeedMeHandler();
    	 MinecraftForge.EVENT_BUS.register(this.seymourEvents);
    }
}
