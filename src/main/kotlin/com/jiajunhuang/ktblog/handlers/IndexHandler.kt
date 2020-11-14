package com.jiajunhuang.ktblog.handlers

import com.jiajunhuang.ktblog.models.Article
import com.jiajunhuang.ktblog.models.loadArticles
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class IndexHandler {
    @GetMapping()
    fun index(): List<Article> {
        return loadArticles("./articles")
    }
}