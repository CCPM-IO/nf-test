package com.github.lukfor.nf.test;

import com.github.lukfor.nf.test.commands.GenerateTestsCommand;
import com.github.lukfor.nf.test.commands.InitCommand;
import com.github.lukfor.nf.test.commands.RunTestsCommand;
import com.github.lukfor.nf.test.util.AnsiText;
import com.github.lukfor.nf.test.util.Emoji;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = App.NAME, version = App.VERSION)
public class App {

	public static final String NAME = "nf-test";

	public static final String VERSION = "0.1.0";

	public int run(String[] args) {

		printHeader();

		CommandLine commandLine = new CommandLine(new App());
		commandLine.addSubcommand("init", new InitCommand());
		commandLine.addSubcommand("test", new RunTestsCommand());
		commandLine.addSubcommand("generate", new GenerateTestsCommand());
		commandLine.setExecutionStrategy(new CommandLine.RunLast());
		return commandLine.execute(args);

	}

	private void printHeader() {

		System.out.println();
		System.out.println(Emoji.ROCKET + AnsiText.bold(" " + App.NAME + " " + App.VERSION));
		System.out.println("https://github.com/lukfor/nf-test");
		System.out.println("(c) 2021 Lukas Forer and Sebastian Schoenherr");
		System.out.println();

	}

	public static void main(String[] args) throws Exception {

		App app = new App();
		int exitCode = app.run(args);
		System.exit(exitCode);

	}

}
