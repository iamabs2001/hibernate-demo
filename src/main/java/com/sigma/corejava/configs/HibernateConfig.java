package com.sigma.corejava.configs;

import Models.UserModel;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateConfig {
    
   private static SessionFactory factory;

   public static SessionFactory getSessionFactory() {
      if (factory == null) {
         try {
            // Properties
            Properties properties = new Properties();
            properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.setProperty(Environment.USER, "root");
            properties.setProperty(Environment.PASS, "123");
            properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/abhijeet");

            // Hibernate Configurations
            Configuration hibernate = new Configuration();
            hibernate.setProperties(properties);
            
            // Add Models
            hibernate.addAnnotatedClass(UserModel.class);
            
            // Build Session Dactory
            factory = hibernate.buildSessionFactory();
             
         } catch (Exception e) { return null; }
      }
      return factory;
   }
}
