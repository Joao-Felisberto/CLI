package utils.cli.menu.input;

import utils.cli.exceptions.MenuException;

import java.util.Scanner;

/**
 * Fetches a single line on the console and handles it
 *
 * The implementation of {@link Input#get(String)} must return the parsed and validated input
 *
 * @param <T> The type of the input
 */
public abstract class Input<T> {
    private final String prompt;

    private final Scanner scanner;

    /**
     * Creates an Input.
     *
     * @param prompt  The prompt text
     * @param scanner The scanner to be used to handle input
     */
    public Input(String prompt, Scanner scanner) {
        this.prompt = prompt;
        this.scanner = scanner;
    }

    T validate() {
        while (true)
            try {
                final String data = fetchLine();

                return get(data);
            } catch (MenuException e) {
                e.display();
            }
    }

    /**
     * Reads the console, validates and parses what the user typed.
     * For an example implementation check {@link NumericInput}
     *
     * @return The input converted into the desired type
     * @param data The input to be parsed
     * @throws MenuException when the data is malformed, wrong or unexpected.
     */
    public abstract T get(String data) throws MenuException;

    private String fetchLine() {
        System.out.print("\n" + prompt);
        return scanner.nextLine();
    }
}
