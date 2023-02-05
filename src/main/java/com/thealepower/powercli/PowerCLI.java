package com.thealepower.powercli;

import com.thealepower.powercli.cli.adapter.input.InputAdapter;
import com.thealepower.powercli.cli.adapter.output.OutputAdapter;
import com.thealepower.powercli.cli.view.CLIView;
import com.thealepower.powercli.cli.view.component.action.Action;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PowerCLI {

    @Getter @Setter
    private CLIView currentView;

    // The input
    @Getter
    private InputAdapter input;

    // The output
    @Getter
    private OutputAdapter output;

    @Getter @Setter
    private String[] arguments;

    @Getter
    private List<Action> preDrawTasks = new ArrayList<>();
    @Getter
    private List<Action> postDrawTasks = new ArrayList<>();

    // Width and height
    @Getter @Setter
    private int screenWidth = 40;

    @Getter @Setter
    private int screenHeight = 40;

    @Getter @Setter
    private boolean alive = true;

    public PowerCLI(InputAdapter input, OutputAdapter output) throws IOException {
        this.input = input;
        this.output = output;

        // screenWidth = output.getWidth();
        // screenHeight = output.getHeight();
    }

    // Synchronous command line
    public void start(String[] args) throws IOException {
        this.arguments = args;

        while (alive) {
            for (int i = 0; i < preDrawTasks.size(); i++) {
                preDrawTasks.get(i).run();
            }

            String[] lines = currentView.draw(input.readCharacter());

            for (int i = 0; i < lines.length; i++) {
                output.writeLine(lines[i]);
            }

            for (int i = 0; i < postDrawTasks.size(); i++) {
                postDrawTasks.get(i).run();
            }


            output.flush();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            output.clearTerminal();
        }
    }
}
