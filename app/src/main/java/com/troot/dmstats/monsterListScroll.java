package com.troot.dmstats;

import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class monsterListScroll extends Activity {

    // Call the monsterXMLParser method in monsterXMLParser.java
    monsterXMLParser xmlParser = new monsterXMLParser();



/* Can't use this under API 26, we need to allow down to 15
    Path path = Paths.get("values\\monster.xml");
    File file = path.toFile();
*/

    //InputStream xmlFileInSt =


    // Create parse object from parse method in monsterXMLParser.java
    List parse = xmlParser.parse(xmlFileInSt); // Need to grab monster.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list_scroll);
    }
}
