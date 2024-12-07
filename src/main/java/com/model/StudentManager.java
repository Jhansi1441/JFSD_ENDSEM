package com.model;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;

public class StudentManager 
{
  public String insertData(Student s1)throws Exception
  {
    SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session se=sf.openSession();
    se.getTransaction().begin();
    se.persist(s1);
    se.getTransaction().commit();
    sf.close();
    se.close();
    return "insertion done successfully";
  }
  public String updateData(Student s1)throws Exception
  {
    SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session se=sf.openSession();
    se.getTransaction().begin();
    Student s2=se.find(Student.class, s1.sid);
    s2.setSname(s1.getSname());
    se.merge(s2);
    se.getTransaction().commit();
    sf.close();
    se.close();
    return "updation done successfully";
  }
     public String deleteData(Student s1)throws Exception
     {
      SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
     Session se=sf.openSession();
     se.getTransaction().begin();
     Student s2=se.find(Student.class, s1.getSid());
     if(s2 !=null) 
     {
          se.remove(s2);
     }
     se.getTransaction().commit();
     sf.close();
     se.close();
     return "deletion done successfully";
     }
     public List<Student> retrieveData() throws Exception {
         SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
         Session se = sf.openSession();
         se.getTransaction().begin();
         List<Student> list = new ArrayList<Student>();
         TypedQuery<Student> query = se.createQuery("select s from Student s", Student.class);
         list= query.getResultList();
         se.getTransaction().commit();
         se.close();
         sf.close();
         return list;
     }
}