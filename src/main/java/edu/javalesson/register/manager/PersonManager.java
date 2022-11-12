package edu.javalesson.register.manager;

import edu.javalesson.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class PersonManager {

    public static void main(String[] args) {
//        sessionExample();
        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person1 = new Person();
        person1.setFirstName("Никита");
        person1.setLastName("Коньков");
        entityManager.persist(person1);
        System.out.println(person1.getPersonId());

        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        List list = entityManager.createQuery("FROM Person").getResultList();
        list.forEach(p1 -> System.out.println(p1));
        entityManager.close();
    }

    private static void sessionExample() {
        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Person person = new Person();
        person.setFirstName("Василий");
        person.setLastName("Сидоров");

        Object id = session.save(person);
        System.out.println(id);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Person person1 = session.get(Person.class, id);
        System.out.println(person1);
        session.close();

        session = sessionFactory.openSession();
        List<Person> list = session.createQuery("FROM Person", Person.class).list();
        list.forEach(person2 -> System.out.println(person2));
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
