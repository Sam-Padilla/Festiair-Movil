package com.android.sspadilla.festiair.model.managers;

import com.android.sspadilla.festiair.model.entities.FestivalEntity;

import com.android.sspadilla.festiair.model.entities.UserFestivalsEntity;
import com.android.sspadilla.festiair.model.entities.compoundKeys.UserFestivalsKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class UserFestivalsManager {
// variables
   private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

//   methods
   public ArrayList<FestivalEntity> getUserFestivalsRecommendations(int userId) {
      GenreFestivalsManager gfm = new GenreFestivalsManager();
      ArrayList<FestivalEntity> returnedArray = new ArrayList<>();
      ArrayList<Integer> genresAttractive = new UserGenresManager().getUserGenresAttractive(userId);
      if (genresAttractive.size() != 0){
         int maxQuantity = (int) Math.ceil( 10 / genresAttractive.size());
         for (Integer festival : genresAttractive) {
            ArrayList<FestivalEntity> genreFestivals = gfm.getGenreFestivals(festival);
            ArrayList<FestivalEntity> userFestivals = new UserFestivalsManager().getUserFestivals(userId);
            for (FestivalEntity userFestival: userFestivals){ genreFestivals.remove(userFestival); }
            int counter = 0;
            for (FestivalEntity genreFestival : genreFestivals){
               if (counter < maxQuantity){ returnedArray.add(genreFestival); }
            }
         }
      }

      return returnedArray;
   }
   public ArrayList<FestivalEntity> getUserFestivals(int id){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Query query = session.createQuery("from UserFestivalsEntity where userFestivalsKey.ufUserId=" + id);
      ArrayList<UserFestivalsEntity> results =  (ArrayList) query.list();
      session.getTransaction().commit();
      ArrayList<FestivalEntity> returnedArray = new ArrayList<>() ;
      for (UserFestivalsEntity result : results) {
         returnedArray.add(new FestivalManager().festivalObtain(result.getUserFestivalsKey().getUfFestivalId()));
      }
      return returnedArray;
   }
   public void userFestivalDelete(UserFestivalsKey key){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      session.delete(session.load(UserFestivalsEntity.class, key));
      session.getTransaction().commit();
   }
   public boolean userFestivalExist(int ufUserId, int ufFestivalId){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      UserFestivalsEntity user = session.get(UserFestivalsEntity.class, new UserFestivalsKey(ufUserId,ufFestivalId));
      session.getTransaction().commit();
      return user != null;
   }
   public void userFestivalAdd( int ufUserId, int ufFestivalId) {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      UserFestivalsEntity festival = new UserFestivalsEntity(ufUserId,ufFestivalId);
      session.save(festival);
      session.getTransaction().commit();
   }

}
