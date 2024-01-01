package com.crystalneko.better_end_rod;

import com.crystalneko.better_end_rod.Items.*;
import com.crystalneko.better_end_rod.enchantment.oily;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;


@Mod.EventBusSubscriber
public class ItemRegistryHandler {
    public static final normalRod normal_rod = new normalRod();
    public static final removal removal = new removal();
    public static final oily oily = new oily();

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        event.getRegistry().registerAll(
            normal_rod,
            removal
        );
    }
    @SubscribeEvent
    public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event)
    {
        event.getRegistry().registerAll(
                oily
        );
    }

    public static ItemStack createEnchantedBookWithCustomEnchantment(Enchantment customEnchantment, int enchantmentLevel) {
        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);

        // 使用EnchantmentHelper.addEnchantment将自定义附魔添加到附魔书物品上
        EnchantmentHelper.setEnchantments(Collections.singletonMap(
                customEnchantment, enchantmentLevel), enchantedBook);

        return enchantedBook;
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event){
        registryModel(normal_rod);
        registryModel(removal);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item){
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(item.getRegistryName(),"inventory");

        ModelLoader.setCustomModelResourceLocation(item,0,modelResourceLocation);
    }
}
