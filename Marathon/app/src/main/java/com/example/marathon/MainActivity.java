package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_valid;
    EditText nom;
    EditText prenom;
    EditText email;
    EditText tel;
    EditText passwd;
    EditText passwd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_valid = (Button) findViewById(R.id.btn_valid);
        nom =  findViewById(R.id.nom);
        prenom =  findViewById(R.id.prenom);
        email =  findViewById(R.id.email);
        tel =  findViewById(R.id.tel);
        passwd =  findViewById(R.id.passwd);
        passwd2 =  findViewById(R.id.passwd2);

        btn_valid.setOnClickListener(this);





    }



    @Override
    public void onClick(View v) {
        boolean lastname = nom.getText().toString().length() > 0;
        boolean firstname = prenom.getText().toString().length() > 0;
        boolean mail = email.getText().toString().length() > 0;
        boolean phone = tel.getText().toString().length() > 0;
        boolean password = passwd.getText().toString().length() > 0;
        boolean password2 = passwd2.getText().toString().length() > 0;
        String Expn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
        String getM=email.getText().toString();






        if(lastname && firstname && mail && phone && password && password2  ) {
            if (!getM.matches(Expn)) {
                Toast.makeText(getApplicationContext(), "Le format de l'email est incorrect", Toast.LENGTH_SHORT).show();
            } else {
                String lastnameText = nom.getText().toString();
                String firstnameText = prenom.getText().toString();
                String mailText = email.getText().toString();
                String phoneText = tel.getText().toString();
                //Toast.makeText(getApplicationContext(), "Inscription validée", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ValidationActivity.class);
                intent.putExtra("firstname", firstnameText);
                intent.putExtra("lastname", lastnameText);
                intent.putExtra("mail", mailText);
                intent.putExtra("phone", phoneText);
                startActivity(intent);
            }
        }
        else
        Toast.makeText(getApplicationContext(), "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show();

    }
}