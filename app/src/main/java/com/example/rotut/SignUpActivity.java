package com.example.rotut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rotut.ui.login.LoginActivity;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.sign_up);
        configureNavigation();
    }

    private void configureNavigation() {
        final EditText fName = (EditText) findViewById(R.id.firstName);
        final EditText lName = (EditText) findViewById(R.id.lastName);
        final EditText email = (EditText) findViewById(R.id.emailInput);
        final EditText passW = (EditText) findViewById(R.id.passwordInput);
        final EditText rePass = (EditText) findViewById(R.id.confirmNewPassword);
        mAuth = FirebaseAuth.getInstance();


        Button signInButton = (Button) findViewById(R.id.signIn);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });

        Button createAccountButton = (Button) findViewById(R.id.createAccount);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passW.getText().toString().equals(rePass.getText().toString()) &&
                !fName.getText().toString().equals("") &&
                !lName.getText().toString().equals("") &&
                !email.getText().toString().equals("") &&
                !passW.getText().toString().equals("")) {
                    Intent intent = new Intent(SignUpActivity.this, NewAccountActivity.class);
                    intent.putExtra("fName", fName.getText().toString());
                    intent.putExtra("lName", lName.getText().toString());
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("pass", passW.getText().toString());
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(),passW.getText().toString());
                    mAuth.signInWithEmailAndPassword(email.getText().toString(),passW.getText().toString());
                    startActivity(intent);
                }else if(fName.getText().toString().equals("") ||
                        lName.getText().toString().equals("") ||
                        email.getText().toString().equals("") ||
                        passW.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this, "Error: all fields must be filled",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignUpActivity.this, "Error: passwords do not match",Toast.LENGTH_SHORT).show();
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
