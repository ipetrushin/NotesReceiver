package com.example.gizmo.notesreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class NotesReceiver extends BroadcastReceiver {
    public NotesReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String note = intent.getStringExtra("com.example.gizmo.dbtest.Message");
        MainActivity.list.add(note);
        MainActivity.adapter.notifyDataSetChanged();
        Log.d("NotesRecv", "Note" + note);

    }
}
