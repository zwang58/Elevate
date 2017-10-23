package com.example.android.elevate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment_container, new ToDoFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_mood) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_container, new MoodFragment()).commit();
        }
        if (id == R.id.action_todo) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.fragment_container, new ToDoFragment()).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
