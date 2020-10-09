package utils.cli.exceptions;

/**
 * Exception to be used on the menu
 */
public class MenuException extends CLIException{
    protected MenuException(String userMessage) {
        super(userMessage);
    }

    @Override
    public void display() {
        System.out.println("ERROR: " + getUserMessage());
    }
}
