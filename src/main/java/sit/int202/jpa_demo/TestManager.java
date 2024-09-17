package sit.int202.jpa_demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.jpa_demo.entities.Office;

import java.util.List;
import java.util.Random;

public class TestManager {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("classicmodels");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("OFFICE.FIND_BY_CITY");
        query.setParameter("cityParam", "ba%");
        List<Office> offices = query.getResultList();
        for (Office office : offices) {
            System.out.printf("%-2s %-15s %10s %s\n" ,
                    office.getOfficeCode(), office.getCity(), office.getPhone() , office.getCountry());
        }

        Office office = em.find(Office.class, "1");
        System.out.println(office);

        office = em.find(Office.class,"7");
        System.out.println(office);

        office = em.find(Office.class,"12");
        System.out.println(office);

        office = em.find(Office.class,"7");
        em.getTransaction().begin();
        office = new Office();
        office.setOfficeCode((10+ new Random().nextInt(100)+ ""));

        office.setOfficeCode("99");
        office.setCity("Bangkok");
        office.setCountry("Thailand");
        office.setPhone("357-11-38");
        office.setAddressLine1("126 Pracha-utit");
        office.setPostalCode("10104");
        office.setTerritory("A");

        em.persist(office);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
