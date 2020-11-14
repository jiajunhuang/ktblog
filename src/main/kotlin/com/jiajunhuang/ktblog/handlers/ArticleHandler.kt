package com.jiajunhuang.ktblog.handlers

import com.jiajunhuang.ktblog.models.loadArticle
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.*
import java.io.FileNotFoundException
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/article")
class ArticleHandler {
    @GetMapping("/{filePath}")
    fun sendFile(@NotNull @PathVariable filePath: String, httpServletResponse: HttpServletResponse): String {
        try {
            val article = loadArticle("./articles", filePath)
            return article.content
        } catch (e: FileNotFoundException) {
            httpServletResponse.sendRedirect("/404")
            return ""
        }
    }
}