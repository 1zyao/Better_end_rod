package com.crystalneko.better_end_rod.enchantment;

import com.crystalneko.better_end_rod.CreativeTab;
import com.crystalneko.better_end_rod.ItemRegistryHandler;
import com.crystalneko.better_end_rod.Better_end_rod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class oily extends Enchantment {
    public oily() {
        super(Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        this.setName("oily");
        this.setRegistryName("oily");
    }

    public void onTargetDamaged(EntityLiving user, Entity target, int level) {

        super.onEntityDamaged(user, target, level);
    }
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
    public static int getLvl(ItemStack stack) {
        if (stack.isItemEnchanted()) {
            // 获取润滑附魔
            Enchantment oily = ItemRegistryHandler.oily;

            // 获取物品的附魔列表
            NBTTagList enchantmentsList = stack.getEnchantmentTagList();

            for (int i = 0; i < enchantmentsList.tagCount(); i++) {
                NBTTagCompound enchantmentTag = enchantmentsList.getCompoundTagAt(i);

                // 1.12.2中的附魔存储方式不同，需要用字符串表示附魔ID
                String id = enchantmentTag.getString("id");
                int level = enchantmentTag.getInteger("lvl");

                // 检查润滑附魔
                if (id.equals(Better_end_rod.MODID + "oily") && level > 0) {
                    return level;
                }
            }
        }
        return 0;
    }


}
