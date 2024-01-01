package com.crystalneko.better_end_rod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Loader;
import mca.core.MCAServer;

public class mca {
    public mca(EntityPlayer player, EntityPlayer target) {
        if (Loader.isModLoaded("mca")) {
            MCAServer.get().sendProposal(player, target);
            MCAServer.get().acceptProposal(target, player);
        }
    }
}
