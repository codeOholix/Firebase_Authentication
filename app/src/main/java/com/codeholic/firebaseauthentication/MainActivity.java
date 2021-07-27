package com.codeholic.firebaseauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity{

    EditText mobileNumber;
    Button sendOTP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNumber = findViewById(R.id.number);
        sendOTP = findViewById(R.id.sentOTP);

        sendOTP.setOnClickListener(view -> registerUser());

    }
    //This function will execute when user click on Register Button
    public void registerUser() {

        /* Performing Validation by calling validation functions
        if (!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()) {
            return;
        }*/

        //Get the Phone No from phone no field in String
        String phoneNo = mobileNumber.getText().toString().trim();

        //Call the next activity and pass phone no with it
        Intent intent = new Intent(MainActivity.this, PhoneAuthActivity.class);
        intent.putExtra("phoneNo", phoneNo);
        startActivity(intent);

    }
}