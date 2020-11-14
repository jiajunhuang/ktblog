package com.jiajunhuang.ktblog.models;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.jiajunhuang.ktblog.models.ArticleKt.loadArticle;

@Service
public class JavaArticleLoader {
    public List<Article> loadArticles(String dirName) {
        List<Article> articles = new ArrayList<>();

        File dir = new File(dirName);
        dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name != "") {
                    articles.add(loadArticle(dir.getName(), name));
                }

                return false;
            }
        });

        articles.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o2.getFileName().compareTo(o1.getFileName());
            }
        });

        return articles;
    }
}
