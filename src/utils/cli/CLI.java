package utils.cli;

import utils.cli.menu.Menu;

import java.util.*;

public class CLI {
    private final Scanner s = new Scanner(System.in);
    private final List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        start(0);
    }

    public void start(int i) {
        menus.get(i).display();
    }

    public Scanner getS() {
        return s;
    }
}
