package com.example.toast_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tV1, tV2, tV3, tV4, tV5, tV6;
    EditText eT1,eT2,eT3;
    ImageView iV1,iV2,iV3;
    Button btn, button1, button2, button3;
    Toast toast;

    Random rand = new Random();
    int rnd1 = 0, rnd2 = 0;
    String st;
    int answer = 0, counterRight = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // text views and set the second and third col to invisible
        tV1 =  findViewById(R.id.tV1);
        tV2 =  findViewById(R.id.tV2);
        tV3 =  findViewById(R.id.tV3);
        tV4 =  findViewById(R.id.tV4);
        tV5 =  findViewById(R.id.tV5);
        tV6 =  findViewById(R.id.tV6);

        tV2.setVisibility(View.INVISIBLE);
        tV3.setVisibility(View.INVISIBLE);
        tV5.setVisibility(View.INVISIBLE);
        tV6.setVisibility(View.INVISIBLE);

        //edit texts
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);

        eT2.setVisibility(View.INVISIBLE);
        eT3.setVisibility(View.INVISIBLE);

        //image views
        iV1 = findViewById(R.id.iV1);
        iV2 = findViewById(R.id.iV2);
        iV3 = findViewById(R.id.iV3);

        iV1.setVisibility(View.INVISIBLE);
        iV2.setVisibility(View.INVISIBLE);
        iV3.setVisibility(View.INVISIBLE);

        //button
        btn = findViewById(R.id.btn);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);

        // random numbers
        rnd1 = rand.nextInt(90)+10;
        rnd2 = rand.nextInt(90)+10;

        // The numbers are displayed on the screen.
        tV1.setText(String.valueOf(rnd1));
        tV4.setText(String.valueOf(rnd2));
    }


    public void clickNew(View view) {
        counterRight = 0;
        btn.setText("New");

        tV2.setVisibility(View.INVISIBLE);
        tV3.setVisibility(View.INVISIBLE);
        tV5.setVisibility(View.INVISIBLE);
        tV6.setVisibility(View.INVISIBLE);

        eT2.setVisibility(View.INVISIBLE);
        eT3.setVisibility(View.INVISIBLE);

        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);

        iV1.setVisibility(View.INVISIBLE);
        iV2.setVisibility(View.INVISIBLE);
        iV3.setVisibility(View.INVISIBLE);

        eT1.getText().clear();
        eT2.getText().clear();
        eT3.getText().clear();

        rnd1 = rand.nextInt(90)+10;
        rnd2 = rand.nextInt(90)+10;
        tV1.setText(String.valueOf(rnd1));
        tV4.setText(String.valueOf(rnd2));
    }

    public void btn1click(View view) {
        if(eT2.getVisibility() == View.INVISIBLE)
        {
            st = eT1.getText().toString();
            if(st.equals(""))
            {
                toast.makeText(this,  "invalid input", toast.LENGTH_SHORT).show();
            }
            else
            {
                answer = Integer.parseInt(st);
            }

            if(answer == rnd1+rnd2)
            {
                iV1.setImageResource(R.drawable.vi);
                counterRight++;
            }
            else
            {
                iV1.setImageResource(R.drawable.x);
            }
            iV1.setVisibility(View.VISIBLE);

            rnd1 += rnd2;
            rnd2 = rand.nextInt(90)+10;
            tV2.setText(String.valueOf(rnd1));
            tV5.setText(String.valueOf(rnd2));

            eT2.setVisibility(View.VISIBLE);
            tV2.setVisibility(View.VISIBLE);
            tV5.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
        }
    }

    public void btn2click(View view) {
        if (eT3.getVisibility() == View.INVISIBLE)
        {
            st = eT2.getText().toString();
            if(st.equals(""))
            {
                toast.makeText(this,  "invalid input", toast.LENGTH_SHORT).show();
            }
            else
            {
                answer = Integer.parseInt(st);
            }

            if(answer == rnd1+rnd2)
            {
                iV2.setImageResource(R.drawable.vi);
                counterRight++;
            }
            else
            {
                iV2.setImageResource(R.drawable.x);
            }
            iV2.setVisibility(View.VISIBLE);

            rnd1 += rnd2;
            rnd2 = rand.nextInt(90)+10;
            tV3.setText(String.valueOf(rnd1));
            tV6.setText(String.valueOf(rnd2));

            eT3.setVisibility(View.VISIBLE);
            tV3.setVisibility(View.VISIBLE);
            tV6.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
        }
    }

    public void btn3click(View view) {
        st = eT3.getText().toString();
        if(st.equals(""))
        {
            toast.makeText(this,  "invalid input", toast.LENGTH_SHORT).show();
        }
        else
        {
            answer = Integer.parseInt(st);
        }

        if(answer == rnd1+rnd2)
        {
            iV3.setImageResource(R.drawable.vi);
            counterRight++;
        }
        else
        {
            iV3.setImageResource(R.drawable.x);
        }
        iV3.setVisibility(View.VISIBLE);

        toast.makeText(this, counterRight + "/3 ," + (int)(33.36*counterRight) + "%", toast.LENGTH_SHORT).show();
    }
}