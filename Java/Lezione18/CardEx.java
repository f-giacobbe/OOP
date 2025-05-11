package Lezione18;

public class CardEx {
    public static void main(String[] args) {
        Valore v = Valore.ASSO;

        CartaNapoletana c1 = new CartaNapoletana(Valore.DUE, Seme.COPPE);
        System.out.println(c1);
        System.out.println(Valore.DONNA.getValue());

        for (Valore vx : Valore.values()) {
            System.out.println(vx);
        }

        Seme s = Seme.ORO;
        System.out.println(calcolaValoreSeme(s));
    }


    //supponendo un gioco dove il valore dipende dal seme
    static int calcolaValoreSeme(Seme seme) {
        return switch (seme) {
            case ORO -> 10;
            case SPADE -> 5;
            default -> 1;       //in tutti gli altri casi
        };
    }
}
