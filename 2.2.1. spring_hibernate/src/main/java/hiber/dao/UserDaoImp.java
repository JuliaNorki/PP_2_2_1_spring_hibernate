package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private static Session HibernateUser;
   @Autowired
   private static SessionFactory sessionFactory;

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
   public List<User> getUserByCar(String model, int series) {
      String hqlQuery = "from User u join fetch u.car as ca where ca.model like :model and ca.series =:series";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return  query.getResultList();


   }


   }


