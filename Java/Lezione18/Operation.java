package Lezione18;

public enum Operation {
    PLUS("+") {
        @Override
        double apply(Double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(Double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(Double x, double y) {
            return x * y;
        }

        @Override
        public String toString() {
            return "x";
        }
    },
    DIVIDE("/") {
        @Override
        double apply(Double x, double y) {
            return x / y;
        }
    };


    private final String symbol;

    Operation(String s) {
        this.symbol = s;
    }


    //tutte le istanze devono implementarlo
    abstract double apply(Double x, double y);

    @Override
    public String toString() {
        return symbol;
    }
}
