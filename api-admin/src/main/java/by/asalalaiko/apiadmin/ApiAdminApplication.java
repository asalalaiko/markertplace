package by.asalalaiko.apiadmin;

import by.asalalaiko.apiadmin.dto.User;
import by.asalalaiko.apiadmin.repository.UserRepository;
import by.asalalaiko.apiadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class ApiAdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiAdminApplication.class, args);

    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder(8);
    }


}
