package com.troot.dmstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;


public class MonsterListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    // @BindView(R.id.recycler_view)
    // RecyclerView recyclerView;


    private RecyclerViewAdapter mAdapter;

    private ArrayList<AbstractModel> modelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_list);
        this.setTitle("Monster List");
        // ButterKnife.bind(this);
        findViews();
        setAdapter();


    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }


    private void setAdapter() {

        final List<String> MonsterList = Variables.getMonsterList();
        final List<Integer> HealthList = Variables.getHealthList();
        final List<Integer> ArmourList = Variables.getArmourList();

        //for (String monster:MonsterList) {
        //    modelList.add(new AbstractModel(monster, "add this later"));
        //}
        for (int i = 0; MonsterList.size() > i; i++) {
            modelList.add(new AbstractModel(MonsterList.get(i), "AC: " + String.valueOf(ArmourList.get(i)) + " Health: " + String.valueOf(HealthList.get(i))));
        }

        /*modelList.add(new AbstractModel("Android", "Hello " + " Android"));
        modelList.add(new AbstractModel("Beta", "Hello " + " Beta"));
        modelList.add(new AbstractModel("Cupcake", "Hello " + " Cupcake"));
        modelList.add(new AbstractModel("Donut", "Hello " + " Donut"));
        modelList.add(new AbstractModel("Eclair", "Hello " + " Eclair"));
        modelList.add(new AbstractModel("Froyo", "Hello " + " Froyo"));
        modelList.add(new AbstractModel("Gingerbread", "Hello " + " Gingerbread"));
        modelList.add(new AbstractModel("Honeycomb", "Hello " + " Honeycomb"));
        modelList.add(new AbstractModel("Ice Cream Sandwich", "Hello " + " Ice Cream Sandwich"));
        modelList.add(new AbstractModel("Jelly Bean", "Hello " + " Jelly Bean"));
        modelList.add(new AbstractModel("KitKat", "Hello " + " KitKat"));
        modelList.add(new AbstractModel("Lollipop", "Hello " + " Lollipop"));
        modelList.add(new AbstractModel("Marshmallow", "Hello " + " Marshmallow"));
        modelList.add(new AbstractModel("Nougat", "Hello " + " Nougat"));
        modelList.add(new AbstractModel("Oreo", "Hello " + " Oreo"));
        modelList.add(new AbstractModel("Pie", "Hello " + " Pie"));
        modelList.add(new AbstractModel("Android Q", "Hello Q"));*/

        mAdapter = new RecyclerViewAdapter(MonsterListActivity.this, modelList);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(mAdapter);


        mAdapter.SetOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, AbstractModel model) {
                //handle item click events here
                HealthList.set(position, HealthList.get(position) - 1);
                Toast.makeText(MonsterListActivity.this, "Hit " + model.getTitle(), Toast.LENGTH_SHORT).show();
                if (HealthList.get(position) != 0) {
                    modelList.set(position, new AbstractModel(MonsterList.get(position), "AC: " + String.valueOf(ArmourList.get(position)) +" Health: " + String.valueOf(HealthList.get(position))));
                } else {
                    modelList.remove(position);
                    MonsterList.remove(position);
                    HealthList.remove(position);
                    ArmourList.remove(position);
                }
                mAdapter.updateList(modelList);
            }
        });
    }
}
