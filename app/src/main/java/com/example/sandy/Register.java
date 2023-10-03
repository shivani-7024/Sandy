package com.example.sandy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

public class Register extends AppCompatActivity {
    Button login_btn;
    EditText name, mail, password;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);

        auth = FirebaseAuth.getInstance();

        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String name1 = name.getText().toString();
                String mail1 = mail.getText().toString();
                String password1 = password.getText().toString();

                if(TextUtils.isEmpty(mail1) || TextUtils.isEmpty(password1) || TextUtils.isEmpty(name1)){
                    Toast.makeText(Register.this, "Please enter name, mail and password ", Toast.LENGTH_SHORT).show();
                }
                else{

                    regis(mail1, password1);

                }
            }
        });
    }
    private void regis(String gmail, String pass) {
        auth.createUserWithEmailAndPassword(gmail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.e("RegistrationError", "Registration failed: " + task.getException().getMessage());
                    Toast.makeText(Register.this, "Failed", Toast.LENGTH_SHORT).show();
                }
        }
});

    }

}