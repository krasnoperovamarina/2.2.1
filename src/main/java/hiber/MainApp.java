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


      userService.add(new User("Anton", "Ivanov", "useranton1@mail.ru", new Car("BMW", 5)));
      userService.add(new User("Nikita", "Bel", "usernikita1@mail.ru", new Car("Volvo", 8)));
      userService.add(new User("Kira", "Moroz", "userkira1@mail.ru", new Car("Hundai", 4)));
      userService.add(new User("Lila", "Nilova", "userlila1@mail.ru", new Car("Lada", 12)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getUserCar());
         System.out.println();
      }

      System.out.println(userService.getUserCar("BMW", 5));

      context.close();
   }
}
