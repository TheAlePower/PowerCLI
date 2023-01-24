package com.thealepower.powercli.cli.view.component.header;

import com.thealepower.powercli.PowerCLI;
import com.thealepower.powercli.cli.view.component.ViewComponent;

public class DefaultHeader extends ViewComponent {

    protected DefaultHeader(PowerCLI owner) {
        super(owner);
    }

    @Override
    public String getName() {
        return "DefaultHeader";
    }

    @Override
    public String[] draw(Character input) {
        return new String[0];
    }
}
