package org.nationsatwar.seymour;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class FoodStatsLoadingPlugin implements IFMLLoadingPlugin {

	@Override
	public String[] getASMTransformerClass() {
		return new String[]{FoodStatsTransformer.class.getName()};
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
