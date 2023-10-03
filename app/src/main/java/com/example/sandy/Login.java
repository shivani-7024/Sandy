package com.example.sandy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText gmail, password;
    Button login;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gmail = findViewById(R.id.edtemail);
        password = findViewById(R.id.edtpassword);
        login = findViewById(R.id.loginsubmitbtn);

        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gmail1 = gmail.getText().toString();
                String password1 = password.getText().toString();

                if(TextUtils.isEmpty(gmail1) || TextUtils.isEmpty(password1)){
                    Toast.makeText(Login.this, "Please Enter both Gmail and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    logn(gmail1, password1);
                }
            }
        });
    }
    private void logn(String gmail1, String password1) {
        auth.signInWithEmailAndPassword(gmail1, password1).addOnSuccessListener(Login.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(Login.this, "Login successfully ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}