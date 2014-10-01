package org.nationsatwar.seymour;

import com.google.common.eventbus.Subscribe;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;


public class SeymourFeedMeHandler {
	@ForgeSubscribe
	public void checkSpawn(EntityJoinWorldEvent event) {
		if(!(event.entity instanceof EntityPlayer))
			return;
		
		EntityPlayer player = (EntityPlayer) event.entity;
		player.foodStats = new CustomFoodStats();
		
	}
}
