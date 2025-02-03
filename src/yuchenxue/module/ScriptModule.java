package yuchenxue.module;

import today.opai.api.OpenAPI;
import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.features.ExtensionModule;
import today.opai.api.interfaces.EventHandler;
import today.opai.api.interfaces.modules.values.*;
import yuchenxue.OutExtension;

/**
 * @author yuchenxue
 * @date 2024/12/07 - 22:38
 */

public class ScriptModule extends ExtensionModule implements EventHandler {

    protected final OpenAPI API = OutExtension.API;

    public ScriptModule(String name, String description, EnumModuleCategory category) {
        super(name, description, category);
    }

    protected void toggle() {
        setEnabled(!isEnabled());
    }

    public BooleanValue bool(String name, boolean value) {
        BooleanValue create = OutExtension.API.getValueManager().createBoolean(name, value);
        addValues(create);
        return create;
    }

    public ModeValue mode(String name, String[] modes, String value) {
        ModeValue create = OutExtension.API.getValueManager().createModes(name, value, modes);
        addValues(create);
        return create;
    }

    public NumberValue number(String name, double value, double min , double max, double step) {
        NumberValue create = OutExtension.API.getValueManager().createDouble(name, value, min, max, step);
        addValues(create);
        return create;
    }

    public NumberValue number(String name, double value, double min , double max, double step, String suffix) {
        NumberValue create = OutExtension.API.getValueManager().createDouble(name, value, min, max, step).setSuffix(suffix);
        addValues(create);
        return create;
    }

    public NumberValue integer(String name, int value, int min , int max) {
        NumberValue create = OutExtension.API.getValueManager().createDouble(name, value, min, max, 1);
        addValues(create);
        return create;
    }

    public LabelValue label(String name) {
        LabelValue create = OutExtension.API.getValueManager().createLabel(name);
        addValues(create);
        return create;
    }

    public BindValue bind(String name, int defaultBind) {
        BindValue create = OutExtension.API.getValueManager().createKeyBind(name, defaultBind);
        addValues(create);
        return create;
    }
}
