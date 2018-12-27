package json.parser;

public class HeadNewsCNN {
    private String id;
    private String name;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publisherAt;
    private String content;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublisherAt(String publisherAt) {
        this.publisherAt = publisherAt;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublisherAt() {
        return publisherAt;
    }

    public String getContent() {
        return content;
    }

    public HeadNewsCNN(){
    }
    public HeadNewsCNN(String id, String name,String author, String title, String description, String url, String urlToImage, String publisherAt, String content){
        this.id = id;
        this.name=name;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publisherAt = publisherAt;
        this.content = content;
    }

    public HeadNewsCNN(String author, String title, String description, String url, String urlToImage, String publisherAt, String content){
        this.id = id;
        this.name=name;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publisherAt = publisherAt;
        this.content = content;
    }
}
