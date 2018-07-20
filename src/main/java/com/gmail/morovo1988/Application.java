package com.gmail.morovo1988;

import com.gmail.morovo1988.DAO.UserService;
import com.gmail.morovo1988.Entity.*;
import com.gmail.morovo1988.Service.ContentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final UserService userService, final ContentService contentService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {


               Category category1 = new Category("Action") ;
               Category category2 = new Category("Comedian") ;
                Language language1 = new Language("English","ea");
                Language language2 = new Language("Ukrainian","ua");
                contentService.addCategory(category1);
                contentService.addCategory(category2);
                contentService.addLanguage(language1);
                contentService.addLanguage(language2);
                userService.addUser(new CustomUser("admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.ADMIN));
                userService.addUser(new CustomUser("user", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.USER));

                Content content1;
                Content content2;
                for (int i = 0; i < 15; i++) {
                    content1 = new Content("Video"+i,"some interesting video"+i ,language1, category1,"https://www.youtube.com/watch?v=6UUNyTNDIds");
                    content2 = new Content("Video"+i,"some interesting video"+i ,language2, category2,"https://www.youtube.com/watch?v=6UUNyTNDIds");
                    contentService.addContent(content1);
                    contentService.addContent(content2);
                }
            }
        };
    }


}