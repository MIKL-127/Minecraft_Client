package de.pixl.pixlclient.cosmetics.cape;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import de.craftsblock.craftscore.json.JsonParser;
import de.pixl.pixlclient.Client;
import de.pixl.pixlclient.cosmetics.CosmeticManager;
import de.pixl.pixlclient.cosmetics.cape.Cape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CapeManager implements CosmeticManager<Cape> {

    private Cape cape;
    private Minecraft minecraft;

    private final ConcurrentHashMap<UUID, CapeState> animated = new ConcurrentHashMap<>();
    @Override
    public void setActive(Cape cape) {
        this.cape = cape;
        assert Minecraft.getInstance().player != null;
        UUID self = Minecraft.getInstance().player.getUUID();
        setForPlayer(self, cape);
        Client.backend.send(JsonParser.parse("{}")
                .set("uuid", self.toString())
                .set("cape", (Client.capeManager.getCurrent() == null ? "noCapeSet" : cape.name())));
    }

    @Override
    public Cape getCurrent() {
        return cape;
    }

    @Override
    public void tick() {
        if (minecraft == null) minecraft = Minecraft.getInstance();

        animated.forEach((uuid, state) -> {
            long time = System.currentTimeMillis();
            if (!(state.last() + state.cape().getDelay() < time)) return;
            setForPlayer(uuid, state.cape());
        });
    }

    @Override
    public void render() {
        AbstractClientPlayer player = minecraft.player;
        if (player == null || cape == null || cape.isAnimated()) return;
        setForPlayer(player.getUUID(), cape);
    }

    @Override
    public void setForPlayer(UUID uuid, Cape cape) {
        if (cape == null) return;
        ClientPacketListener connection = minecraft.getConnection();
        if (connection == null) return;
        PlayerInfo info = connection.getPlayerInfo(uuid);
        if (info == null) {
            animated.remove(uuid);
            return;
        }
        if (cape.isAnimated()) animated.put(uuid, new CapeState(cape, System.currentTimeMillis()));
        else animated.remove(uuid);
        ResourceLocation location = cape.getResourceLocation();
        if (info.hasTextureLocation(MinecraftProfileTexture.Type.CAPE) && info.getTextureLocation(MinecraftProfileTexture.Type.CAPE).getPath().equals(location.getPath()))
            return;
        info.setTextureLocation(MinecraftProfileTexture.Type.CAPE, cape.getResourceLocation());
    }
}
