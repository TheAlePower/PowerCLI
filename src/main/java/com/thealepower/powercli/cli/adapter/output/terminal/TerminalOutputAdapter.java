package com.thealepower.powercli.cli.adapter.output.terminal;

import com.googlecode.lanterna.terminal.ansi.ANSITerminal;
import com.googlecode.lanterna.terminal.ansi.UnixLikeTerminal;
import com.thealepower.powercli.cli.adapter.output.OutputAdapter;
import lombok.Getter;

import java.io.IOException;

public class TerminalOutputAdapter extends OutputAdapter {
    @Getter
    private UnixLikeTerminal terminal;

    public TerminalOutputAdapter(UnixLikeTerminal terminal) throws IOException {
        this.terminal = terminal;
        terminal.enterPrivateMode();
    }

    public void close() throws IOException {
        terminal.exitPrivateMode();
    }

    @Override
    public void writeString(String value) throws IOException {
        for (Character c : value.toCharArray()) {
            terminal.putCharacter(c);
        }
    }

    @Override
    public void writeLine(String value) throws IOException {
        writeString(value + "\n");
        terminal.setCursorPosition(0, terminal.getCursorPosition().getRow() + 1);
        // terminal.setCursorPosition(terminal.getCursorPosition().getRow() + 1, 0);
    }

    @Override
    public void flush() throws IOException {
        terminal.flush();
    }

    @Override
    public void clearTerminal() throws IOException {
        terminal.clearScreen();
        terminal.flush();
        terminal.setCursorPosition(0,0);
    }

    @Override
    public int getWidth() throws IOException {
        return terminal.getTerminalSize().getColumns();
    }

    @Override
    public int getHeight() throws IOException {
        return terminal.getTerminalSize().getRows();
    }
}
