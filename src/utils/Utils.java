package utils;

import javax.persistence.EntityManager;

public class Utils {

    /**
     * Utilitary function to persist or fail (with a log in System.err) a {@see Agence}
     * @param object the object to persist
     * @return true if persist ok
     */
    public static <T> boolean persistOrFail(EntityManager em, T object) {
        try {
            em.persist(object);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
