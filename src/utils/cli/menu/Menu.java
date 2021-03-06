package utils.cli.menu;

import utils.cli.menu.input.MenuChoice;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    private final List<String> options;
    private final Formatter format;
    private final String prompt;
    private final Scanner scanner;
    private final String message;

    /**
     * @param options A list with all the options of said menu
     * @param prompt  The prompt format
     * @param scanner The scanner used to read the data
     * @param message The message to be displayed so the user knows he has to select one option from the menu
     */
    public Menu(List<String> options, String prompt, Scanner scanner, String message) {
        this.options = options;
        this.scanner = scanner;
        this.message = message;
        this.prompt = prompt;
        this.format = new Formatter(new HashMap<>());
    }

    /**
     * Prints the menu utilizing {@link Formatter#resolve(String)}, passing each option to the method,
     * Then collects the user choice and selects with Input to run.
     */
    public void display() {
        options.forEach(option -> System.out.println(format.resolve(option)));

        final int option = (int) new MenuChoice(prompt, scanner, message, this).validate();

        choose(option);
    }

    protected abstract void choose(int option);

    public List<String> getOptions() {
        return options;
    }

    public String getPrompt() {
        return prompt;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
