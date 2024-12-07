package yuchenxue.module.modules;

import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.enums.EnumUseEntityAction;
import today.opai.api.events.EventPacketSend;
import today.opai.api.interfaces.game.item.ItemStack;
import today.opai.api.interfaces.game.network.NetPacket;
import today.opai.api.interfaces.game.network.client.CPacket02UseEntity;
import today.opai.api.interfaces.modules.values.BooleanValue;
import yuchenxue.module.ScriptModule;

/**
 * @author yuchenxue
 * @date 2024/12/07 - 23:40
 */

public class ModuleAutoSword extends ScriptModule {
    public ModuleAutoSword() {
        super("Auto Sword", "Auto hold the first sword in hotbar.", EnumModuleCategory.COMBAT);
    }

    // test value
    private final BooleanValue axe = builder.createBoolean("Axe", false);

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
        int slot = getItemSlot("sword");

        if (slot != -1) {
            API.getLocalPlayer().setItemSlot(slot);
        } else if (axe.getValue()) {
            int axeSlot = getItemSlot("hatchet");
            if (axeSlot != -1) {
                API.getLocalPlayer().setItemSlot(axeSlot);
            }
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
}
