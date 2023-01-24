package com.thealepower.powercli.cli.view.component.menu;

import com.thealepower.powercli.PowerCLI;
import com.thealepower.powercli.cli.input.InputAdapter;
import com.thealepower.powercli.cli.view.CLIView;
import com.thealepower.powercli.cli.view.component.ViewComponent;

import java.security.InvalidParameterException;
import java.util.*;

public abstract class SelectionMenu extends ViewComponent {
    // The various options
    private List<SelectionMenuEntry> entries;

    // The currently selected element
    private int selectedElement = 0;

    public SelectionMenu(PowerCLI owner, List<SelectionMenuEntry> entries) {
        super(owner);
        if (entries.size() < 1) throw new InvalidParameterException("The elements hashmap of a SelectionMenu needs at least one element.");
        this.entries = entries;
    }

    @Override
    public String getName() {
        return "SelectionMenu";
    }

    @Override
    public String[] draw(Character input) {
        List<String> output = new ArrayList<>();

        if (input.equals(InputAdapter.CONTROLKEY_UP) && selectedElement > 0) {
            selectedElement--;
        } else if (input.equals(InputAdapter.CONTROLKEY_DOWN) && selectedElement < entries.size()) {
            selectedElement++;
        } else if (input.equals(InputAdapter.CONTROLKEY_LEFT)) {
            goBack();
        } else if (input.equals(InputAdapter.CONTROLKEY_RIGHT)) {
            entries.get(selectedElement).getAction().run();
        }

        for (int i = 0; i < entries.size(); i++) {
            String line = "";

            if (i == selectedElement) {
                line += "> ";
            } else {
                line += "  ";
            }

            line += entries.get(i).getKeyString();

            output.add(line);
        }

        String[] returnValue = new String[output.size()];
        returnValue = output.toArray(returnValue);
        return returnValue;
    }

    public abstract void goBack();
}
