package com.rku.tutorial6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setTitle("Login");

        SharedPreferences SP= getSharedPreferences("Login_Info",MODE_PRIVATE);
        String User=SP.getString("Username","");

        if(!User.equals(""))
        {
            Intent intent=new Intent(this,Welcome.class);
            startActivity(intent);
            finish();
        }


        setContentView(R.layout.login);
    }


    public void login(View v)
    {
        EditText Edittxtuser=findViewById(R.id.edtUsername);
        EditText Edittxtpass=findViewById(R.id.edtPassword);
        String Username=Edittxtuser.getText().toString();
        String Password=Edittxtpass.getText().toString();
        if(!Username.isEmpty() && !Password.isEmpty())
        {
            if(Patterns.EMAIL_ADDRESS.matcher(Username).matches())
            {
                SharedPreferences SP=getSharedPreferences("Login_Info",MODE_PRIVATE);
                SharedPreferences.Editor editor=SP.edit();
                editor.putString("Username",Username);
                editor.apply();
                Intent intent=new Intent(Login.this,Welcome.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(this, "Please Enter Valid Username!...", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Edittxtpass.requestFocus();
            Edittxtpass.setError("Please Enter Password");
            Edittxtuser.requestFocus();
            Edittxtuser.setError("Please Enter Username");
        }
    }

}