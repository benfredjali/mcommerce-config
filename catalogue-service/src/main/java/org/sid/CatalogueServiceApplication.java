package org.sid;

import org.sid.entities.AppRole;
import org.sid.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class CatalogueServiceApplication implements CommandLineRunner {



    public static void main(String[] args)  {
        SpringApplication.run(CatalogueServiceApplication.class, args);
    }


    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

    }


//    @Bean
//    CommandLineRunner start(AccountService accountService) { return args->{
//
//
//            accountService.save(new AppRole("USER"));
//            accountService.save(new AppRole( "ADMIN"));
//            Stream.of("user1", "user2", "user3", "admin").forEach(un->{
//                accountService.saveUser(un, "1234", "1234");
//            });
//            accountService.addRoleToUser("admin","ADMIN");
//
//        };
//
//    }

}
