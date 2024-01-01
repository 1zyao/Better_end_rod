package com.crystalneko.better_end_rod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab {
    public static final CreativeTabs END_ROD_TAB = new CreativeTabs(I18n.translateToLocal("better_end_rod.end_rod")) {
    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistryHandler.normal_rod);
    }
};
}
