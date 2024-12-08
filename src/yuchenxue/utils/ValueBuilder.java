package yuchenxue.utils;

import today.opai.api.interfaces.modules.values.BooleanValue;
import today.opai.api.interfaces.modules.values.LabelValue;
import today.opai.api.interfaces.modules.values.ModeValue;
import today.opai.api.interfaces.modules.values.NumberValue;
import yuchenxue.OutExtension;
import yuchenxue.module.ScriptModule;

/**
 * @author yuchenxue
 * @date 2024/12/07 - 22:50
 */

public class ValueBuilder {

    private final ScriptModule module;

    public ValueBuilder(ScriptModule module) {
        this.module = module;
    }

    public BooleanValue createBoolean(String name, boolean value) {
        BooleanValue create = OutExtension.API.getValueManager().createBoolean(name, value);
        module.addValues(create);
        return create;
    }

    public ModeValue createMode(String name, String[] modes, String value) {
        ModeValue create = OutExtension.API.getValueManager().createModes(name, value, modes);
        module.addValues(create);
        return create;
    }

    public NumberValue createNumber(String name, double value, double min , double max, double step) {
        NumberValue create = OutExtension.API.getValueManager().createDouble(name, value, min, max, step);
        module.addValues(create);
        return create;
    }

    public NumberValue createNumber(String name, double value, double min , double max, double step, String suffix) {
        NumberValue create = OutExtension.API.getValueManager().createDouble(name, value, min, max, step).setSuffix(suffix);
        module.addValues(create);
        return create;
    }

    public NumberValue createInteger(String name, int value, int min , int max) {
        NumberValue create = OutExtension.API.getValueManager().createDouble(name, value, min, max, 1);
        module.addValues(create);
        return create;
    }

    public LabelValue createLabel(String name) {
        LabelValue create = OutExtension.API.getValueManager().createLabel(name);
        module.addValues(create);
        return create;
    }
}
