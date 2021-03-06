package com.example.newlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private TextInputEditText mEmail, mPassword;
    private Button mSignIn;
    TextView mSignup, forp;
    private ProgressBar progressbar;
    public static final String TAG = "CRM";
    private FirebaseUser user;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSignIn = findViewById(R.id.signin);
        mSignup =  findViewById(R.id.signup);
        mEmail = findViewById(R.id.email);
        mPassword =  findViewById(R.id.password);
        forp = findViewById(R.id.forgotpswd);
        pbar = findViewById(R.id.p_Bar);

        mAuth = FirebaseAuth.getInstance();


        forp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        pbar.setVisibility(View.VISIBLE);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();{
                    if(email.equals("")){
                        Toast.makeText(LoginActivity.this, "Enter Email address!!",
                                Toast.LENGTH_SHORT).show();
                    }
                    if(password.equals("")){
                        Toast.makeText(LoginActivity.this, "Enter Password!!",
                                Toast.LENGTH_SHORT).show();
                    }


                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent( getApplicationContext() ,DashboardActivity.class));
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(LoginActivity.this, "Login successfull.",
                                            Toast.LENGTH_SHORT).show();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(LoginActivity.this, "Your email is not verified.",
                                            Toast.LENGTH_SHORT).show();

                                    pbar.setVisibility(View.GONE);
                                }

                            }


                        });

                    }
                }

            });

        Sprite chasingDots = new ChasingDots();
        pbar.setIndeterminateDrawable(chasingDots);

    }
}