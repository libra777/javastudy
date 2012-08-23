package me.felici.crawler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: sunqipeng
 * Date: 12-8-16
 */
public class EmUtils {

    private static String PE_NAME = "crawler";

    private static EntityManagerFactory entityManagerFactory;

    /**
     * @return
     */
    public static EntityManager getEntity() {

        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PE_NAME);
        }
        return entityManagerFactory.createEntityManager();
    }
}
