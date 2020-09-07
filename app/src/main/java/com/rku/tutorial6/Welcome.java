package com.rku.tutorial6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        TextView textView=findViewById(R.id.txtWelcome);
        SharedPreferences SP = getSharedPreferences("Login_Info",MODE_PRIVATE);

        String Username = SP.getString("Username","");


        textView.setText("Welcome "+Username);

    }

    public void logout()
    {
        SharedPreferences SP=getSharedPreferences("Login_Info",MODE_PRIVATE);
        SharedPreferences.Editor editor = SP.edit();
        editor.remove("Username");
        editor.apply();

        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }



    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.custome_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {

            case R.id.menuLogout:
                logout();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}