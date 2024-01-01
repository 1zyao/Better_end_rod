package com.crystalneko.better_end_rod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Better_end_rod.MODID, name = Better_end_rod.NAME, version = Better_end_rod.VERSION)
public class Better_end_rod {
    public static final String MODID = "better_end_rod";
    public static final String NAME = "Better End Rod";
    public static final String VERSION = "0.0.1";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);
    }
}
