package org.bukkit.event.player;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家重生事件.
 */
public class PlayerRespawnEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private Location respawnLocation;
    private final boolean isBedSpawn;
    private final boolean isAnchorSpawn;

    @Deprecated
    public PlayerRespawnEvent(@NotNull final Player respawnPlayer, @NotNull final Location respawnLocation, final boolean isBedSpawn) {
        this(respawnPlayer, respawnLocation, isBedSpawn, false);
    }

    public PlayerRespawnEvent(@NotNull final Player respawnPlayer, @NotNull final Location respawnLocation, final boolean isBedSpawn, final boolean isAnchorSpawn) {
        super(respawnPlayer);
        this.respawnLocation = respawnLocation;
        this.isBedSpawn = isBedSpawn;
        this.isAnchorSpawn = isAnchorSpawn;
    }

    /**
     * 获取当前重生的位置.
     * <p>
     * 原文:Gets the current respawn location
     *
     * @return 玩家重生位置
     */
    @NotNull
    public Location getRespawnLocation() {
        return this.respawnLocation;
    }

    /**
     * 设置一个新的重生位置.
     * <p>
     * 原文:Sets the new respawn location
     *
     * @param respawnLocation 新的重生位置
     */
    public void setRespawnLocation(@NotNull Location respawnLocation) {
        Preconditions.checkArgument(respawnLocation != null, "Respawn location can not be null");
        Preconditions.checkArgument(respawnLocation.getWorld() != null, "Respawn world can not be null");

        this.respawnLocation = respawnLocation;
    }

    /**
     * 获取此玩家是否在他的床上重生.
     * <p>
     * 原文:Gets whether the respawn location is the player's bed.
     *
     * @return 玩家是否重生在床上
     */
    public boolean isBedSpawn() {
        return this.isBedSpawn;
    }

    /**
     * Gets whether the respawn location is the player's respawn anchor.
     *
     * @return true if the respawn location is the player's respawn anchor.
     */
    public boolean isAnchorSpawn() {
        return isAnchorSpawn;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}