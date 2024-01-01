package com.crystalneko.better_end_rod;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;

import java.util.HashMap;
import java.util.Map;

public class datas {
    public static Map<EntityPlayer, ItemStack> sticks = new HashMap<>();

    //对玩家进行插入操作,成功返回true,否则返回false
    public static Boolean stick(EntityPlayer player, ItemStack stack, EnumHand hand, EntityPlayer target){
        target.attackEntityFrom(DamageSource.GENERIC,3.0F); //对目标造成一点伤害
        //判断玩家是否已经插入了
        if(isStick(target)){
            return false;
        }else {
            sticks.put(target,stack);
            player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND,ItemStack.EMPTY); //删除玩家手上物品
            return true;
        }
    }


     //判断玩家是否已经被插入了
    public static Boolean isStick(EntityPlayer player){
        return sticks.containsKey(player);
    }

    //取出末地烛,成功返回true,否则返回false
    public static Boolean removal(EntityPlayer player, ItemStack stack, EnumHand hand, EntityPlayer target){
        target.attackEntityFrom(DamageSource.GENERIC,3.0F); //对目标造成一点伤害
        if(!isStick(target)){
            //玩家没被插入
            return false;
        }else {
            //获取被插入的物品
            ItemStack stacked = sticks.get(target);
            //添加lore
            stacked = setLore(stacked,new String[]{"§7它似乎带有奇怪的味道","§1还是不要继续使用为好"});
            stacked = setNbt(stacked,"used","true");
            //将物品还给玩家
            player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY, player.posZ, stacked));
            return true;
        }
    }

    public static ItemStack setLore(ItemStack itemStack, String[] lore) {
        NBTTagCompound tagCompound = itemStack.getTagCompound();

        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            itemStack.setTagCompound(tagCompound);
        }

        NBTTagCompound displayTag = tagCompound.getCompoundTag("display");

        if (!tagCompound.hasKey("display")) {
            tagCompound.setTag("display", displayTag);
        }

        NBTTagList loreList = new NBTTagList();

        for (String line : lore) {
            loreList.appendTag(new NBTTagString(line));
        }

        displayTag.setTag("Lore", loreList);
        tagCompound.setTag("display", displayTag);
        itemStack.setTagCompound(tagCompound);

        return itemStack;
    }

    public static ItemStack setNbt(ItemStack stack, String key, String value) {
        // 获取或创建 NBTTagCompound
        NBTTagCompound tagCompound = stack.getTagCompound();

        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }

        // 设置 NBT 数据
        tagCompound.setString(key, value);
        stack.setTagCompound(tagCompound);

        return stack;
    }
}
