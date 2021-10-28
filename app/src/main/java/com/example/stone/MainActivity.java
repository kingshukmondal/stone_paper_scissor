package com.example.stone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


  /*  Button paper =(Button) findViewById(R.id.paper);
    Button scissor=(Button) findViewById(R.id.scisors);
    Button reset=(Button) findViewById(R.id.reset);

    TextView cpu=(TextView) findViewById(R.id.cpuscore);
    TextView user=(TextView) findViewById(R.id.userscore);

    ImageView userimg=(ImageView) findViewById(R.id.userimg);
    ImageView cpuImg=(ImageView) findViewById(R.id.cpuimg);*/

    static int cwon=0;
    static int uwon=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        Button scissor=(Button) findViewById(R.id.scisors);
        Button paper =(Button) findViewById(R.id.paper);
        Button stone=(Button) findViewById(R.id.stone);
        scissor.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                display(2);
            }
        });

        paper.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                display(1);
            }
        });

        stone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                display(0);
            }
        });
        Button reset=(Button) findViewById(R.id.reset);
        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cwon=0;
                uwon=0;
                TextView res=(TextView) findViewById(R.id.winner);
                res.setText("");
                TextView cpu=(TextView) findViewById(R.id.cpuscore);
                TextView usr=(TextView) findViewById(R.id.userscore);
                ImageView userimg=(ImageView) findViewById(R.id.userimg);
                ImageView cpuImg=(ImageView) findViewById(R.id.cpuimg);
                userimg.setImageResource(R.drawable.ustone);
                cpuImg.setImageResource(R.drawable.cstone);
                cpu.setText(Integer.toString(cwon));
                usr.setText(Integer.toString(uwon));
                usr.setTextColor(Color.parseColor("#FFFFFF"));
                cpu.setTextColor(Color.parseColor("#FFFFFF"));

                TextView tv=(TextView) findViewById(R.id.cname);
                tv.setTextColor(Color.parseColor("#FFFFFF"));
                TextView tv1=(TextView) findViewById(R.id.uname);
                tv1.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
    }

    public void display(int user)
    {
        if(cwon <5 && uwon<5) {
            Button reset=(Button) findViewById(R.id.reset);
            reset.setClickable(false);
            reset.setBackgroundColor(Color.parseColor("#808080"));
            TextView cpu = (TextView) findViewById(R.id.cpuscore);
            TextView usr = (TextView) findViewById(R.id.userscore);
            Random rand = new Random();
            int comp = rand.nextInt(2);

            setImage(user, comp);
            TextView res=(TextView) findViewById(R.id.winner);
            if (comp == user) {
                res.setText("DRAW");
            } else {
                if ((comp == 1 && user == 0) || (comp == 2 && user == 1) || (comp == 0 && user == 2)) {
                    cwon++;
                    res.setText("COMPUTER");
                } else {
                    uwon++;
                    res.setText("USER");
                }
            }
            cpu.setText(Integer.toString(cwon));
            usr.setText(Integer.toString(uwon));

            if (cwon > uwon) {
                usr.setTextColor(Color.parseColor("#FF0000"));
                cpu.setTextColor(Color.parseColor("#00FF00"));
            } else if (cwon == uwon) {
                usr.setTextColor(Color.parseColor("#0000FF"));
                cpu.setTextColor(Color.parseColor("#0000FF"));
            } else {
                cpu.setTextColor(Color.parseColor("#FF0000"));
                usr.setTextColor(Color.parseColor("#00FF00"));
            }


            if (cwon == 5 || uwon == 5) {
                reset.setClickable(true);
                reset.setBackgroundColor(Color.parseColor("#FF0000"));
                if (cwon == 5) {
                    TextView tv = (TextView) findViewById(R.id.cname);
                    tv.setTextColor(Color.parseColor("#DFFF00"));
                }
                if (uwon == 5) {
                    TextView tv = (TextView) findViewById(R.id.uname);
                    tv.setTextColor(Color.parseColor("#DFFF00"));

                }
            }
        }
        else
        {
            Button reset=(Button) findViewById(R.id.reset);
            reset.setClickable(true);
            reset.setBackgroundColor(Color.parseColor("#FF0000"));
        }
    }

    public void setImage(int s,int def )
    {
        ImageView userimg=(ImageView) findViewById(R.id.userimg);
        ImageView cpuImg=(ImageView) findViewById(R.id.cpuimg);
        if(def==0)
        {
            cpuImg.setImageResource(R.drawable.cstone);
        }
        if(def==1)
        {
            cpuImg.setImageResource(R.drawable.cpaper);
        }
        if(def ==2)
        {
            cpuImg.setImageResource(R.drawable.cscissor);
        }
        if(s==0)
        {
            userimg.setImageResource(R.drawable.ustone);
        }
        if(s==1)
        {
            userimg.setImageResource(R.drawable.upaper);
        }
        if(s ==2)
        {
            userimg.setImageResource(R.drawable.uscissor);
        }

    }


 }
