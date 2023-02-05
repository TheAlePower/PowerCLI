package com.thealepower.powercli.cli.adapter.input.terminal;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.ansi.UnixLikeTerminal;
import com.thealepower.powercli.cli.adapter.input.InputAdapter;
import lombok.Getter;

import java.io.IOException;

public class TerminalInputAdapter extends InputAdapter {
    @Getter
    private UnixLikeTerminal terminal;

    public TerminalInputAdapter(UnixLikeTerminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public Character readCharacter() throws IOException {
        KeyStroke ks = terminal.pollInput();
        if (ks == null) {
            return null;
        } else {
            return ks.getCharacter();
        }
    }
}
