package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button bt;
    ListView listView;
    PostAdapter postAdapter ;
    List<Posts> post;
    private ChildEventListener childEventListener;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private DatabaseReference myRef = database.getReference("message");

    //Button newpost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview);
        bt=(Button)findViewById(R.id.button3);
        post = new ArrayList<>();
        postAdapter = new PostAdapter(this, R.layout.posty, post);
        listView.setAdapter(postAdapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main22Activity.class);
                startActivity(intent);
            }
        });
        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // ChatMessage chatMessage = dataSnapshot.getValue(ChatMessage.class);
                //chatMessageAdapter.add(chatMessage);
                Posts posts = dataSnapshot.getValue(Posts.class);
                postAdapter.add(posts);

            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        myRef.addChildEventListener(childEventListener);


    }
}
