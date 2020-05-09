package com.example.rotut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.ArrayList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class NewAccountActivity extends AppCompatActivity {
    private Firebase mRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
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
                mRef = new Firebase("gs://rotut-f0b32.appspot.com/Users");
                mAuth = FirebaseAuth.getInstance();
                String userID = mAuth.getUid();
                Firebase mRefChild = mRef.child(userID);
                Firebase fNameChild = mRefChild.child("First Name");
                Firebase lNameChild = mRefChild.child("Last Name");
                Firebase emailChild = mRefChild.child("Email");
                Firebase majorChild = mRefChild.child("Major");
                Firebase locChild = mRefChild.child("Location");
                Firebase schoolChild = mRefChild.child("School");
                Firebase classYChild = mRefChild.child("Class Year");
                Firebase classesTChild = mRefChild.child("Class Taken");
                if(!major.getText().toString().equals("") &&
                        !school.getText().toString().equals("") &&
                        !location.getText().toString().equals("") &&
                        !classYear.getText().toString().equals("")) {
                    fNameChild.setValue(bundle.getString("fName"));
                    lNameChild.setValue(bundle.getString("lName"));
                    emailChild.setValue(bundle.getString("email"));
                    majorChild.setValue(major.getText().toString());
                    locChild.setValue(location.getText().toString());
                    schoolChild.setValue(school.getText().toString());
                    classYChild.setValue(classYear.getText().toString());
                    classesTChild.setValue(classesTaken.getText().toString());


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
    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}
