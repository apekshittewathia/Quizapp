package com.example.apekshit.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class score extends AppCompatActivity {
TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        t1=(TextView)findViewById(R.id.textView2);
        t2=(TextView)findViewById(R.id.textView3);
        t3=(TextView)findViewById(R.id.textView4);
        t4=(TextView)findViewById(R.id.textView6);
        Intent i=getIntent();
        t1.setText("Number of Questions: "+i.getIntExtra("count",-1));
        t2.setText("Correct Answers: "+i.getIntExtra("score",-1));
        t3.setText("Wrong Answers: "+(i.getIntExtra("count",-1)-i.getIntExtra("score",-1)));
        t4.setText("Score: "+i.getIntExtra("score",-1)+"/"+i.getIntExtra("count",-1));


    }
}
