package com.crystalneko.better_end_rod.Items;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.util.NonNullList;

public class removalMaterial extends Item {
    public static removalMaterial INSTANCE = new removalMaterial();
    
    public int getDurability() {
        return 30;
    }

    
    public float getMiningSpeedMultiplier() {
        return 3.0F;
    }

    
    public float getAttackDamage() {
        return 3.0F;
    }

    
    public int getMiningLevel() {
        return 1;
    }

    
    public int getEnchantability() {
        return 15;
    }

    
    public NonNullList getRepairIngredient() {
        return NonNullList.from(Items.QUARTZ);
    }
}
