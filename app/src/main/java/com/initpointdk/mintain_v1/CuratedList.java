package com.initpointdk.mintain_v1;

public class CuratedList {
    private String bannarImage;
    private String title;
    private String shortDisc;
    private int numTitles;

    public CuratedList() {
    }

    public CuratedList(String bannarImage, String title, String shortDisc, int numTitles) {
        this.bannarImage = bannarImage;
        this.title = title;
        this.shortDisc = shortDisc;
        this.numTitles = numTitles;
    }

    public String getBannarImage() {
        return bannarImage;
    }

    public void setBannarImage(String bannarImage) {
        this.bannarImage = bannarImage;
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

    public int getNumTitles() {
        return numTitles;
    }

    public void setNumTitles(int numTitles) {
        this.numTitles = numTitles;
    }
}
