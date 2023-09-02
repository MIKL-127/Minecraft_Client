package de.pixl.pixlclient.cosmetics.cape.capes;

import de.pixl.pixlclient.cosmetics.cape.Cape;
import net.minecraft.resources.ResourceLocation;

public class TestCape implements Cape {
    @Override
    public String name() {
        return "test";
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation("pixlclient/capes/cape.png");
    }
}
