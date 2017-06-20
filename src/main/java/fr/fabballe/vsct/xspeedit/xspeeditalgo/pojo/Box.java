package fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fabballe on 20/06/17.
 */
public class Box {

    private Integer maxWeight;

    private List<Article> articles = new ArrayList<>();

    public Box(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer sumArticleWeigth() {
        return articles.stream()
                .parallel()
                .map(article -> article.getWeight())
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public Boolean isFull() {
        return this.sumArticleWeigth() >= maxWeight;
    }

    public void addArticleIntoBox(Article article){
        this.articles.add(article);
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    @Override
    public String toString() {
        return articles.parallelStream()
                .map(article -> String.valueOf(article.getWeight()))
                .collect(Collectors.joining());
    }
}
