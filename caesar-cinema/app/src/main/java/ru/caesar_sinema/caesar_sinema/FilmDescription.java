package ru.caesar_sinema.caesar_sinema;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ru.caesar_sinema.caesar_sinema.pojo.Seans;

public class FilmDescription extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_description);



       Intent intent = getIntent();
         String title = intent.getStringExtra("title");
         String description = intent.getStringExtra("description");
         String genre = intent.getStringExtra("genre");
         String length = intent.getStringExtra("length");
         String year = intent.getStringExtra("year");
         String img = intent.getStringExtra("img");

        TextView filmDescription= (TextView) findViewById(R.id.description);

        filmDescription.setText("Название:  " + title + "\n\n" + "Жанр: " + genre + "\n" +
                "\n" + "Год: " + year + "\n" +
                "\n" + "Длительность: " + length + "\n\n" +
                "\n" + description);

SeansTask seansTask = new SeansTask();
        seansTask.execute(img);





    }

    class SeansTask extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... src) {
            try {
                URL url = new URL(src[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream is = connection.getInputStream();
                Bitmap image = BitmapFactory.decodeStream(is);
                return image;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView imgFilm = (ImageView) findViewById(R.id.imgFilm);

            imgFilm.setImageBitmap(bitmap);
        }
    }




    }





