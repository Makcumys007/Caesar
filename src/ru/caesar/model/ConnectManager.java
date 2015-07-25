package ru.caesar.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}
