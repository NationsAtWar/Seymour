package org.nationsatwar.seymour;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;

public class CustomFoodStats extends FoodStats {
    private int foodTimer;
	private int prevFoodLevel;

	/**
     * Handles the food game logic.
     */
    public void onUpdate(EntityPlayer par1EntityPlayer)
    {
        int i = par1EntityPlayer.worldObj.difficultySetting;
        this.prevFoodLevel = this.getFoodLevel();

        if (par1EntityPlayer.worldObj.getGameRules().getGameRuleBooleanValue("naturalRegeneration") && this.getFoodLevel() >= Seymour.startHeal && par1EntityPlayer.shouldHeal())
        {
            ++this.foodTimer;

            if (this.foodTimer >= 80)
            {
                par1EntityPlayer.heal(1.0F);
                this.addExhaustion(3.0F);
                this.foodTimer = 0;
            }
        }
        else if (this.getFoodLevel() <= 0)
        {
            ++this.foodTimer;

            if (this.foodTimer >= 80)
            {
                if (par1EntityPlayer.getHealth() > 10.0F || i >= 3 || par1EntityPlayer.getHealth() > 1.0F && i >= 2)
                {
                    par1EntityPlayer.attackEntityFrom(DamageSource.starve, 1.0F);
                }

                this.foodTimer = 0;
            }
        }
        else
        {
            this.foodTimer = 0;
        }
    }

}
