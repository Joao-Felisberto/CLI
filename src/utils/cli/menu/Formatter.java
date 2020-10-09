package utils.cli.menu;

import java.util.HashMap;
import java.util.Map;

public class Formatter {
    private final Map<String, String> replacers = new HashMap<>();

    public Formatter(Map<String, String> replacers) {
        this.replacers.putAll(replacers);
    }

    public String resolve(String s) {
        for (Map.Entry<String, String> entry : replacers.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            s = s.replaceAll(k, v);
        }
        return s;
    }
}
