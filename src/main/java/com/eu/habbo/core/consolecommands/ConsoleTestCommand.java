package com.eu.habbo.core.consolecommands;

import io.netty.buffer.Unpooled;

public class ConsoleTestCommand extends ConsoleCommand
{
    public ConsoleTestCommand()
    {
        super("test", "test");
    }

    @Override
    public void handle(String[] args) throws Exception
    {
    }
}