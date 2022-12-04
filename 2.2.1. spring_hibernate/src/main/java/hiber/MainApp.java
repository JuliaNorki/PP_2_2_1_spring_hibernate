package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User ("User1, Lastname1, user1@mail.ru");
      User user2 = new User ("User2, Lastname2, user2@mail.ru");
      User user3 = new User ("User3, Lastname3, user3@mail.ru");
      User user4 = new User ("User4, Lastname4, user4@mail.ru");
      User user5 = new User ("User5, Lastname5, user5@mail.ru");

      user1.setCar(new Car("car1,1"));
      user2.setCar(new Car("car2,2"));
      user3.setCar(new Car("car3,3"));
      user4.setCar(new Car("car4,4"));
      user5.setCar(new Car("car5,5"));

     // userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
     // userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
     // userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      user1 = new User("User1");
       user1.setCar(new Car("Волга",1));

      List<User> users = userService.getUserByCar("Волга",1);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
      }

      context.close();
   }
}
