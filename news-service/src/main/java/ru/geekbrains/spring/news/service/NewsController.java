package ru.geekbrains.spring.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/news")
public class NewsController {

    private NewsService newsService;
    @Autowired
    public void setNewsService(NewsService newsService){
        this.newsService = newsService;
    }

    public static String responseUrl;


    @PostMapping
    public String showRandomNews(Model model,
                                 HttpServletRequest request,
                                 @RequestParam(required = false) String totalQuantity,
                                 @RequestParam(required = false) String totalCost){
        responseUrl = "http://localhost:" + request.getHeader("fromPort");
        model.addAttribute("news", newsService.getRandomNews());
        model.addAttribute("responseUrl", responseUrl);
        model.addAttribute("totalQuantity", totalQuantity);
        model.addAttribute("totalCost", totalCost);
        return "news";
    }
}
