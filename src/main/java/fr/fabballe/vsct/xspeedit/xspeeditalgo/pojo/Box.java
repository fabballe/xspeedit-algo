package fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * POJO of a Box. A Box have a maximum weight that the sum of the weight of article can be over
 * Created by fabballe on 20/06/17.
 */
public class Box {

    /**
     * Maximum weight of the box
     */
    private Integer maxWeight;

    /**
     * List of article inside the box
     */
    private List<Article> articles = new ArrayList<>();

    /**
     * Default constructor
     * @param maxWeight
     */
    public Box(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Calculate the sum of weight inside the box
     * @return the sum of weight
     */
    public Integer sumArticleWeight() {
        return articles.stream()
                .parallel()
                .map(article -> article.getWeight())
                .collect(Collectors.summingInt(Integer::intValue));
    }

    /**
     * Test if the box is full (aka sumArticleWeight equals or greater than maxWeight
     * @return
     */
    public Boolean isFull() {
        return this.sumArticleWeight() >= this.maxWeight;
    }

    /**
     * Add an article inside the box
     * @param article the article to add
     */
    public void addArticleIntoBox(Article article) {
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
