package fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fabballe on 20/06/17.
 */
public class Box {

    private Integer maxWeidth;

    private List<Article> articles = new ArrayList<>();

    public Box(Integer maxWeidth) {
        this.maxWeidth = maxWeidth;
    }

    public Integer sumArticleWeidth() {
        return articles.stream()
                .parallel()
                .map(article -> article.getWeight())
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public Boolean isFull() {
        return this.sumArticleWeidth() >= maxWeidth;
    }

    public void addArticleIntoBox(Article article){
        this.articles.add(article);
    }
}
