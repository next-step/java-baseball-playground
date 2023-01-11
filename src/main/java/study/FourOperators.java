package study;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum FourOperators {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/"),
    ;

    private String symbol;

    private static final Map<String, FourOperators> ENUM_MAP;

    FourOperators(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    static {
        Map<String, FourOperators> map = new ConcurrentHashMap<>();
        for (FourOperators operator : FourOperators.values()) {
            map.put(operator.getSymbol(), operator);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static FourOperators get(String symbol) {
        return ENUM_MAP.get(symbol);
    }

}
