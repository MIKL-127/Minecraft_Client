package de.pixl.pixlclient.cosmetics.cape.capes;

import de.pixl.pixlclient.cosmetics.cape.Cape;
import net.minecraft.resources.ResourceLocation;

public class PixlCape implements Cape {
    @Override
    public String name() {
        return "pixl";
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation("pixlclient/capes/pixlcape.png");
    }
}
