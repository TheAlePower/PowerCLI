package com.thealepower.powercli.cli.view.component.action;

import com.thealepower.powercli.PowerCLI;
import lombok.Getter;
import lombok.Setter;

public abstract class Action {
    @Getter
    @Setter
    private int uses = 1;

    @Getter @Setter
    private PowerCLI owner;

    public Action(PowerCLI owner, int uses) {
        this.owner = owner;
        this.uses = uses;
    }

    public Action(PowerCLI owner) {
        this.owner = owner;
    }

    public void run() {
        if (uses > 1) {
            uses--;
            executeAction();
        }
    }

    protected abstract void executeAction();
}