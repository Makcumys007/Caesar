package ru.caesar_sinema.caesar_sinema.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by advirtys on 18.07.15.
 */
public class Seans {
    private String id;
    private String filmTitle;
    private String description;
    private String genre;
    private String img;
    private String length;
    private String year;
    private String date;
    private String time;


    public Seans() {
    }

    public Seans(String id, String filmTitle, String description, String genre, String img, String length, String year, String date, String time) {
        this.id = id;
        this.filmTitle = filmTitle;
        this.description = description;
        this.genre = genre;
        this.img = img;
        this.length = length;
        this.year = year;
        this.date = date;
        this.time = time;
    }

    public Seans(String filmTitle, String description, String genre, String img, String length, String year) {
        this.filmTitle = filmTitle;
        this.description = description;
        this.genre = genre;
        this.img = img;
        this.length = length;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
