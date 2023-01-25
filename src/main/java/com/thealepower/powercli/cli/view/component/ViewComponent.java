package com.thealepower.powercli.cli.view.component;

import com.thealepower.powercli.PowerCLI;
import com.thealepower.powercli.cli.view.CLIView;
import lombok.Getter;
import lombok.Setter;

public abstract class ViewComponent {

    @Getter @Setter
    protected CLIView parentView;

    @Getter
    protected final PowerCLI owner;


    public ViewComponent(PowerCLI owner) {
        this.owner = owner;
    }

    public abstract String getName();

    public abstract String[] draw(Character input);
}
