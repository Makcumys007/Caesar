package ru.caesar.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by advirtys on 18.07.15.
 */
public class ConnectManager {
    private static Connection connection;
    private static ConnectManager instance;

    private ConnectManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/caesar?useUnicode=true&characterEncoding=UTF8";
            connection = DriverManager.getConnection(url, "root", "gfyfcjybr02");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ConnectManager getInstance(){
        if (instance==null){
            instance = new ConnectManager();
        }
        return instance;
    }

    public List<Film> selectAllFilms() throws SQLException {
        List<Film> filmList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet set = null;
        try{
            statement = connection.prepareStatement("SELECT * FROM films");
            set = statement.executeQuery();
            while (set.next()){
                Film film = new Film(set);
                filmList.add(film);
            }
        } finally {
            if (set!=null){
                set.close();
            }
            if (statement!=null){
                statement.close();
            }
        }
        return filmList;
    }

    public void removeFilm(Film film) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM films WHERE id = ?");
            statement.setInt(1, film.getId());
            statement.execute();
        } finally {
            if (statement!=null){
                statement.close();
            }
        }
    }


    public void insertFilm(Film film) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO films (title, description, genre, img, time, year) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, film.getTitle());
            statement.setString(2, film.getDescription());
            statement.setString(3, film.getGenre());
            statement.setString(4, film.getImg());
            statement.setString(5, film.getTime());
            statement.setString(6, film.getYear());
            statement.execute();
        } finally {
            if (statement!=null){
                statement.close();
            }
        }

    }

    public void updateFilm(Film film) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE films SET title = ?, description = ?, genre = ?, img = ?, time = ?, year = ? WHERE id = ?");
            statement.setString(1, film.getTitle());
            statement.setString(2, film.getDescription());
            statement.setString(3, film.getGenre());
            statement.setString(4, film.getImg());
            statement.setString(5, film.getTime());
            statement.setString(6, film.getYear());
            statement.setInt(7, film.getId());
            statement.execute();
        } finally {
            if (statement!=null){
                statement.close();
            }
        }
    }

    public List<Seans> selectSeans(String seansTable) throws SQLException {
        List<Seans> seanses = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM " + seansTable);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Seans seans = new Seans(resultSet);
                seanses.add(seans);
            }


        } finally {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
        }
        return seanses;
    }

    public void insertSeans(Seans seans) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        String seansTable = new SimpleDateFormat("E").format(seans.getDate());
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO " + seansTable + " (filmId, filmTitle, date, time) VALUES(?,?,?,?)");
            statement.setInt(1, seans.getFilmId());
            statement.setString(2, seans.getFilmTitle());
            statement.setDate(3, new Date(seans.getDate().getTime()));
            statement.setString(4, seans.getTime());
            statement.execute();
        } finally {
            if (statement!=null){
                statement.close();
            }
        }
    }

    public void removeSeans(Seans seans, String seansTable) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM " + seansTable + " WHERE id = ?");
            statement.setInt(1, seans.getId());
            statement.execute();
        } finally {
            if (statement!=null){
                statement.close();
            }
        }
    }

    public void updateSeanse(Seans seans2) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        String seansTable = new SimpleDateFormat("E").format(seans2.getDate());
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE " + seansTable + " SET filmId = ?, filmTitle = ?, date = ?, time = ? WHERE id = ?");
            statement.setInt(1, seans2.getFilmId());
            statement.setString(2, seans2.getFilmTitle());
            statement.setDate(3, new Date(seans2.getDate().getTime()));
            statement.setString(4, seans2.getTime());
            statement.setInt(5, seans2.getId());
            statement.execute();
        } finally {
            if (statement!=null){
                statement.close();
            }
        }
    }

    public void removeSeans(Film film) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE  FROM Mon WHERE filmId = ?");
            statement.setInt(1, film.getId());
            statement.execute();
            statement = connection.prepareStatement("DELETE  FROM Tue WHERE filmId = ?");
            statement.setInt(1, film.getId());
            statement.execute();
            statement = connection.prepareStatement("DELETE  FROM Wed WHERE filmId = ?");
            statement.setInt(1, film.getId());
            statement.execute();
            statement = connection.prepareStatement("DELETE  FROM Fri WHERE filmId = ?");
            statement.setInt(1, film.getId());
            statement.execute();
            statement = connection.prepareStatement("DELETE  FROM Thu WHERE filmId = ?");
            statement.setInt(1, film.getId());
            statement.execute();
            statement = connection.prepareStatement("DELETE  FROM Sat WHERE filmId = ?");
            statement.setInt(1, film.getId());
            statement.execute();
            statement = connection.prepareStatement("DELETE  FROM Sun WHERE filmId = ?");
            statement.setInt(1, film.getId());
            statement.execute();
        } finally {
            if (statement!=null){
                statement.close();
            }
        }
    }
}
