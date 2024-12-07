package yuchenxue.command;

import today.opai.api.OpenAPI;
import today.opai.api.features.ExtensionCommand;
import yuchenxue.OutExtension;

/**
 * @author yuchenxue
 * @date 2024/12/08 - 00:27
 */

public class ScriptCommand extends ExtensionCommand {

    protected OpenAPI API = OutExtension.API;

    public ScriptCommand(String[] names, String description, String usage) {
        super(names, description, usage);
    }

    @Override
    public void onExecute(String[] strings) {

    }
}
