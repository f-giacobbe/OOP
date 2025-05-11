package Lezione11;

public class Outer {
    private int v;
    private static final int a = 1;


    public class Inner {
        private int k;

        public void m() {
            k++;    //this.k
            v++;    //Outer.this.v
        }
    }


    public static class InnerStatic {
        public void m() {
            //v++;      //non posso
            System.out.println(a);  //questo sì perché static
        }
    }
}
