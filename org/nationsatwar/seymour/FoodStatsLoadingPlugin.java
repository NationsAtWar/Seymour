package org.nationsatwar.seymour;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@TransformerExclusions({"tutorial.asm"})
@MCVersion(value = "1.6.4")
public class FoodStatsLoadingPlugin implements IFMLLoadingPlugin {

	@Override
	public String[] getASMTransformerClass() {
		//return new String[]{FoodStatsTransformer.class.getName()};
		return new String[] {SeymourAccessTransformer.class.getName()};
	}

	@Override
	public String getModContainerClass() {
		return Seymour.class.getName();
	}

	@Override
	public String getSetupClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		// TODO Auto-generated method stub
		
	}
}
