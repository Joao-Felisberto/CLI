package utils.cli.menu;

import java.util.HashMap;
import java.util.List;

public class Menu {
    private final List<String> options;
    private final Formatter format;

    /**
     * @param options A list with all the options of said menu
     */
    public Menu(List<String> options) {
        this.options = options;
        this.format = new Formatter(new HashMap<>());
    }

    /**
     * Prints the menu utilizing {@link Formatter#resolve(String)}, passing each option to the method
     */
    public void display() {
        options.forEach(option -> System.out.println(format.resolve(option)));
    }
}
