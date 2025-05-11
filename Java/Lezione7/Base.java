package Lezione7;

/*Le classi astratte servono per definire parzialmente dei tipi di dati, per esempio
 non possiamo fare
 * la new e creare un oggetto di tipo Base (importante). Però a differenza delle interfacce
 possiamo inserire
  delle variabili
 * d'istanza, metodi, costruttore, fare l'override per i metodi di Object
  (unica classe soprastante)*/

public abstract class Base {
    private int value;

    public Base(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Base [value=" + value + "]";
    }


    /* L'equivalente di ciò che viene fatto nelle interfacce. Definendo un metodo astratto,
    * infatti, la classe sottostante sarà obbligata a implementarlo */
    public abstract void m();
}
