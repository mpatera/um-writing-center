package edu.umt.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by tb189431e on 6/11/15.
 * This class is written specifically for Hibernate 4.2.x
 */
public class HibernateUtils {
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    private static SessionFactory createSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory =  configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex){
            System.err.println("Initial SessionsFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return createSessionFactory();
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
