package com.recommender.recommenderAlgorithm.configs;

import com.recommender.recommenderAlgorithm.models.Log;
import com.recommender.recommenderAlgorithm.repositories.LogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LogConfig {
    @Bean("log")
    CommandLineRunner commandLineRunner(LogRepository repository){
        return args -> {
            Log log1 = new Log(
                    1,
                    2,
                    "просмотр описания"
            );
            Log log2 = new Log(
                    1,
                    2,
                    "просмотр количества сезонов и серий"
            );
            Log log3 = new Log(
                    1,
                    2,
                    "просмотр серии"
            );
            Log log4 = new Log(
                    1,
                    2,
                    "просмотр серии"
            );
            Log log5 = new Log(
                    1,
                    4,
                    "просмотр количества сезонов и серий"
            );
            Log log6 = new Log(
                    1,
                    4,
                    "просмотр описания"
            );
            Log log61 = new Log(
                    1,
                    4,
                    "просмотр серии"
            );
            Log log7 = new Log(
                    2,
                    9,
                    "просмотр описания"
            );
            Log log8 = new Log(
                    2,
                    9,
                    "просмотр серии"
            );
            Log log9 = new Log(
                    2,
                    9,
                    "просмотр серии"
            );
            Log log10 = new Log(
                    2,
                    9,
                    "просмотр серии"
            );
            Log log11 = new Log(
                    3,
                    10,
                    "просмотр серии"
            );
            Log log111 = new Log(
                    3,
                    10,
                    "просмотр серии"
            );
            Log log12 = new Log(
                    3,
                    8,
                    "просмотр серии"
            );
            Log log13 = new Log(
                    3,
                    8,
                    "просмотр количества сезонов и серий"
            );
            Log log14 = new Log(
                    3,
                    8,
                    "просмотр серии"
            );
            Log log15 = new Log(
                    4,
                    5,
                    "просмотр серии"
            );
            Log log16 = new Log(
                    4,
                    5,
                    "просмотр серии"
            );
            Log log17 = new Log(
                    4,
                    5,
                    "просмотр серии"
            );
            Log log18 = new Log(
                    4,
                    5,
                    "просмотр серии"
            );
            Log log19 = new Log(
                    4,
                    5,
                    "просмотр серии"
            );
            Log log20 = new Log(
                    4,
                    5,
                    "просмотр серии"
            );
            repository.saveAll(List.of(log1, log2, log3, log4, log5, log6, log61, log7, log8, log9, log10,
                    log11, log111, log12, log13, log14, log15, log16, log17, log18, log19, log20));
        };
    }
}
