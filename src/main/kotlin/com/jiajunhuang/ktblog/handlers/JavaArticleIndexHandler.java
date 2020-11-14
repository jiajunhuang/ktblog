package com.jiajunhuang.ktblog.handlers;

import com.jiajunhuang.ktblog.models.Article;
import com.jiajunhuang.ktblog.models.JavaArticleLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/java")
public class JavaArticleIndexHandler {
    @Autowired
    JavaArticleLoader demoArticleLoader;

    @GetMapping()
    public List<Article> index() {
        List<Article> articles = demoArticleLoader.loadArticles("./articles");

        return articles;
    }
}
