package com.thealepower.powercli.cli.adapter.input;

import java.io.IOException;

public abstract class InputAdapter {
    // Common control keys to navigate menus
    public static final Character CONTROLKEY_UP = 'w';
    public static final Character CONTROLKEY_DOWN = 's';
    public static final Character CONTROLKEY_LEFT = 'a';
    public static final Character CONTROLKEY_RIGHT = 'd';

    public static final Character CONTROLKEY_ENTER = '\n';
    public static final Character CONTROLKEY_BACK = '\b';

    public abstract Character readCharacter() throws IOException;
}