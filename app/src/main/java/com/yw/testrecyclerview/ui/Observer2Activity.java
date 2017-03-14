package com.yw.testrecyclerview.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.adapter.MyListAdapter;
import com.yw.testrecyclerview.observer2.MyObserver;
import com.yw.testrecyclerview.observer2.MyPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Observer2Activity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listView;
    MyListAdapter adapter;

    MyPerson observable;
    List<MyObserver> observers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer2);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        observable = new MyPerson();
        observers = new ArrayList<>();

        adapter = new MyListAdapter(getApplicationContext(), observers);
        listView.setAdapter(adapter);
    }


    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                addObserver();
                break;
            case R.id.button2:
                changeData();
                break;
        }
    }

    private void changeData() {
        for (MyObserver observer: observers){
            MyPerson person = observer.getMyPerson();
            if (person == null){
                person = new MyPerson();
            }
            int i = (int) (1000 * Math.random());
            person.setName("name: " + i);
            person.setAge(i);
            person.setGender("gender: " + (i - 10));
        }
        adapter.notifyDataSetChanged();
    }

    private void addObserver() {
        MyObserver observer = new MyObserver(observers.size() + 1);
        MyPerson myperson = new MyPerson();
        observer.setMyPerson(myperson);
        observable.addObserver(observer);
        observers.add(observer);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        observable.deleteObservers();
    }
}
