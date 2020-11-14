package com.jiajunhuang.ktblog.handlers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ping")
class PingHandler {
   @GetMapping()
   fun ping(@RequestParam(name = "name", defaultValue = "") name: String): String {
      return "pong ${name}"
   }
}