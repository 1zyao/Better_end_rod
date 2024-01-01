package com.crystalneko.better_end_rod.Items;

import com.crystalneko.better_end_rod.Better_end_rod;
import com.crystalneko.better_end_rod.CreativeTab;
import com.crystalneko.better_end_rod.datas;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

import java.util.Random;


public class removal extends Item {
    private static String name = "removal";
    public removal() {
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
            //取出的概率
            double successRate = 0.3;
            Random random = new Random();
            boolean isRemoval = random.nextDouble() < successRate;
            if (isRemoval) {
                //对玩家执行取出操作
                if (datas.removal(player,stack,hand,target)) {
                    //取出成功
                    player.sendMessage(new TextComponentString(I18n.translateToLocal("message.better_end_rod.normal_rod.removal.success")));
                } else {
                    stack.setItemDamage(stack.getItemDamage() - 1); //扣除耐久
                    if(stack.getItemDamage() <= 0){
                        player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND,ItemStack.EMPTY); //删除物品
                    }else {
                        player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND,stack); //把修改后的物品给予玩家
                    }
                    player.sendMessage(new TextComponentString(I18n.translateToLocal("message.better_end_rod.normal_rod.removal.failure")));
                }
            }else {
                player.sendMessage(new TextComponentString(I18n.translateToLocal("message.better_end_rod.normal_rod.removal.failure")));
            }
        }
        return false;
    }
}
