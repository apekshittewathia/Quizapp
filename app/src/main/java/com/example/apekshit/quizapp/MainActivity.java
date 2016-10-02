package com.example.apekshit.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b1;
Button b2;
Button b3;
Button b4;
Button b5;
Button b6;
    int i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        preparedatabase();
    }

    public void preparedatabase(){
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sp.edit();
        i1=0;
        i2=0;
            editor.putString("cricket"+i1,"What is the middle name of Sachin Tendulkar?\nA.Suresh\nB.Ramakant\nC.Ramesh\nD.Kumar");
            editor.putString("cricket"+i1+"ans","C");
        i1++;
        editor.putString("cricket"+i1,"Which is first Indian cricket tournament ?\nA.Pepsi Cup\nB.Bombay Series\nC.Bombay Triangular\nD.None of these");
        editor.putString("cricket"+i1+"ans","C");
        i1++;
        editor.putString("cricket"+i1,"Which of the following is first cricket club in India ?\nA.Oriental Cricket Club\nB.East Indian Cricket Club\nC.Bombay Cricket Club\nD.Maharashtra Cricket Club");
        editor.putString("cricket"+i1+"ans","A");
        i1++;
        editor.putString("cricket"+i1,"Indian played first test match against ________ .\nASouth Africa\nBAustralia\nCEngland\nDPakistan");
        editor.putString("cricket"+i1+"ans","C");
        i1++;
        editor.putString("cricket"+i1,"Indian played first ODI match against ________ .\nASouth Africa\nBAustralia\nCEngland\nDPakistan");
        editor.putString("cricket"+i1+"ans","C");
        i1++;



        editor.putString("bollywood"+i2,"Who, apart from Aamir Khan, wants to marry Preity Zinta in Dil Chahta Hai?\n" +
                "       A Saif Ali Khan\n" +
                "       B Akshaye Khanna\n" +
                "       C Ayub Khan\n" +
                "       D Shah Rukh Khan");
        editor.putString("bollywood"+i2+"ans","C");
        i2++;
        editor.commit();
    }


  public void cricket(View v){
       Intent i=new Intent(this,question.class);
       i.putExtra("category","cricket");
      i.putExtra("count",i1);
       startActivity(i);
   }
    public void bollywood(View v){
        Intent i=new Intent(this,question.class);
        i.putExtra("category","bollywood");
        i.putExtra("count",i2);
        startActivity(i);
    }
   public void sports(View v){
        Intent i=new Intent(this,question.class);
        i.putExtra("category","sports");
        startActivity(i);
    }
   public void science(View v){
        Intent i=new Intent(this,question.class);
        i.putExtra("category","science");
        startActivity(i);
    }
   public void general(View v){
        Intent i=new Intent(this,question.class);
        i.putExtra("category","general");
        startActivity(i);
    }
   public void food(View v){
        Intent i=new Intent(this,question.class);
        i.putExtra("category","food");
        startActivity(i);
    }













    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
