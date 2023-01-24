package com.thealepower.powercli.cli.input;

public abstract class InputAdapter {
    // Common control keys to navigate menus
    public static final Character CONTROLKEY_UP = 'w';
    public static final Character CONTROLKEY_DOWN = 's';
    public static final Character CONTROLKEY_LEFT = 'a';
    public static final Character CONTROLKEY_RIGHT = 'd';

    public abstract Character readCharacter();
}