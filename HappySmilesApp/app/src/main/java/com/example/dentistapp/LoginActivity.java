package com.example.dentistapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final androidx.appcompat.app.AppCompatDelegate AppCompatDelegate = null;

    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        Button loginBtn = (Button) findViewById(R.id.login_button);
        EditText emailInput = (EditText) findViewById(R.id.edittext_email);
        EditText passwordInput = (EditText) findViewById(R.id.edittext_password);

        loginBtn.setOnClickListener(v -> mAuth.signInWithEmailAndPassword(emailInput.getText().toString(), passwordInput.getText().toString())
                .addOnCompleteListener(LoginActivity.this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        openNewActivity();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}