package com.example.rotut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class NewAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.new_account);

        configureNavigation();
    }

    private void configureNavigation() {
        ImageButton backArrow = (ImageButton) findViewById(R.id.backArrow5);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewAccountActivity.this, SignUpActivity.class));
            }
        });

        Button createAccountButton = (Button) findViewById(R.id.createAccount2);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewAccountActivity.this, SignInActivity.class));
            }
        });
    }
}
