package com.troot.dmstats;

import android.content.Intent;
import android.support.v7.app.AlertController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import com.troot.dmstats.monsterXMLParser;

public class monsterListActivity extends AppCompatActivity {

    // <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> // Dunno how to use this yet

    // monsterXMLParser

    //AlertController.RecycleListView recycleListView = (RecyclerListView)findViewById(R.id.)
    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
    recyclerView.setLayoutManager(layoutManager);

    //String test = .monsterXMLParser();
    monsterXMLParser xmlFile = new monsterXMLParser(); // Need to capitalize to MonsterXMLParser


    public String test() {
        String testing = "testing";
        return testing;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list);

        // Get the Intent that started this activity
        Intent intent = getIntent();
    }
}
