
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import spark.Spark;

public class Server {
    static SessionFactory factory;
    public static void main (String[] args){
        Session session = null;
        factory = new Configuration().configure().buildSessionFactory();
        Configuration config = new Configuration().configure("file:D:\\proyects git\\abm\\src\\main\\resources\\hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Transaction txn = null;
        try {
            session = sf.openSession();
            txn = session.beginTransaction();
            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        Spark.port(9048);
        Router.configure();
    }

}
