package utils.cli.menu.input;

import java.util.Scanner;
import java.util.Set;

/**
 * Handles the situations where validations require a plethora of input.
 * Can also be used when data to be handled is to be fetched in various phases from the user.
 * <p>
 * It is strongly encouraged to override {@link Input#validate()} and {@link Input#get(String)} in order to run all
 * Input objects stored in this InputSequence.
 */
public abstract class InputSequence<T> extends Input<T> {

    private final Set<Input<?>> inputs;

    /**
     * Creates an InputSequence.
     *
     * @param prompt  The prompt text
     * @param scanner The scanner to be used to handle input
     */
    public InputSequence(String prompt, Scanner scanner, Set<Input<?>> inputs) {
        super(prompt, scanner, null);
        this.inputs = inputs;
    }

    public Set<Input<?>> getInputs() {
        return inputs;
    }
}
