package hiber.dao;

import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private static Session HibernateUser;
   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   private static void getSessionFactory() {

      try(Session session = HibernateUser.getSessionFactory().openSession()) {

         String HQL= "FROM model model LEFT OUTER JOIN FETCH model.car WHERE model.model=:model";
         Model model = session.createQuery(HQL, model.class).setParameter("model").uniqueResult();
         System.out.println(model);
         System.out.println(model.getSessionFactory());
      } catch (HibernateException e) {
         e.printStackTrace();
      }

   }

}
