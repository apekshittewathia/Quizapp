package com.example.apekshit.quizapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class question extends AppCompatActivity {
TextView quest,solution,score;
    EditText answer;
    Button bstop,bcheck,bnext,butA,butB,butC,butD;
    SharedPreferences sp;
    int i;
    int sc;
    int count;
    String category;
    ProgressBar progressBar;
    TextView textCounter;
    MyCountDownTimer myCountDownTimer;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category=getIntent().getStringExtra("category");
        count=getIntent().getIntExtra("count",-1);
        i=0;
        sc=0;
        setContentView(R.layout.activity_question);
        quest=(TextView)findViewById(R.id.quest);
        solution=(TextView)findViewById(R.id.solution);
        score=(TextView)findViewById(R.id.score);
        answer=(EditText)findViewById(R.id.answer);
        bstop=(Button)findViewById(R.id.button8);
        bcheck=(Button)findViewById(R.id.opta);
        bnext=(Button)findViewById(R.id.button9);
        butA=(Button)findViewById(R.id.opta);
        butB=(Button)findViewById(R.id.optb);
        butC=(Button)findViewById(R.id.optc);
        butD=(Button)findViewById(R.id.optd);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        textCounter = (TextView)findViewById(R.id.counter);
        setup();
    }
    public void setup(){
        sp= PreferenceManager.getDefaultSharedPreferences(this);
        quest.setText(sp.getString(category + i, "No question"));
        Toast.makeText(this,sp.getString(category + i+"ans", "null"),Toast.LENGTH_SHORT).show();
        progressBar.setProgress(100);
        myCountDownTimer = new MyCountDownTimer(10000, 1000);
        myCountDownTimer.start();

    }
    public void A(final View v){
        if(sp.getString(category+i+"ans","null").equals("A")){
            sc++;
            butA.setBackgroundColor(Color.GREEN);
        }
  else{
            butA.setBackgroundColor(Color.RED);

        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                butA.setBackgroundColor(Color.GRAY);

                next(v);
            }
        }, 1000);
    }

    public void B(final View v){
        if(sp.getString(category+i+"ans","null").equals("B")){
            sc++;
            butB.setBackgroundColor(Color.GREEN);
        }
        else{
            butB.setBackgroundColor(Color.RED);

        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                butB.setBackgroundColor(Color.GRAY);

                next(v);
            }
        }, 1000);
    }
    public void C(final View v){
        if(sp.getString(category+i+"ans","null").equals("C")){
            sc++;
            butC.setBackgroundColor(Color.GREEN);
        }
        else{
            butC.setBackgroundColor(Color.RED);

        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                butC.setBackgroundColor(Color.GRAY);
                next(v);
            }
        }, 1000);
    }
    public void D(final View v){
        if(sp.getString(category+i+"ans","null").equals("D")){
            sc++;
            butD.setBackgroundColor(Color.GREEN);
        }
        else{
            butD.setBackgroundColor(Color.RED);

        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                butD.setBackgroundColor(Color.GRAY);

                next(v);
            }
        }, 1000);
    }


/*
    public void check(View v){
        if(answer.getText().toString().equalsIgnoreCase(sp.getString(category+i+"ans", "null"))) {
            sc++;

            //      solution.setText("Correct Answer!");
        }else if(answer.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this,"Answer Field can't be empty",Toast.LENGTH_SHORT).show();
                    return;
            }
        else{
      //      solution.setText("Wrong Answer!Try Again");
        }
        next(v);
    }*/
    public void stop(View v){
        score.setText("Score:"+sc+"/"+count);
    }
    public void next(View v){
    view=v;
        i++;
        myCountDownTimer.cancel();

        if(i>=count){

            //Toast.makeText(this,"No more questions",Toast.LENGTH_LONG).show();
            //stop(v);
            Intent in=new Intent(this,score.class);
            in.putExtra("score",sc);
            in.putExtra("count",count);
            startActivity(in);
            return;
        }

        progressBar.setProgress(100);
        myCountDownTimer = new MyCountDownTimer(10000, 1000);
        myCountDownTimer.start();
        Toast.makeText(this,sp.getString(category + i+"ans", "null"),Toast.LENGTH_SHORT).show();
        score.setText("Score:"+sc+"/"+count);
        quest.setText(sp.getString(category+i,"No questions available"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            textCounter.setText(String.valueOf(millisUntilFinished/1000));
            int progress = (int) (millisUntilFinished/100);
            progressBar.setProgress(progress);
        }

        @Override
        public void onFinish() {
            textCounter.setText("0");
            progressBar.setProgress(0);
            next(view);
        }

    }
}




