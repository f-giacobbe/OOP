package Esercitazione10;

import java.io.*;


class Demo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int a;
    private String b;
    transient private int c;
    ////////

    public Demo(int a, String b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}


public class SerializationTest {
    public static void main(String[] args) {
        Demo object0 = new Demo(12, "ciccio", 987814);
        System.out.println("Oggetto originale: " + object0);

        String filepath = "C:\\Users\\franc\\Desktop\\OOP\\Java\\Esercitazione10\\file.ser";


        //SERIALIZZAZIONE
        /* inizializzo l'ObjectOutputStream fuori dal blocco try in modo da poterlo poi chiudere
        nel blocco finally
         */
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filepath));
            oos.writeObject(object0);
            System.out.println("Oggetto serializzato!");
        } catch (IOException e) {
            System.err.println("Errore nella serializzazione");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.err.println("Errore nella chiusura dell'ObjectOutputStream");
            }
        }



        //DESERIALIZZAZIONE
        Demo object2 = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(filepath));

            object2 = (Demo) ois.readObject();

            System.out.println("Oggetto deserializzato!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore nella deserializzazione");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Oggetto deserializzato: " + object2);
    }
}
