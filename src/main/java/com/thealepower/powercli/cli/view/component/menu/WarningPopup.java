package com.thealepower.powercli.cli.view.component.menu;

import com.thealepower.powercli.PowerCLI;
import com.thealepower.powercli.cli.view.CLIView;
import com.thealepower.powercli.cli.view.component.ViewComponent;

public class WarningPopup extends ViewComponent {
    private CLIView no;
    private CLIView yes;

    protected WarningPopup(PowerCLI owner, CLIView no, CLIView yes) {
        super(owner);
        this.no = no;
        this.yes = yes;
    }

    @Override
    public String getName() {
        return "WarningPopup";
    }

    @Override
    public String[] draw(Character input) {
        return new String[0];
    }
}
