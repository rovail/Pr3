public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SQRT("sqrt");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operation fromString(String input) {
        for (Operation op : values()) {
            if (op.symbol.equals(input)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Incorrect operation: " + input);
    }
}
