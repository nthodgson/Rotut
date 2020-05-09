package com.example.rotut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.ArrayList;

public class NewAccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.new_account);
        Toast.makeText(NewAccountActivity.this, "AccountActivity opened",Toast.LENGTH_SHORT).show();
        final Bundle bundle = getIntent().getExtras();
        Button createAccButton = (Button) findViewById(R.id.createAccount2);
        final EditText major = (EditText) findViewById(R.id.major);
        final EditText location = (EditText) findViewById(R.id.location);
        final EditText school = (EditText) findViewById(R.id.school);
        final EditText classYear = (EditText) findViewById(R.id.classYear);
        final EditText classesTaken = (EditText) findViewById(R.id.classesTaken);
        createAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!major.getText().toString().equals("") &&
                        !school.getText().toString().equals("") &&
                        !location.getText().toString().equals("") &&
                        !classYear.getText().toString().equals("")) {

                    User newAcc = new User(bundle.getString("fName"),bundle.getString("lName"),
                                            bundle.getString("email"),bundle.getString("passW"),
                                            major.getText().toString(), location.getText().toString(),
                                            school.getText().toString(), classYear.getText().toString(),
                                            new ArrayList<String>(Arrays.asList(
                                                    classesTaken.getText().toString().split(","))));
                    startActivity(new Intent(NewAccountActivity.this, SignInActivity.class));
                }else {
                    Toast.makeText(NewAccountActivity.this, "Error: all fields must be filled",Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
