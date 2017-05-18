package com.adrianjayson.hibernate.demo;

import com.adrianjayson.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by adrianjayson on 5/18/17.
 */
public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Student.class)
                            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class, 1007);

            student.setEmail("hyun.seungheeeee@ohmygirl.com");

            session.createQuery("update Student set firstName='AJ' where lastName='Catambay'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }
}
