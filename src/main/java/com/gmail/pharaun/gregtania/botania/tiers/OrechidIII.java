/**
 * This class was created by <Vazkii>. It's distributed as part of the Botania
 * Mod. Get the Source Code in github: https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the Botania License:
 * http://botaniamod.net/license.php
 *
 * File Created @ [Apr 30, 2015, 3:27:20 PM (GMT)]
 */
package com.gmail.pharaun.gregtania.botania.tiers;

import com.gmail.pharaun.gregtania.misc.BotaniaHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import net.minecraft.util.IIcon;
import vazkii.botania.api.BotaniaAPI;

import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

public class OrechidIII extends OrechidI {

    private static final int ORE_TIER = 2;
    private static Map<String, ItemStack> oreStackMap;
    private static Collection<WeightedRandom.Item> values;

    @Override
    public Map<String, Integer> getOreMap() {
        return BotaniaHelper.tieredOreWeightOverworld.get(ORE_TIER);
    }

    // TODO: This is a workaround for getting a red rose cos i haven't been able to track down why
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon() {
        return BotaniaAPI.getSignatureForName("evolvedOrechidIII").getIconForStack(null);
    }

    @Override
    public Map<String, ItemStack> getOreStackMap() {
        if (oreStackMap == null) {
            oreStackMap = new HashMap<>(getOreMap().size());
        }
        return oreStackMap;
    }

    @Override
    public Collection<WeightedRandom.Item> getValues() {
        if (values == null) {
            values = new ArrayList<>(getOreMap().size());
        }
        return values;
    }
}
