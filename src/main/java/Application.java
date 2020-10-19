import com.spring.practice.config.AppConfig;
import com.spring.practice.model.User;
import com.spring.practice.service.UserService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Richard", "Feynman", "physics.rules@gmail.com"));
        userService.add(new User("Hell", "Jordan", "lantern.guardian@nova.com"));
        userService.add(new User("Hagoromo", "Otsutsuki", "rikudo@bing.com"));
        userService.add(new User("Alexander", "Usyk", "boxing.master@gmail.com"));

        List<User> usersList = userService.listUsers();
        for (User user : usersList) {
            System.out.println(user);
        }
    }
}
