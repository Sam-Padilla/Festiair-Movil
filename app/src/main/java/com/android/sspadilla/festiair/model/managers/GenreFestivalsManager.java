package com.android.sspadilla.festiair.model.managers;


import com.android.sspadilla.festiair.model.entities.FestivalEntity;
import com.android.sspadilla.festiair.model.entities.GenreFestivalsEntity;
import com.android.sspadilla.festiair.model.entities.compoundKeys.GenreFestivalsKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class GenreFestivalsManager {
//   variables
   private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

//   methods
   public boolean genreFestivalExist(int gfGenreId, int gfFestivalId){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      GenreFestivalsEntity user = session.get(GenreFestivalsEntity.class, new GenreFestivalsKey(gfGenreId,gfFestivalId));
      session.getTransaction().commit();
      return user != null;
   }
   public ArrayList<FestivalEntity> getGenreFestivals(int genreId){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Query query = session.createQuery("from GenreFestivalsEntity where genreFestivalsKey.gfGenreId=" + genreId);
      ArrayList<GenreFestivalsEntity> results =  (ArrayList) query.list();
      session.getTransaction().commit();

//    festivals of their respective gender
      ArrayList<FestivalEntity> returnedArray = new ArrayList<>() ;
      for (GenreFestivalsEntity result : results) {
         returnedArray.add(new  FestivalManager().festivalObtain(result.getGenreFestivalsKey().getGfFestivalId()));
      }
      return returnedArray;
   }
   public void genreFestivalAdd( int gfGenreId, int gfFestivalId) {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(new GenreFestivalsEntity(gfGenreId,gfFestivalId));
      session.getTransaction().commit();
   }

}
