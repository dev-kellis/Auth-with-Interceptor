package kr.kellis.aawithinterceptor;

import kr.kellis.aawithinterceptor.app.dto.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class AawithinterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AawithinterceptorApplication.class, args);
    }

    @Bean
    CommandLineRunner init(MongoOperations operations) {
        return args -> {
            User commonUser = new User();
            commonUser.setUserId("kellis");
            commonUser.setPassword("1234");
            commonUser.setName("kellis");
            commonUser.setAuthority("USER");
            commonUser.setEnabled(true);

            User adminUser = new User();
            adminUser.setUserId("admin");
            adminUser.setPassword("1234");
            adminUser.setName("admin");
            adminUser.setAuthority("ADMIN");
            adminUser.setEnabled(true);

            operations.insert(commonUser);
            operations.insert(adminUser);

            operations.findAll(User.class).forEach(user -> {
                System.out.println(user.toString());
            });
        };
    }
}
