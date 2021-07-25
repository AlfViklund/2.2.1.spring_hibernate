package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

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

   @Override
   public User userByCar(String model, int series) {
      TypedQuery<Car> carQuery = sessionFactory.getCurrentSession().createQuery("from Car where model = :model and series =:series")
              .setParameter("model", model)
              .setParameter("series", series);
      Long id = carQuery.getSingleResult().getId();
      //User user = carQuery.getSingleResult().getUser();
      TypedQuery<User> userQuery = sessionFactory.getCurrentSession().createQuery("from User where id =:car_id")
              .setParameter("car_id", id);
      return userQuery.getSingleResult();
   }

}
