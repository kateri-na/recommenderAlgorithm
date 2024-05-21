package com.recommender.recommenderAlgorithm.configs;

import com.recommender.recommenderAlgorithm.models.Ratings;
import com.recommender.recommenderAlgorithm.repositories.RatingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RatingsConfig {
   @Bean("ratings")
    CommandLineRunner commandLineRunner(RatingsRepository repository){
       return args -> {
           Ratings eR00 = new Ratings(1l,1l,10.0);
           Ratings eR01 = new Ratings(1l,2l,0.0);
           Ratings eR02 = new Ratings(1l,3l,0.0);
           Ratings eR03 = new Ratings(1l,4l,0.0);
           Ratings eR04 = new Ratings(1l,5l,3.0);
           Ratings eR05 = new Ratings(1l,6l,2.5);
           Ratings eR06 = new Ratings(1l,7l,0.0);
           Ratings eR07 = new Ratings(1l,8l,8.0);
           Ratings eR08 = new Ratings(1l,9l,0.0);
           Ratings eR09 = new Ratings(1l,10l,2.3);

           Ratings eR10 = new Ratings(2l,1l,4.3);
           Ratings eR11 = new Ratings(2l,2l,0.0);
           Ratings eR12 = new Ratings(2l,3l,3.6);
           Ratings eR13 = new Ratings(2l,4l,8.0);
           Ratings eR14 = new Ratings(2l,5l,0.0);
           Ratings eR15 = new Ratings(2l,6l,5.8);
           Ratings eR16 = new Ratings(2l,7l,10.0);
           Ratings eR17 = new Ratings(2l,8l,0.0);
           Ratings eR18 = new Ratings(2l,9l,0.0);
           Ratings eR19 = new Ratings(2l,10l,7.0);

           Ratings eR20 = new Ratings(3l,1l,8.8);
           Ratings eR21 = new Ratings(3l,2l,0.0);
           Ratings eR22 = new Ratings(3l,3l,7.5);
           Ratings eR23 = new Ratings(3l,4l,0.0);
           Ratings eR24 = new Ratings(3l,5l,8.5);
           Ratings eR25 = new Ratings(3l,6l,8.0);
           Ratings eR26 = new Ratings(3l,7l,9.0);
           Ratings eR27 = new Ratings(3l,8l,0.0);
           Ratings eR28 = new Ratings(3l,9l,9.5);
           Ratings eR29 = new Ratings(3l,10l,0.0);

           Ratings eR30 = new Ratings(4l,1l,4.1);
           Ratings eR31 = new Ratings(4l,2l,4.3);
           Ratings eR32 = new Ratings(4l,3l,3.9);
           Ratings eR33 = new Ratings(4l,4l,0.0);
           Ratings eR34 = new Ratings(4l,5l,0.0);
           Ratings eR35 = new Ratings(4l,6l,8.8);
           Ratings eR36 = new Ratings(4l,7l,3.3);
           Ratings eR37 = new Ratings(4l,8l,0.0);
           Ratings eR38 = new Ratings(4l,9l,7.3);
           Ratings eR39 = new Ratings(4l,10l,0.0);

           repository.saveAll(List.of(eR00, eR01, eR02, eR03, eR04, eR05, eR06, eR07, eR08,eR09,
                                    eR10, eR11, eR12, eR13, eR14, eR15, eR16, eR17, eR18, eR19,
                                    eR20, eR21, eR22, eR23, eR24, eR25, eR26, eR27, eR28, eR29,
                                    eR30, eR31, eR32, eR33, eR34, eR35, eR36, eR37, eR38, eR39));
       };
   }
}
