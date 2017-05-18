package com.adrianjayson.hibernate.demo;

import com.adrianjayson.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by adrianjayson on 5/17/17.
 */
public class CreateStudentDemo {

    public static void main(String[] args) {

        // create Session Factory
        SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // create student object
            System.out.println("Creating a student...");
            Student student = new Student("Seunghee", "Hyun", "hyun.seunghee@ohmygirl.com");

            // start the transaction
            session.beginTransaction();

            // save the transaction
            System.out.println("Saving student");
            session.save(student);

            // commit the transaction
            session.getTransaction().commit();


            // get a new session
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student id " + student.getId());

            // retrieve created student
            Student createdStudent = session.get(Student.class, student.getId());
            System.out.println("Student " + createdStudent.getFirstName() + " " + createdStudent.getLastName() + " created.");

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
