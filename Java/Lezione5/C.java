package Lezione5;

public class C extends SC {
    private int subValue = 0;

    public C() {
        super(0);
    }

    public C(int v, int sv) {
        super(v);
        this.subValue = sv;
    }

    @Override
    public String toString() {
        return "value="+this.getValue()+", subValue="+this.subValue;
    }
}
