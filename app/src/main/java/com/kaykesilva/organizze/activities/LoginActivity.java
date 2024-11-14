package com.kaykesilva.organizze.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kaykesilva.organizze.R;
import com.kaykesilva.organizze.entities.User;
import com.kaykesilva.organizze.services.UserService;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPassword;

    private Button btAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btAccount = findViewById(R.id.btAccount);

        btAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = checkFields();
                if(check){
                   User user = new User(editEmail.getText().toString(), editPassword.getText().toString());

                   UserService userService = new UserService(LoginActivity.this);
                   userService.login(user.getEmail(), user.getPassword());

                }
            }
        });

    }
    private boolean checkFields() {

        if (!isValidEmail(editEmail.getText().toString())) {
            Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(editPassword.getText().toString())){
            Toast.makeText(this, "Type the password", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
}