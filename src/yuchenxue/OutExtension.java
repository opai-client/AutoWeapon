package yuchenxue;

import today.opai.api.Extension;
import today.opai.api.OpenAPI;
import today.opai.api.annotations.ExtensionInfo;
import yuchenxue.module.ScriptModule;
import yuchenxue.module.modules.ModuleAutoWeapon;

/**
 * @author yuchenxue
 * @date 2024/12/07 - 22:41
 */

@ExtensionInfo(name = "AutoWeapon",author = "yuchenxue",version = "1.0")
public class OutExtension extends Extension {

    public static OpenAPI API;

    @Override
    public void initialize(OpenAPI openAPI) {
        OutExtension.API = openAPI;

        // register module
        register(new ModuleAutoWeapon());
    }

    private void register(ScriptModule module) {
        module.setEventHandler(module);
        API.registerFeature(module);
    }
}
