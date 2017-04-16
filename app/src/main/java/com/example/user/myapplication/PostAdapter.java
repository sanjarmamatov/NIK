package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 15.04.2017.
 */

public class PostAdapter extends ArrayAdapter<Posts> {

    public PostAdapter(Context context, int resourse, List<Posts>object){
        super(context ,resourse,object);
    }

public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.posty, parent, false);
    }

    Posts currentPosts = getItem(position);
    TextView tvPost=(TextView)convertView.findViewById(R.id.tvPost);

    tvPost.setText(currentPosts.getPost());

    return convertView;
}
}
