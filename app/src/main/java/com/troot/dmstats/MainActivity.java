package com.troot.dmstats;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public List<String> MonsterList = new ArrayList<>();
    public List<Integer> HealthList = new ArrayList<>();
    public List<Integer> ArmourClassList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MonsterListActivity.class);
        Variables.setMonsterList(MonsterList);
        Variables.setHealthList(HealthList);
        Variables.setArmourList(ArmourClassList);
        //for (String monster:MonsterList) {
        //Toast.makeText(MainActivity.this, monster, Toast.LENGTH_SHORT).show();
        //}
        startActivity(intent);

    }


    public void onClick(View view) {
        showAddItemDialog(MainActivity.this);
    }


    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Monster Name")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        MonsterList.add(task);

                        //Health
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("Enter Monster Health");
                        final EditText input = new EditText(MainActivity.this);
                        input.setInputType(InputType.TYPE_CLASS_NUMBER);
                        input.setRawInputType(Configuration.KEYBOARD_12KEY);
                        alert.setView(input);
                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String healthStr = String.valueOf(input.getText());
                                int health = Integer.parseInt(healthStr);
                                HealthList.add(health);
                            }
                        });
                        alert.show();

                        //Armour Class
                        AlertDialog.Builder alertac = new AlertDialog.Builder(MainActivity.this);
                        alertac.setTitle("Enter Monster AC");
                        final EditText inputac = new EditText(MainActivity.this);
                        inputac.setInputType(InputType.TYPE_CLASS_NUMBER);
                        inputac.setRawInputType(Configuration.KEYBOARD_12KEY);
                        alertac.setView(inputac);
                        alertac.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String acStr = String.valueOf(inputac.getText());
                                int ac = Integer.parseInt(acStr);
                                ArmourClassList.add(ac);
                            }
                        });
                        alertac.show();

                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

    public void clearClick(View view) {
        List<String> clearList = new ArrayList<>();
        Variables.setMonsterList(clearList);
    }

}
