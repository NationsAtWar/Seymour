package org.nationsatwar.seymour;

import com.google.common.eventbus.Subscribe;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;


public class SeymourFeedMeHandler {
	CustomFoodStats food = new CustomFoodStats();
	
	@ForgeSubscribe
	public void checkUpdate(LivingUpdateEvent updateEvent) {
		if(!(updateEvent.entity instanceof EntityPlayer))
			return;
		
		EntityPlayer player = (EntityPlayer) updateEvent.entity;
		food.onUpdate(player);
		
	}
}
