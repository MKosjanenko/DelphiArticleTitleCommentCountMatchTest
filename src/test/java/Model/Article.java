package Model;

public class Article {
    private String title;
    private Integer commentCount;
    private String photoLink;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount ) {
        this.commentCount = commentCount;
    }


    public void setCommentCount(String commentCount) {
        this.commentCount = Integer.parseInt(commentCount.substring(1, commentCount.length()-1));
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
