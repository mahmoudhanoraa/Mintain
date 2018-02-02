package com.initpointdk.mintain_v1;

public class Mint {
    private String title;
    private String shortDisc;
    private String intro;
    private String content;
    private String author;
    private String book;
    private String bookAuthor;
    private String date;
    private String bannar;
    private int numLikes;
    private int numFavorite;

    public Mint() {
    }

    public Mint(String title) {
        this.title = title;
    }

    public Mint(String title, String shortDisc, int numLikes) {
        this.title = title;
        this.shortDisc = shortDisc;
        this.numLikes = numLikes;
    }

    public Mint(String title, String author, String date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public Mint(String title, String shortDisc, String intro, String content, String author, String book, String bookAuthor, String date, String bannar, int numLikes, int numFavorite) {
        this.title = title;
        this.shortDisc = shortDisc;
        this.intro = intro;
        this.content = content;
        this.author = author;
        this.book = book;
        this.bookAuthor = bookAuthor;
        this.date = date;
        this.bannar = bannar;
        this.numLikes = numLikes;
        this.numFavorite = numFavorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDisc() {
        return shortDisc;
    }

    public void setShortDisc(String shortDisc) {
        this.shortDisc = shortDisc;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBannar() {
        return bannar;
    }

    public void setBannar(String bannar) {
        this.bannar = bannar;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumFavorite() {
        return numFavorite;
    }

    public void setNumFavorite(int numFavorite) {
        this.numFavorite = numFavorite;
    }
}
