package yuchenxue.module.modules;

import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.enums.EnumUseEntityAction;
import today.opai.api.events.EventPacketSend;
import today.opai.api.interfaces.game.item.ItemStack;
import today.opai.api.interfaces.game.network.NetPacket;
import today.opai.api.interfaces.game.network.client.CPacket02UseEntity;
import today.opai.api.interfaces.modules.values.LabelValue;
import today.opai.api.interfaces.modules.values.NumberValue;
import yuchenxue.module.ScriptModule;

import java.util.*;

/**
 * @author yuchenxue
 * @date 2024/12/07 - 23:40
 */

public class ModuleAutoWeapon extends ScriptModule {
    public ModuleAutoWeapon() {
        super("Auto Weapon", "Auto hold the first sword in hotbar.", EnumModuleCategory.COMBAT);
    }

    // value
    private final LabelValue priority = builder.createLabel("Priority");
    private final NumberValue sword = builder.createInteger("Sword", 5, 0, 5);
    private final NumberValue axe = builder.createInteger("Axe", 3, 0, 5);
    private final NumberValue pickaxe = builder.createInteger("Pickaxe", 0, 0, 5);

    @Override
    public void onPacketSend(EventPacketSend event) {
        NetPacket packet = event.getPacket();

        if (packet instanceof CPacket02UseEntity) {
            CPacket02UseEntity c02 = (CPacket02UseEntity) packet;
            if (c02.getAction() == EnumUseEntityAction.ATTACK) {
                selectBestSlot();
            }
        }
    }

    private void selectBestSlot() {
        TreeMap<Integer, String> map = getMap();

        int slot = -1;
        for (String value : map.values()) {
            int i = getItemSlot(value);
            if (i != -1) {
                slot = i;
                break;
            }
        }

        if (slot != -1) {
            API.getLocalPlayer().setItemSlot(slot);
        }
    }

    private int getItemSlot(String name) {
        int slot = -1;
        for (int i = 0; i < 9; i++) {
            ItemStack stack = API.getLocalPlayer().getInventory().getMainInventory().get(i);
            if (stack != null && stack.getName().toLowerCase().contains(name.toLowerCase())) {
                slot = i;
                break;
            }
        }
        return slot;
    }

    private TreeMap<Integer, String> getMap() {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put(sword.getValue().intValue(), "sword");
        map.put(axe.getValue().intValue(), "hatchet");
        map.put(pickaxe.getValue().intValue(), "pickaxe");

        return map;
    }
}
