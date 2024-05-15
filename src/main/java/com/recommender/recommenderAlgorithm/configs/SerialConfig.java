package com.recommender.recommenderAlgorithm.configs;

import com.recommender.recommenderAlgorithm.models.Serial;
import com.recommender.recommenderAlgorithm.repositories.SerialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SerialConfig {
    @Bean("serial")
    CommandLineRunner commandLineRunner(SerialRepository repository){
        return args -> {
            Serial house = new Serial(
                    "Доктор Хауз",
                    8,
                    45,
                    List.of("драма","детектив", "медицинский")
            );
            Serial sherlock = new Serial(
                    "Шерлок",
                    4,
                    90,
                    List.of("детектив", "триллер", "драма", "криминал")
            );
            Serial goodDoctor = new Serial(
                    "Хороший доктор",
                    7,
                    41,
                    List.of("драма", "медицинский")
            );
            Serial desperateHousewives = new Serial(
                    "Отчаянные домохозяйки",
                    8,
                    43,
                    List.of("драма", "мелодрама", "комедия", "детектив")
            );
            Serial bigBangTheory = new Serial(
                    "Теория большого взрыва",
                    12,
                    22,
                    List.of("мелодрама", "комедия")
            );
            Serial freshOfTheBoat = new Serial(
                    "Трудности ассимиляции",
                    6,
                    22,
                    List.of("комедия")
            );
            Serial mouse = new Serial(
                    "Мышь",
                    1,
                    70,
                    List.of("триллер", "детектив", "криминал")
            );
            Serial happiness = new Serial(
                    "Счастье",
                    1,
                    70,
                    List.of("фантастика", "драма", "мелодрама")
            );
            Serial dark = new Serial(
                    "Тьма",
                    3,
                    60,
                    List.of("триллер", "фантастика", "драма", "криминал", "детектив")
            );
            Serial friends = new Serial(
                    "Друзья",
                    10,
                    22,
                    List.of("комедия", "мелодрама")
            );
            repository.saveAll(List.of(house, sherlock, goodDoctor, desperateHousewives, bigBangTheory,
                    freshOfTheBoat, mouse, happiness, dark, friends));
        };
    }
}
