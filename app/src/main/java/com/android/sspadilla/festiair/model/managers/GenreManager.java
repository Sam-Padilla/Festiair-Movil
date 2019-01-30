package com.android.sspadilla.festiair.model.managers;

import com.android.sspadilla.festiair.controller.Utils;
import com.android.sspadilla.festiair.model.entities.GenreEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class GenreManager {
//   variables
   private static final SessionFactory sessionFactory = new Configuration().configure("../hibernate.cfg_xml").buildSessionFactory();
   private Utils utils = new Utils();

//   methods

   public int genreSearchName(String name){
      name = utils.toCamelCase(name);
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Query query = session.createQuery("from GenreEntity where genreName ='" + name + "'");
      ArrayList<GenreEntity> results =  (ArrayList) query.list();
      session.getTransaction().commit();
      if (results.size() != 0){ return results.get(0).getGenreId(); }else { return  -1; }
   }
   public int genreAdd( String name) {
      name = utils.toCamelCase(name);
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      GenreEntity genre = new GenreEntity(name);
      session.save(genre);
      session.getTransaction().commit();
      return genre.getGenreId();
   }

}
