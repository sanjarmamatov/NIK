package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Main22Activity extends AppCompatActivity {
    Button bSend;
    EditText etPost;
    PostAdapter postAdapter ;
    List<Posts> posts;
    private ChildEventListener childEventListener;


    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference myRef = database.getReference("message");


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private  DatabaseReference myRef = database.getReference("username");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        Intent intent = getIntent();
        bSend =(Button)findViewById(R.id.button2);
        etPost = (EditText)findViewById(R.id.editText2);

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posts post = new Posts(etPost.getText().toString());


                myRef.push().setValue(post);

            }
        });





    }
}
