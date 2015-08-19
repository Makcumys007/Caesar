package ru.caesar.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by advirtys on 18.07.15.
 */
public class Film implements Cinima{
    private int id;
    private String title;
    private String description;
    private String genre;
    private String img;
    private String time;
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Film() {
    }

    public Film(int id, String title, String description, String genre, String img, String time, String year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.img = img;
        this.time = time;
        this.year = year;
    }

    public Film(String title, String description, String genre, String img, String time, String year) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.img = img;
        this.time = time;
        this.year = year;
    }

    public Film(ResultSet resultSet) throws SQLException {
        setId(resultSet.getInt("id"));
        setTitle(resultSet.getString("title"));
        setDescription(resultSet.getString("description"));
        setGenre(resultSet.getString("genre"));
        setImg(resultSet.getString("img"));
        setTime(resultSet.getString("time"));
        setYear(resultSet.getString("year"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + description + " " + genre + " " + img + " " + time + " " + year;
    }
}
