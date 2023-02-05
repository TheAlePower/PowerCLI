package com.thealepower.powercli.cli.view.component;

import com.thealepower.powercli.PowerCLI;

public abstract class VariableText extends ViewComponent {
    public VariableText(PowerCLI owner) {
        super(owner);
    }

    @Override
    public String getName() {
        return "VariableText";
    }

    public abstract String[] getText();

    @Override
    public String[] draw(Character input) {
        return getText();
    }
}
