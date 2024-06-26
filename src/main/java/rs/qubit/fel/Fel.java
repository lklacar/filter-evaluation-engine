package rs.qubit.fel;


import rs.qubit.fel.engine.FilterEngine;

import java.util.function.Predicate;

public class Fel {

    private Fel() {
        throw new IllegalStateException("Utility class");
    }

    public static Predicate<Object> filter(String filter) {
        var engine = FilterEngine.create();
        return engine.createFilter(filter);
    }
}
