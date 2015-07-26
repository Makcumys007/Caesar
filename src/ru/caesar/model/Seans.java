package ru.caesar.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by advirtys on 18.07.15.
 */
public class Seans  implements Cinima{
    private int id;
    private int filmId;
    private String filmTitle;
    private Date date;
    private String time;

    public Seans() {
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Seans(String time, Date date, int id) {
        this.time = time;
        this.date = date;
        this.id = id;
    }

    public Seans(int filmId, String filmTitle, String date, String time) {
        this.filmId = filmId;
        this.filmTitle = filmTitle;
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.time = time;
    }

    public Seans(String filmTitle, String date, String time) {
        this.filmTitle = filmTitle;
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.time = time;
    }

    public Seans(ResultSet resultSet) throws SQLException {
        setId(resultSet.getInt("id"));
        setFilmTitle(resultSet.getString("filmTitle"));
        setDate(resultSet.getDate("date"));
        setTime(resultSet.getString("time"));
        setId(resultSet.getInt("filmId"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id + " " + filmTitle + " " + date + " " + time;
    }
}
