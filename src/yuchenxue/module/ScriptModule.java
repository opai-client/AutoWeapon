package yuchenxue.module;

import today.opai.api.OpenAPI;
import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.features.ExtensionModule;
import today.opai.api.interfaces.EventHandler;
import yuchenxue.OutExtension;
import yuchenxue.utils.ValueBuilder;

/**
 * @author yuchenxue
 * @date 2024/12/07 - 22:38
 */

public class ScriptModule extends ExtensionModule implements EventHandler {

    protected final OpenAPI API = OutExtension.API;

    protected final ValueBuilder builder;

    public ScriptModule(String name, String description, EnumModuleCategory category) {
        super(name, description, category);
        builder = new ValueBuilder(this);
        setEventHandler(this);
    }

    protected void toggle() {
        setEnabled(!isEnabled());
    }
}
