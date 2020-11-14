package com.jiajunhuang.ktblog.handlers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/404")
class NotFoundHandler {
    @GetMapping()
    fun notFound(): String {
        return "404"
    }
}