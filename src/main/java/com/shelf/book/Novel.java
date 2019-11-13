package com.shelf.book;

public class Novel {

    private String title;
    private String author;
    private int chapters;
    private String text;

    public Novel() {
        this.title = "Candide";
        this.author = "Voltaire";
        this.chapters = 30;
        this.text = "I have wanted to kill myself a hundred times, but somehow I am still in love with life. This ridiculous weakness is perhaps one of our more stupid melancholy propensities, for is there anything more stupid than to be eager to go on carrying a burden which one would gladly throw away, to loathe one’s very being and yet to hold it fast, to fondle the snake that devours us until it has eaten our hearts away?";
    }

    public Novel(String title, String author, int chapters, String text) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
