package com.gmail.pharaun.gregtania.misc;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class Config {

    public static Configuration config;
    public static OrechidYieldConfig orechidConfig;

    public static boolean stackedOreInTiers;
    public static boolean disableVanillaOrechid;
    private static boolean overrideOrechidWeight;
    public static boolean needSpecifiedDimension;

    public static int range, range_y;
    public static int COST = 17500;
    public static int COST_GOG = 700;
    public static int DELAY = 100;
    public static int DELAY_GOG = 2;

    public static int COST_IGNEML = 20000;
    public static int COST_GOG_IGNEML = 900;
    public static int DELAY_IGNEML = 200;
    public static int DELAY_GOG_IGNEML = 4;

    public static int COST_ENDIUML = 22500;
    public static int COST_GOG_ENDIUML = 1100;
    public static int DELAY_ENDIUML = 300;
    public static int DELAY_GOG_ENDIUML = 6;

    public static void preInit(File configFile) {
        if (configFile != null) {
            config = new Configuration(configFile);
            config.load();
        }

        // Orechid weight defaults
        orechidConfig = new OrechidYieldConfig();

        // Handle regular configs
        Property property = config.get(Configuration.CATEGORY_GENERAL, "OreStacking", true);
        property.comment = "The higher tier orechid also includes the ores in the lower tier orechids.";
        stackedOreInTiers = property.getBoolean();

        property = config.get(Configuration.CATEGORY_GENERAL, "DisableVanilla", true);
        property.comment = "Do we override and disable the vanilla orechids?";
        disableVanillaOrechid = property.getBoolean();

        // Do we want to override the orechid weights
        property = config.get(Configuration.CATEGORY_GENERAL, "EnableCustomOrechidWeights", false);
        property.comment = "Do we want to generate and load a custom orechid weight json file?";
        overrideOrechidWeight = property.getBoolean();

        property = config.get(Configuration.CATEGORY_GENERAL, "NeedSpecifiedDimension", false);
        property.comment = "Do we need a specified dimension to enable flowers?";
        needSpecifiedDimension = property.getBoolean();

        property = config.get(Configuration.CATEGORY_GENERAL, "range", 5);
        property.comment = "Stones in range can be replaced.";
        range = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "range_y", 3);
        property.comment = "Stones in range can be replaced.";
        range_y = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "Orechid Mana Cost", 17500);
        property.comment = "The mana cost of the Evolved Orechid. GoG Orechid is 700, vanilla Orechid is 17500. [range: 0 ~ 175000, default: 17500]";
        COST = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "Orechid Mana Cost GOG", 700);
        property.comment = "The mana cost of the Evolved Orechid. GoG Orechid is 700, vanilla Orechid is 17500. [range: 0 ~ 175000, default: 700]";
        COST_GOG = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "Orechid Delay", 100);
        property.comment = "The ore generation delay for the Evolved Orechid in ticks. GoG Orechid is 2, vanilla Orechid is 100. [range: 1 ~ 1200, default: 100]";
        DELAY = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "Orechid Delay GOG", 2);
        property.comment = "The ore generation delay for the Evolved Orechid in ticks. GoG Orechid is 2, vanilla Orechid is 100. [range: 1 ~ 1200, default: 2]";
        DELAY_GOG = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidIgneml Mana Cost", 20000);
        property.comment = "The mana cost of the Evolved Orechid. GoG Orechid is 900, vanilla Orechid is 20000. [range: 0 ~ 20000, default: 20000]";
        COST_IGNEML = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidIgneml Mana Cost GOG", 700);
        property.comment = "The mana cost of the Evolved Orechid. GoG Orechid is 700, vanilla Orechid is 17500. [range: 0 ~ 175000, default: 700]";
        COST_GOG_IGNEML = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidIgneml Delay", 200);
        property.comment = "The ore generation delay for the Evolved Orechid in ticks. GoG Orechid is 4, vanilla Orechid is 200. [range: 1 ~ 1200, default: 200]";
        DELAY_IGNEML = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidIgneml Delay GOG", 4);
        property.comment = "The ore generation delay for the Evolved Orechid in ticks. GoG Orechid is 4, vanilla Orechid is 200. [range: 1 ~ 1200, default: 4]";
        DELAY_GOG_IGNEML = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidEndiuml Mana Cost", 22500);
        property.comment = "The mana cost of the Evolved Orechid. GoG Orechid is 1100, vanilla Orechid is 22500. [range: 0 ~ 175000, default: 22500]";
        COST_ENDIUML = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidEndiuml Mana Cost GOG", 1100);
        property.comment = "The mana cost of the Evolved Orechid. GoG Orechid is 1100, vanilla Orechid is 17500. [range: 0 ~ 175000, default: 1100]";
        COST_GOG_ENDIUML = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidEndiuml Delay", 300);
        property.comment = "The ore generation delay for the Evolved Orechid in ticks. GoG Orechid is 6, vanilla Orechid is 300. [range: 1 ~ 1200, default: 300]";
        DELAY_ENDIUML = property.getInt();

        property = config.get(Configuration.CATEGORY_GENERAL, "OrechidEndiuml Delay GOG", 6);
        property.comment = "The ore generation delay for the Evolved Orechid in ticks. GoG Orechid is 6, vanilla Orechid is 100. [range: 1 ~ 1200, default: 6]";
        DELAY_GOG_ENDIUML = property.getInt();
        if (overrideOrechidWeight) {
            File orechidConfigFile = new File(configFile.getAbsolutePath().substring(0, configFile.getAbsolutePath().length() - 4) + ".json");
            if (orechidConfigFile != null) {
                if (orechidConfigFile.exists()) {
                    orechidConfig.load(orechidConfigFile);
                } else {
                    orechidConfig.save(orechidConfigFile);
                }
            }
        }

        config.save();
    }
}
