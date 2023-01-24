package com.thealepower.powercli.cli.view.component.menu;

import com.thealepower.powercli.cli.view.component.action.Action;
import lombok.Getter;
import lombok.Setter;

public abstract class SelectionMenuEntry {
    @Getter @Setter
    private Action action;

    public SelectionMenuEntry(Action action) {
        this.action = action;
    }

    public abstract String getKeyString();

    @Override
    public String toString() {
        return getKeyString();
    }
}
