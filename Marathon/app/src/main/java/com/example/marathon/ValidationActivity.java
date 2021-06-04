package com.example.marathon;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ValidationActivity extends AppCompatActivity {


    TextView nom;
    TextView prenom;
    TextView email;
    TextView tel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);


        nom =  findViewById(R.id.affNom);
        prenom =  findViewById(R.id.affPrenom);
        email =  findViewById(R.id.affMail);
        tel =  findViewById(R.id.affPhone);

        String fname= getIntent().getStringExtra("firstname");
        String lname= getIntent().getStringExtra("lastname");
        String ml= getIntent().getStringExtra("mail");
        String phn= getIntent().getStringExtra("phone");

        nom.setText(lname);
        prenom.setText(fname);
        email.setText(ml);
        tel.setText(phn);



    }
}