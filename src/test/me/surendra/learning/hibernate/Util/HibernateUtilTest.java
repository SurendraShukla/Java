package me.surendra.learning.hibernate.Util;

import me.surendra.learning.hibernate.Entity.EmployeeEntity;
import org.hibernate.Session;

public class HibernateUtilTest {

    public static void main(String[] args) {
        System.out.println("\t\t\t Directory = " + System.getProperty("user.dir"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        System.out.println("\t\t\t Directory = " + System.getProperty("user.dir"));

        // Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("demo-user1@mail.com");
        emp.setFirstName("demo1");
        emp.setLastName("user1");

        session.save(emp);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

}
