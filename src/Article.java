import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chenwenping on 17/4/10.
 */
public class Article {
    private final String title;
    private final String author;
    private final List<String> tags;

    private Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    public Article getFirstJavaArticle(Article[] articles) {

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }

        return null;
    }

    public Optional<Article> getFirstJavaArticle(Article[] articles) {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    Collectors.toSet();

    public Map<String, List<Article>> groupByAuthor() {

        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> articles = new ArrayList<>();
                articles.add(article);
                result.put(article.getAuthor(), articles);
            }
        }

        return result;
    }

    public Map<String, List<Article>> groupByAuthor() {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }


}
