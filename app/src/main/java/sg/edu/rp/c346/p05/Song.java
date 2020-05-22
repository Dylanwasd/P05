package sg.edu.rp.c346.p05;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singer;
    private int year;
    private int stars;

    public Song(int id, String title, String singer, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }


    public String getSinger() {
        return singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public int getStars() {
        return stars;
    }
}
