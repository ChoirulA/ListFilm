package com.choirul.listfilm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.choirul.listfilm.database.Database;
import com.choirul.listfilm.database.Sessions;
import com.choirul.listfilm.models.Users;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Sessions sessions;
    public List<Users> users;
    public EditText text_username, text_password;
    public Button button_login;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessions = new Sessions(this);
        if(sessions.getHasLogin()){
            startActivity(new Intent(MainActivity.this, Home.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        users = new ArrayList<>();
        users.add(new Users("cho", "choicho"));

        text_username = findViewById(R.id.text_username);
        text_password = findViewById(R.id.text_password);
        button_login = findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users userslogin = null;
                for (Users user : users) {
                    if (user.getUsername().equals(text_username.getText().toString()) &&
                            user.getPassword().equals(text_password.getText().toString())) {
                        userslogin = user;
                    }
                }

                if (userslogin != null) {
                    SharedPreferences spPengguna = MainActivity.this.getSharedPreferences("Userlogin",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = spPengguna.edit();
                    edit.putString("sedangLogin", userslogin.getUsername());
                    edit.apply();

                    sessions.saveBoolean(sessions.SP_Has_Login, true);
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Usernam atau Password Salah",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        db = new Database(this);
    }
}
