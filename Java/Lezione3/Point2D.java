package Lezione3;

        ///////
public interface Point2D {
    /* in un interface definisco solo cosa voglio fare, e non com'è fatto il punto.
     * Come la definizione di un metodo, ma non implementato (astratto) - ovvero una "promessa" che sia implementato da qualche altra parte
     * Qualunque metodo di un interfaccia è sia public che abstract
     */
    double getX();
    double getY();
    double getMod();
    double getPhase();
    double distance(Point2D p);
}
