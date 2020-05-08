package com.example.rotut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.settings);
        Switch message;
        Switch location;
        TextView update;
        TextView about;
        Button sign_out;
        ImageButton arrow;
        TextView Q_A;
        message=findViewById(R.id.switch3);
        location=findViewById(R.id.switch4);
        update=findViewById(R.id.textView34);
        about=findViewById(R.id.textView36);
        sign_out=findViewById(R.id.sign_out_button);
        Q_A=findViewById(R.id.textView35);
        arrow=findViewById(R.id.backArrow4);


        message.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    Toast.makeText(getBaseContext(),"On",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(),"Off",Toast.LENGTH_SHORT).show();

                }
            }
        });

        location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    Toast.makeText(getBaseContext(),"On",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(),"Off",Toast.LENGTH_SHORT).show();

                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent check_update=new Intent(SettingsActivity.this,updateActivity.class);
                startActivity(check_update);
            }
        });

        Q_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Q_and_A=new Intent(SettingsActivity.this,QAActivity.class);
                startActivity(Q_and_A);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wheaton;
                wheaton="https://wheatoncollege.edu";
                Uri web=Uri.parse(wheaton);
                Intent go_wheaton=new Intent(Intent.ACTION_VIEW,web);
                if(go_wheaton.resolveActivity(getPackageManager()) !=null){
                    startActivity(go_wheaton);
                }

            }
        });

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign_out=new Intent(SettingsActivity.this,SignInActivity.class);
                startActivity(sign_out);
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back=new Intent(SettingsActivity.this,AccountActivity.class);
                startActivity(go_back);
            }
        });


    }
}
