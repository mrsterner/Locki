/*
 * Locki
 * Copyright (C) 2021-2024 Ladysnake
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; If not, see <https://www.gnu.org/licenses>.
 */
package org.ladysnake.locki.impl.compat.mixin.backslot;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.backslot.network.SwitchPacketReceiver;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.ladysnake.locki.InventoryKeeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SwitchPacketReceiver.class)
public abstract class SwitchPacketMixin {
    @Shadow
    public static boolean isItemAllowed(ItemStack stack, int slot) {
        return false;
    }
/*TODO
    @WrapWithCondition(
            method = "receive(Lnet/backslot/network/SwitchPacket;Lnet/fabricmc/fabric/api/networking/v1/ServerPlayNetworking$Context;)V",
            at = @At(
                    value = "INVOKE",
                    target = ""
            )
    )
    private boolean lockAdditionalSlots(ItemStack stack, int slot, MinecraftServer server, ServerPlayerEntity player) {
        if (InventoryKeeper.get(player).isSlotLocked(slot)) {
            return false;
        }
        return isItemAllowed(stack, slot);
    }

 */
}
