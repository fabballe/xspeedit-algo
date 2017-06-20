package fr.fabballe.vsct.xspeedit.xspeeditalgo.pojo;

/**
 * Article POJO with a weight
 * Created by fabballe on 20/06/17.
 */
public class Article {

    /**
     * The weight of the article
     */
    private Integer weight;

    /**
     * Default contrusctor
     * @param weight the weight of the article
     */
    public Article(Integer weight) {
        this.weight = weight;
    }

    /* GETTER/SETTER */
    public Integer getWeight() {
        return weight;
    }

}
