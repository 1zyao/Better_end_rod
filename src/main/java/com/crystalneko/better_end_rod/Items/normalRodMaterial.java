package com.crystalneko.better_end_rod.Items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;

public class normalRodMaterial extends Item {
    public static final normalRodMaterial INSTANCE = new normalRodMaterial();

    public int getMaxUses() {
        return 20;  // 修复材料的耐久度，可以根据需要调整
    }

    public float getEfficiency() {
        return 3.0F;  // 挖掘速度
    }

    public float getAttackDamage() {
        return 3.0F;  // 攻击伤害
    }

    public int getHarvestLevel() {
        return 1;  // 挖掘等级
    }

    public int getEnchantability() {
        return 15;  // 附魔能力
    }

    public NonNullList getRepairMaterial() {
        return NonNullList.from(Item.getItemFromBlock(Blocks.END_ROD));  // 修复材料，此处使用末地烛
    }
}
