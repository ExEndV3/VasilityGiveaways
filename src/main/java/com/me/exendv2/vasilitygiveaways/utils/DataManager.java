package com.me.exendv2.vasilitygiveaways.utils;

import com.me.exendv2.vasilitygiveaways.VasilityGiveaways;
import java.io.File;

public class DataManager {
    File dataDir = new File(VasilityGiveaways.instance.getDataFolder(), "data");


    public boolean dataExists(String identifier) {
        File dataFile = new File(dataDir.getAbsoluteFile(), identifier + ".yml");
        boolean bool = false;
        if (dataFile.exists()) {
            bool = true;
        }
        return bool;
    }
}
