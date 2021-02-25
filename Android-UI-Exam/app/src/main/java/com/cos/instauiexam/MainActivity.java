package com.cos.instauiexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvInstaContent;
    private RecyclerView rvInstaTop;
    private InstaContentAdapter instaContentAdapter;
    private  InstaTopAdapter instaTopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top();
        content();

    }

    private void top() {
        List<User> users = new ArrayList<>();

        for(int i=0; i<4; i++) {
            users.add(new User("_euno_eunho", R.drawable.punch));
            users.add(new User("punch", R.drawable.punch2));
            users.add(new User("programmer", R.drawable.punch3));
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvInstaTop = findViewById(R.id.rv_top);
        rvInstaTop.setLayoutManager(manager);

        instaTopAdapter = new InstaTopAdapter(users);
        rvInstaTop.setAdapter(instaTopAdapter);
    }

    private void content() {
        List<User> users = new ArrayList<>();

        users.add(new User("_euno_eunho", R.drawable.punch));
        users.add(new User("punch", R.drawable.punch2));
        users.add(new User("programmer", R.drawable.punch3));

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvInstaContent = findViewById(R.id.rv_content);
        rvInstaContent.setLayoutManager(manager);

        instaContentAdapter = new InstaContentAdapter(users);
        rvInstaContent.setAdapter(instaContentAdapter);
    }
}