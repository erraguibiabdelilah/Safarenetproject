package org.sid.springsecurity;

import org.sid.springsecurity.security.bean.AppRole;
import org.sid.springsecurity.security.bean.AppUser;
import org.sid.springsecurity.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

     @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"MANAGER-APT"));
            accountService.addNewRole(new AppRole(null,"MANAGER-VOI"));
            accountService.addNewRole(new AppRole(null,"USER"));

            accountService.addNewUser(new AppUser(null,"admin","admin",new ArrayList<>()));


            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","MANAGER-APT");
            accountService.addRoleToUser("admin","MANAGER-VOI");
            accountService.addRoleToUser("admin","USER");

        };
    }

}
