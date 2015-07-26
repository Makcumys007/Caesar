package ru.caesar.test;

import ru.caesar.model.ConnectManager;
import ru.caesar.model.Film;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        ConnectManager connectManager = ConnectManager.getInstance();
        List<Film> filmList = connectManager.selectAllFilms();
        for (int i = 0; i < filmList.size(); i++) {
            System.out.println(filmList.get(i).toString());
        }
    }
}
