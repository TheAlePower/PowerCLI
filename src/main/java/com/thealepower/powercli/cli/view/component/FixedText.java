package com.thealepower.powercli.cli.view.component;

import com.thealepower.powercli.PowerCLI;

public class FixedText extends ViewComponent {
    private final String text;

    public FixedText(PowerCLI owner, String text) {
        super(owner);
        this.text = text;
    }

    @Override
    public String getName() {
        return "FixedText";
    }

    @Override
    public String[] draw(Character input) {
        return new String[]{text};
    }
}
