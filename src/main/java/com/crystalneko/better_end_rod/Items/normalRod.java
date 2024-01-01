package com.crystalneko.better_end_rod.Items;


import com.crystalneko.better_end_rod.Better_end_rod;
import com.crystalneko.better_end_rod.CreativeTab;
import com.crystalneko.better_end_rod.datas;
import com.crystalneko.better_end_rod.enchantment.oily;
import com.crystalneko.better_end_rod.mca;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.Random;

public class normalRod extends Item {
    private static String name = "normal_rod";
    public normalRod() {
        this.setRegistryName(name);
        this.setUnlocalizedName(Better_end_rod.MODID+"."+name);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTab.END_ROD_TAB);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity, EnumHand hand) {
        //判断目标是否为玩家
        if(entity.getCommandSenderEntity() instanceof EntityPlayer){
            EntityPlayer target = (EntityPlayer) entity.getCommandSenderEntity();
            double successRateUp = 0;
            //获取润滑附魔
            int oily_lvl = oily.getLvl(stack);
            if (oily_lvl != 0) {
                //添加插入成功几率
                successRateUp = oily_lvl * 0.05;
            }
            double successRate = 0.1 + successRateUp;
            Random random = new Random();
            boolean isStick = random.nextDouble() < successRate;
            if (isStick) {
                //对玩家执行插入操作
                if (datas.stick(player,stack,hand,target)) {
                    //插入成功
                    player.sendMessage(new TextComponentTranslation(I18n.format("message.better_end_rod.normal_rod.stick.success")));
                    new mca(player, target);
                } else {
                    stack.setItemDamage(stack.getItemDamage() - 1); //扣除耐久
                    if(stack.getItemDamage() == 0){ //故意留的特性
                        player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND,ItemStack.EMPTY); //删除物品
                    }else {
                        player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND,stack);
                    }
                    player.sendMessage(new TextComponentTranslation(I18n.format("message.better_end_rod.normal_rod.stick.failure")));
                }
            }else {
               player.sendMessage(new TextComponentTranslation(I18n.format("message.better_end_rod.normal_rod.stick.failure")));
            }
        }
        return false;
    }


}
