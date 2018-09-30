package com.wia.jwt;

import com.wia.jwt.entities.AppRole;
import com.wia.jwt.entities.AppUser;
import com.wia.jwt.entities.Task;
import com.wia.jwt.repositories.TaskRepository;
import com.wia.jwt.repositories.UserRepository;
import com.wia.jwt.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.stream.Stream;

@SpringBootApplication
public class JwtApplication implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;
     @Autowired
    UserRepository userRepository;
    @Autowired
   private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        accountService.saveUser(new AppUser(null,"admin","1234",null));
        accountService.saveUser(new AppUser(null,"user","1234",null));

        accountService.saveRole(new AppRole(null,"ADMIN"));
        accountService.saveRole(new AppRole(null,"USER"));

        accountService.addRoleToUser("admin","ADMIN");
        accountService.addRoleToUser("admin","USER");
        accountService.addRoleToUser("user","USER");

        Stream.of("T1","T2","T3").forEach(t ->{
            taskRepository.save(new Task(null,t));
        });
    taskRepository.findAll().forEach(t -> {
        System.out.println(t.getTaskName());
    });
    userRepository.findAll().forEach(appUser -> {
        System.out.println(appUser);
    });

    }

}
