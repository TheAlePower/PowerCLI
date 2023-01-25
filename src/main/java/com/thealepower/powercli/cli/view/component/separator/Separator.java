package com.thealepower.powercli.cli.view.component.separator;

import com.thealepower.powercli.PowerCLI;
import com.thealepower.powercli.cli.view.component.FixedText;

public class Separator extends FixedText {

    public Separator(PowerCLI owner) {
        super(owner, new String(new char[owner.getScreenWidth()]).replace("\0", "#"));
    }
}
