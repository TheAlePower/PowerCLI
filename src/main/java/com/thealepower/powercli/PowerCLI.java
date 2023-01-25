package com.thealepower.powercli;

import com.thealepower.powercli.cli.input.InputAdapter;
import com.thealepower.powercli.cli.output.OutputAdapter;
import com.thealepower.powercli.cli.view.CLIView;
import com.thealepower.powercli.cli.view.component.action.Action;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class PowerCLI extends Thread {
    private CLIView currentView;

    // The input
    private InputAdapter input;

    // The output
    private OutputAdapter output;

    private String[] arguments;

    private List<Action> preDrawTasks = new ArrayList<>();
    private List<Action> postDrawTasks = new ArrayList<>();

    // Width and height
    @Getter @Setter
    private int screenWidth = 40;

    @Getter @Setter
    private boolean alive = true;

    public PowerCLI(InputAdapter input, OutputAdapter output) {
        this.input = input;
        this.output = output;
    }

    // Synchronous command line
    public void start(String[] args) {
        this.arguments = args;

        while (alive) {
            for (int i = 0; i < preDrawTasks.size(); i++) {
                preDrawTasks.get(i).run();
            }

            String[] lines = currentView.draw(input.readCharacter());

            for (int i = 0; i < lines.length; i++) {
                output.writeString(lines[i]);
            }

            for (int i = 0; i < postDrawTasks.size(); i++) {
                postDrawTasks.get(i).run();
            }
        }
    }
}
