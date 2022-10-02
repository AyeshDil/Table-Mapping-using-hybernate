import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppInitializer {
    public static void main(String[] args) {

        CustomerName name1 = new CustomerName("Ayesh", "Dilshan");
        Customer c1 = new Customer(1,name1,"Kandy", 25000);

        Account ac1 =  new Account(1,"Saving");
        // Account ac2 =  new Account(1,"Double S");
        ac1.setCustomer(c1);
        // ac2.setCustomer(c1);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Order.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //session.save(c1);
        //session.save(ac1);
        transaction.commit();
    }
}
