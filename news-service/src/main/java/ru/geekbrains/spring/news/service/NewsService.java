package ru.geekbrains.spring.news.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class NewsService {

    private ArrayList<String> news;

    @PostConstruct
    private void init(){
        news = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            news.add("Новость " + i);
        }
    }

    public String getRandomNews(){
        return news.get((int)(Math.random()*10));
    }
}
