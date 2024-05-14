package com.recommender.recommenderAlgorithm.configs;

import com.recommender.recommenderAlgorithm.models.User;
import com.recommender.recommenderAlgorithm.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User Maria = new User(
                    "Овчинникова",
                    "Мария",
                    "Дмитриевна",
                    "OvMariam@mail.ru"
            );
            User Grigoriy = new User(
                    "Исаев",
                    "Григорий",
                    "Иванович",
                    "IsaevGrigor@mail.ru"
            );
            User Sofia = new User(
                    "Панкова",
                    "Софья",
                    "Михайловна",
                    "PankSofi@mail.ru"
            );
            User Timofey = new User(
                    "Волков",
                    "Тимофей",
                    "Алексеевич",
                    "VolkovTim@mail.ru"
            );
            repository.saveAll(List.of(Maria, Grigoriy, Sofia, Timofey));
        };
    }
}
