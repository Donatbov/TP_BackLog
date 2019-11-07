package utils;

import javax.persistence.EntityManager;

public class Utils {

    /**
     * Utilitary function to persist or fail (with a log in System.err).
     * @param object the object to persist
     * @return true if persist ok
     */
    public static <T> T persistOrFail(EntityManager em, T object) {
        try {
            em.persist(object);
            return object;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
