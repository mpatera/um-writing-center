package edu.umt.db;

import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;


public class DatabaseManager {
    static Session session = null;

    protected static Session currentSession(){
        if(session == null || !session.isOpen()) {
            session = HibernateUtils.getSessionFactory().openSession();
        }
        return session;
    }

    public static BaseEntity getRecord(BaseEntity entity, Serializable s){
        return (BaseEntity) currentSession().load(entity.getClass(), s);
    }

    public static <T>List<T> getRecords(Class<T> entity){
        try{
            Query query = currentSession().createQuery("from " + entity.getName());
            return query.list();
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally{
            try{
                currentSession().close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void saveRecord(BaseEntity entity){
        Session session = currentSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        session.close();
    }


    public static void deleteRecord(Class<BaseEntity> entity){
        currentSession().delete(entity);
    }
}
 