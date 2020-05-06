package com.example.rotut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Switch message;
        TextView Check_for_update;
        TextView Q_and_A_center;
        TextView About_us;
        Check_for_update=(TextView)findViewById(R.id.textView34);
        Q_and_A_center=(TextView)findViewById(R.id.textView35);
        About_us=(TextView)findViewById(R.id.textView36);
        message= (Switch) findViewById(R.id.switch3);
        // Make the switch work
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
        //Create intent for going to check for update page
        Check_for_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show_update =new Intent(SettingsActivity.this,updateActivity.class);
                startActivity (show_update);
            }
        });
        //create intent for going to Q and A center page
        Q_and_A_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Show_QA =new Intent(SettingsActivity.this,QAActivity.class);
                startActivity (Show_QA);
            }
        });
        // Create intent for go to about us page
        About_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Show_about =new Intent(SettingsActivity.this,About_usActivity.class);
                startActivity (Show_about);
            }
        });


    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}