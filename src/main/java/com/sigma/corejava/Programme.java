package com.sigma.corejava;

import Models.UserModel;
import com.sigma.corejava.configs.HibernateConfig;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Programme {
    
    public static void main(String args[]) {
      
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        
//        UserModel thenewuser = new UserModel(6, "hero","123");
//        session.save(thenewuser);
//        t.commit();
        
        
        List<UserModel> UsersList = session.createQuery("from UserModel").list();
        
        for (UserModel user : UsersList) {
            System.out.println("-------------------");
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getPass());
            
        }  
        
    }
}
