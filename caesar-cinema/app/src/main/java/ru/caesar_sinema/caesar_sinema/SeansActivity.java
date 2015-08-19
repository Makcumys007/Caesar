package ru.caesar_sinema.caesar_sinema;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ru.caesar_sinema.caesar_sinema.adapter.SeansesAdapter;
import ru.caesar_sinema.caesar_sinema.pojo.Seans;

public class SeansActivity extends Activity {
    private Seans seans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seans);

        Intent intent = getIntent();
        String day = intent.getStringExtra("day");
        SeansTask task = new SeansTask();
        task.execute(day);
    }





     class SeansTask extends AsyncTask<String, Void, List<Seans>> {
         private List<Seans> list = new ArrayList<Seans>();

         @Override
         protected List<Seans> doInBackground(String...day) {
             if (day[0].equals("Mon")) {

                 try {
                     URL url = new URL("http://caesar-cinema.esy.es/get_seanses_of_day.php?dayOfWeek=Mon");
                     XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                     XmlPullParser pullParser = factory.newPullParser();
                     pullParser.setInput(url.openStream(), "UTF-8");

                     while (pullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                         if (pullParser.getEventType() == XmlPullParser.START_TAG
                                 && pullParser.getName().equals("seans")) {
                             seans = new Seans(pullParser.getAttributeValue(0),
                                     pullParser.getAttributeValue(1),
                                     pullParser.getAttributeValue(2),
                                     pullParser.getAttributeValue(3),
                                     pullParser.getAttributeValue(4),
                                     pullParser.getAttributeValue(5),
                                     pullParser.getAttributeValue(6),
                                     pullParser.getAttributeValue(7),
                                     pullParser.getAttributeValue(8));
                             list.add(seans);


                         }
                         pullParser.next();

                     }
                 } catch (XmlPullParserException e) {
                     e.printStackTrace();
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return list;
             } else if (day[0].equals("Tue")) {
                 try {

                     URL url = new URL("http://caesar-cinema.esy.es/get_seanses_of_day.php?dayOfWeek=Tue");
                     XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                     XmlPullParser pullParser = factory.newPullParser();
                     pullParser.setInput(url.openStream(), "UTF-8");
                     while (pullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                         if (pullParser.getEventType() == XmlPullParser.START_TAG
                                 && pullParser.getName().equals("seans")) {
                             Seans seans = new Seans(pullParser.getAttributeValue(0),
                                     pullParser.getAttributeValue(1),
                                     pullParser.getAttributeValue(2),
                                     pullParser.getAttributeValue(3),
                                     pullParser.getAttributeValue(4),
                                     pullParser.getAttributeValue(5),
                                     pullParser.getAttributeValue(6),
                                     pullParser.getAttributeValue(7),
                                     pullParser.getAttributeValue(8));
                             list.add(seans);


                         }
                         pullParser.next();

                     }
                 } catch (XmlPullParserException e) {
                     e.printStackTrace();
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return list;
             } else if (day[0].equals("Wed")) {
                 try {

                     URL url = new URL("http://caesar-cinema.esy.es/get_seanses_of_day.php?dayOfWeek=Wed");
                     XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                     XmlPullParser pullParser = factory.newPullParser();
                     pullParser.setInput(url.openStream(), "UTF-8");
                     while (pullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                         if (pullParser.getEventType() == XmlPullParser.START_TAG
                                 && pullParser.getName().equals("seans")) {
                             Seans seans = new Seans(pullParser.getAttributeValue(0),
                                     pullParser.getAttributeValue(1),
                                     pullParser.getAttributeValue(2),
                                     pullParser.getAttributeValue(3),
                                     pullParser.getAttributeValue(4),
                                     pullParser.getAttributeValue(5),
                                     pullParser.getAttributeValue(6),
                                     pullParser.getAttributeValue(7),
                                     pullParser.getAttributeValue(8));
                             list.add(seans);


                         }
                         pullParser.next();

                     }
                 } catch (XmlPullParserException e) {
                     e.printStackTrace();
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return list;
             } else if (day[0].equals("Thu")) {
                 try {

                     URL url = new URL("http://caesar-cinema.esy.es/get_seanses_of_day.php?dayOfWeek=Thu");
                     XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                     XmlPullParser pullParser = factory.newPullParser();
                     pullParser.setInput(url.openStream(), "UTF-8");
                     while (pullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                         if (pullParser.getEventType() == XmlPullParser.START_TAG
                                 && pullParser.getName().equals("seans")) {
                             Seans seans = new Seans(pullParser.getAttributeValue(0),
                                     pullParser.getAttributeValue(1),
                                     pullParser.getAttributeValue(2),
                                     pullParser.getAttributeValue(3),
                                     pullParser.getAttributeValue(4),
                                     pullParser.getAttributeValue(5),
                                     pullParser.getAttributeValue(6),
                                     pullParser.getAttributeValue(7),
                                     pullParser.getAttributeValue(8));
                             list.add(seans);


                         }
                         pullParser.next();

                     }
                 } catch (XmlPullParserException e) {
                     e.printStackTrace();
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return list;
             } else if (day[0].equals("Fri")) {
                 try {

                     URL url = new URL("http://caesar-cinema.esy.es/get_seanses_of_day.php?dayOfWeek=Fri");
                     XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                     XmlPullParser pullParser = factory.newPullParser();
                     pullParser.setInput(url.openStream(), "UTF-8");
                     while (pullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                         if (pullParser.getEventType() == XmlPullParser.START_TAG
                                 && pullParser.getName().equals("seans")) {
                             Seans seans = new Seans(pullParser.getAttributeValue(0),
                                     pullParser.getAttributeValue(1),
                                     pullParser.getAttributeValue(2),
                                     pullParser.getAttributeValue(3),
                                     pullParser.getAttributeValue(4),
                                     pullParser.getAttributeValue(5),
                                     pullParser.getAttributeValue(6),
                                     pullParser.getAttributeValue(7),
                                     pullParser.getAttributeValue(8));
                             list.add(seans);


                         }
                         pullParser.next();

                     }
                 } catch (XmlPullParserException e) {
                     e.printStackTrace();
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return list;
             } else if (day[0].equals("Sat")) {
                 try {

                     URL url = new URL("http://caesar-cinema.esy.es/get_seanses_of_day.php?dayOfWeek=Sat");
                     XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                     XmlPullParser pullParser = factory.newPullParser();
                     pullParser.setInput(url.openStream(), "UTF-8");
                     while (pullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                         if (pullParser.getEventType() == XmlPullParser.START_TAG
                                 && pullParser.getName().equals("seans")) {
                             Seans seans = new Seans(pullParser.getAttributeValue(0),
                                     pullParser.getAttributeValue(1),
                                     pullParser.getAttributeValue(2),
                                     pullParser.getAttributeValue(3),
                                     pullParser.getAttributeValue(4),
                                     pullParser.getAttributeValue(5),
                                     pullParser.getAttributeValue(6),
                                     pullParser.getAttributeValue(7),
                                     pullParser.getAttributeValue(8));
                             list.add(seans);


                         }
                         pullParser.next();

                     }
                 } catch (XmlPullParserException e) {
                     e.printStackTrace();
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return list;
             } else if (day[0].equals("Sun")) {
                 try {

                     URL url = new URL("http://caesar-cinema.esy.es/get_seanses_of_day.php?dayOfWeek=Sun");
                     XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                     XmlPullParser pullParser = factory.newPullParser();
                     pullParser.setInput(url.openStream(), "UTF-8");
                     while (pullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                         if (pullParser.getEventType() == XmlPullParser.START_TAG
                                 && pullParser.getName().equals("seans")) {
                             Seans seans = new Seans(pullParser.getAttributeValue(0),
                                     pullParser.getAttributeValue(1),
                                     pullParser.getAttributeValue(2),
                                     pullParser.getAttributeValue(3),
                                     pullParser.getAttributeValue(4),
                                     pullParser.getAttributeValue(5),
                                     pullParser.getAttributeValue(6),
                                     pullParser.getAttributeValue(7),
                                     pullParser.getAttributeValue(8));
                             list.add(seans);


                         }
                         pullParser.next();

                     }
                 } catch (XmlPullParserException e) {
                     e.printStackTrace();
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return list;
             } else {
                 return null;
             }
         }

         @Override
         protected void onPostExecute(final List<Seans> seanses) {


                 ListView listView = (ListView) findViewById(R.id.listView);
                 SeansesAdapter adapter = new SeansesAdapter(SeansActivity.this, seanses);
                 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                         Intent intent = new Intent(SeansActivity.this, FilmDescription.class);
                         intent.putExtra("title", seanses.get(position).getFilmTitle());
                         intent.putExtra("description", seanses.get(position).getDescription());
                         intent.putExtra("genre", seanses.get(position).getGenre());
                         intent.putExtra("img", seanses.get(position).getImg());
                         intent.putExtra("length", seanses.get(position).getLength());
                         intent.putExtra("year", seanses.get(position).getYear());
                         startActivity(intent);
                     }
                 });
                 listView.setAdapter(adapter);





         }
     }

}
