package com.adrianjayson.hibernate.demo;

import com.adrianjayson.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by adrianjayson on 5/18/17.
 */
public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student s where s.lastName='Catambay'").getResultList();


            for (Student student:students) {
                System.out.println(student);
            }

            students = session.createQuery("from Student where email like '%ohmygirl.com'").getResultList();

            System.out.println("\nOh My Girl Members");
            for (Student student:students) {
                System.out.println(student);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
