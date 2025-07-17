package dev.pages.antom;

import net.fabricmc.api.ModInitializer;


public class blockexc implements ModInitializer {
    @Override
    public void onInitialize() {
        ModItem.initialize();
        ModGroup.initialize();
        ModBlock.initialize();
    }
}
