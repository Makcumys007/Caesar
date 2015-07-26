package ru.caesar.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by advirtys on 18.07.15.
 */
public class Seans  implements Cinima{
    private int id;
    private int filmId;
    private Date date;
    private String time;

    public Seans() {
    }

    public Seans(String time, Date date, int id) {
        this.time = time;
        this.date = date;
        this.id = id;
    }

    public Seans(int filmId, Date date, String time) {
        this.filmId = filmId;
        this.date = date;
        this.time = time;
    }

    public Seans(ResultSet resultSet) throws SQLException {
        setId(resultSet.getInt("id"));
        setFilmId(resultSet.getInt("filmId"));
        setDate(resultSet.getDate("date"));
        setTime(resultSet.getString("time"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
        return id + " " + filmId + " " + date + " " + time;
    }
}
