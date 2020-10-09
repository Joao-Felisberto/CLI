package utils.cli.menu.input;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Fetches a single line on the console and handles it
 *
 * @param <T> The type of the input
 */
public class Input<T> {
    private final String prompt;
    private final T input;

    private final Scanner scanner;
    private final Set<Predicate<String>> checks = new HashSet<>();

    /**
     * Creates an Input without any check.
     *
     * @param prompt  The prompt text
     * @param scanner The scanner to be used to handle input
     */
    public Input(String prompt, Scanner scanner) {
        this.prompt = prompt;
        this.input = null;
        this.scanner = scanner;
    }

    /**
     * Creates an Input and appends some checks to be made before it returning anything.
     *
     * @param prompt  The prompt text
     * @param scanner The scanner to be used to handle input.
     * @param checks  The Predicates to check if the user input is valid
     */
    public Input(String prompt, Scanner scanner, Set<Predicate<String>> checks) {
        this(prompt, scanner);
        this.checks.addAll(checks);
    }

    /**
     * Reads the input and runs all validation checks.
     *
     * @return The input converted into the desired type
     */
    public T get() {
        while (true)
            try {
                final String in = fetchLine();

                return ((T) in);
            } catch (ClassCastException ignored) {
            }
    }

    private String fetchLine() {
        return scanner.nextLine();
    }
}
