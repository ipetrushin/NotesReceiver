package com.example.gizmo.notesreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // static to be used in Broadcast Receiever
    static ArrayList<String> list;
    static ArrayAdapter<String> adapter;

    // "global" used vars
    ListView notes;
    Button addnote;

    public static final String NOTE_ADDED = "com.example.gizmo.dbtest.NOTE_ADDED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bindings
        notes = (ListView) findViewById(R.id.noteslist);
        addnote = (Button) findViewById(R.id.addnote);

        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, R.layout.item, list);
        notes.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void addnoteClick(View v)
    {
        list.add(Double.toString(Math.random()));
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
