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

import com.gmail.pharaun.gregtania.botania.SubTileAbstractEvolvedOrechid;
import com.gmail.pharaun.gregtania.misc.BotaniaHelper;
import com.gmail.pharaun.gregtania.misc.Config;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.Botania;
import vazkii.botania.common.lexicon.LexiconData;

import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

public class OrechidIgnemI extends SubTileAbstractEvolvedOrechid {

    private static final int COST = Config.COST_IGNEML;
    private static final int COST_GOG = Config.COST_GOG_IGNEML;
    private static final int DELAY = Config.DELAY_IGNEML;
    private static final int DELAY_GOG = Config.DELAY_GOG_IGNEML;

    private static final int ORE_TIER = 1;
    private static Map<String, ItemStack> oreStackMap;
    private static Collection<WeightedRandom.Item> values;

    @Override
    public boolean canOperate() {
        if (Config.needSpecifiedDimension) {
            return supertile.getWorldObj().provider.isHellWorld;
        }
        return true;
    }

    @Override
    public Map<String, Integer> getOreMap() {
        return BotaniaHelper.tieredOreWeightNether.get(ORE_TIER);
    }

    @Override
    public Block getSourceBlock() {
        return Blocks.netherrack;
    }

    @Override
    public int getCost() {
        return Botania.gardenOfGlassLoaded ? COST_GOG : COST;
    }

    @Override
    public int getDelay() {
        return Botania.gardenOfGlassLoaded ? DELAY_GOG : DELAY;
    }

    @Override
    public int getColor() {
        return 0xAE3030;
    }

    @Override
    public LexiconEntry getEntry() {
        return LexiconData.orechidIgnem;
    }

    // TODO: This is a workaround for getting a red rose cos i haven't been able to track down why
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon() {
        return BotaniaAPI.getSignatureForName("evolvedOrechidIgnemI").getIconForStack(null);
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
