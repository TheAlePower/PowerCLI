package com.thealepower.powercli.cli.view;

import com.thealepower.powercli.cli.input.InputAdapter;
import com.thealepower.powercli.cli.output.OutputAdapter;
import com.thealepower.powercli.cli.view.component.ViewComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CLIView {
    // The metadata of the view itself
    private String name;
    private String description;

    // All the components that will be used to draw the CLI
    private List<ViewComponent> components = new ArrayList<>();

    public CLIView(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CLIView(String name, String description, ViewComponent... orderedComponents) {
        this.name = name;
        this.description = description;
        for (ViewComponent orderedComponent : orderedComponents) {
            orderedComponent.setParentView(this);
        }
        this.components.addAll(List.of(orderedComponents));
    }

    public void addComponent(ViewComponent component) {
        component.setParentView(this);
        components.add(component);
    }

    public void addComponent(ViewComponent component, int position) {
        component.setParentView(this);
        components.add(position, component);
    }


    public String[] draw(Character character) {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < components.size(); i++) {
            lines.addAll(List.of(components.get(i).draw(character)));
        }

        String[] rawLines = new String[lines.size()];
        rawLines = lines.toArray(rawLines);
        return rawLines;
    }
}