package com.jiajunhuang.ktblog.models

import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

data class Article(
        val fileName: String,
        val date: Date,
        val dirName: String,
        val title: String,
        val content: String,
)

fun loadArticles(dirName: String): List<Article> {
    var articles: MutableList<Article> = ArrayList<Article>()

    File(dirName).walkTopDown().filter { it.isFile() }.forEach { articles.add(loadArticle(dirName, it.name)) }

    return articles
}

fun loadArticle(dirName: String, fileName: String): Article {
    val path = "${dirName}/${fileName}"

    val file = File(path)

    val lines = file.readLines()
    val date = parseDate(fileName)
    val title = getTitle(lines[0])
    val content = lines.slice(1 until lines.size).joinToString(separator = "\n")

    return Article(fileName, date, dirName, title, content)
}

private fun parseDate(fileName: String): Date {
    // fileName should write in this style: yyyy_MM_dd-your_title.md
    val match = Regex("(\\d{4}_\\d{2}_\\d{2})-.+\\..+").find(fileName)!!
    val dateString = match.destructured.toList()!![0]

    return SimpleDateFormat("yyyy_MM_dd").parse(dateString)
}

private fun getTitle(s: String): String {
    if (s.startsWith("# ")) {
        return s.removePrefix("# ")
    }

    return s
}