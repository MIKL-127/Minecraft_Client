package de.pixl.pixlclient.cosmetics.cape.capes;

import de.pixl.pixlclient.cosmetics.cape.Cape;
import net.minecraft.resources.ResourceLocation;

public class YinYangCape implements Cape {
    @Override
    public String name() {
        return "yinyang";
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation("pixlclient/capes/yinyangcape.png");
    }
}
