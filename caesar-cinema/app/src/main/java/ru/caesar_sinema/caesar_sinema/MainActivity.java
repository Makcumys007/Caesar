package ru.caesar_sinema.caesar_sinema;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickMon(View view){
        Intent intent = new Intent(this, SeansActivity.class);
        intent.putExtra("day", "Mon");
        startActivity(intent);
    }

    public void onClickTue(View view){
        Intent intent = new Intent(this, SeansActivity.class);
        intent.putExtra("day", "Tue");
        startActivity(intent);
    }

    public void onClickWed(View view){
        Intent intent = new Intent(this, SeansActivity.class);
        intent.putExtra("day", "Wed");
        startActivity(intent);
    }

    public void onClickThu(View view){
        Intent intent = new Intent(this, SeansActivity.class);
        intent.putExtra("day", "Thu");
        startActivity(intent);
    }

    public void onClickFri(View view){
        Intent intent = new Intent(this, SeansActivity.class);
        intent.putExtra("day", "Fri");
        startActivity(intent);
    }

    public void onClickSat(View view){
        Intent intent = new Intent(this, SeansActivity.class);
        intent.putExtra("day", "Sat");
        startActivity(intent);
    }

    public void onClickSun(View view){
        Intent intent = new Intent(this, SeansActivity.class);
        intent.putExtra("day", "Sun");
        startActivity(intent);
    }
}
