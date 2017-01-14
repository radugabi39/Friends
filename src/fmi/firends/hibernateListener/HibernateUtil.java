package fmi.firends.hibernateListener;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


 
public class HibernateUtil
{
   private static SessionFactory sessionFactory = buildSessionFactory();
 
   private static SessionFactory buildSessionFactory()
   {
      try
      {
         if (sessionFactory == null)
         {
            Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Comment.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Genre.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Item.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Orders.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Review.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Role.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Shows.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Theater.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Title.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.User.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.UserTitle.class);
            configuration.addAnnotatedClass(fmi.friends.hibernateEntities.Token.class);

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         }
         return sessionFactory;
      } catch (Throwable ex)
      {
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }
 
   public static SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }
 
   public static void shutdown()
   {
      getSessionFactory().close();
   }
}