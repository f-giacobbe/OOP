package Lezione15;

public class PeopleUtil {
    /**
     *
     * @param list
     * @return la persona con l'id più piccolo
     */
    public static <T extends Person> T minID(Iterable<T> list) {
        T min = null;

        for (T p : list) {
            if (min == null || p.compareTo(min) < 0) {
                min = p;
            }
        }

        return min;
    }



    //se volessi generalizzarlo, non solo alle persone
    public static <T extends Comparable<? super T>> T min(Iterable<T> list) {
        T min = null;

        for (T p : list) {
            if (min == null || p.compareTo(min) < 0) {
                min = p;
            }
        }

        return min;
    }
}
