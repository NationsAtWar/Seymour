package org.nationsatwar.seymour;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;

public class CustomFoodStats extends FoodStats {
	private int foodTimer = 0;
	
	/**
     * Handles the food game logic.
     */
    public void onUpdate(EntityPlayer player) {
        if (player.worldObj.getGameRules().getGameRuleBooleanValue("naturalRegeneration") && 
        		player.getFoodStats().getFoodLevel() >= Seymour.startHeal && 
        		player.getFoodStats().getFoodLevel() < Seymour.stopHeal &
        		player.shouldHeal()) {
            ++this.foodTimer;

            if (this.foodTimer >= 80) {
        		System.out.println("Update."+player.getHealth()+" / "+player.getFoodStats().getFoodLevel());
                player.heal(1.0F);
                player.getFoodStats().addExhaustion(3.0F);
                this.foodTimer = 0;
            }
        }
    }

}
