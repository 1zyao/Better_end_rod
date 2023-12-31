package com.crystalneko.better_end_rod.toolItems;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class removalMaterial implements ToolMaterial {
    public static removalMaterial INSTANCE = new removalMaterial();
    @Override
    public int getDurability() {
        return 30;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 3.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.QUARTZ);
    }
}
