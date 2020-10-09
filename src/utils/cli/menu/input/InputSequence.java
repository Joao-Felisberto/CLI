package utils.cli.menu.input;

import utils.cli.exceptions.MenuException;

/**
 * Handles the situations where validations require a plethora of input.
 * Can also be used when data to be handled is to be fetched in various phases from the user.
 */
public interface InputSequence<T> {

    /**
     * The validation of all inputs combined.
     * @return The data gathered from all the user's input
     * @throws MenuException when the input group given is malformed.
     */
    T validate() throws MenuException;

    /**
     * Asks the user for data
     * @param message The message explaining the data expected from the user
     * @param input The Input object to handle the data
     * @param <U> The return type of the input object's {@link Input#get(String)}
     */
    default <U> void ask(String message, Input<U> input) {
        System.out.println(message);
        input.validate();
    }
}
