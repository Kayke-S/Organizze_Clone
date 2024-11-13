package com.kaykesilva.organizze.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.kaykesilva.organizze.R;
import com.kaykesilva.organizze.entities.User;
import com.kaykesilva.organizze.services.UserService;

public class RegisterActivity extends AppCompatActivity {

    EditText editName;
    EditText editEmail;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

    }

    public void registerButton(View view)  {
        boolean check = checkFields();
            if(check){
                User user = new User(editEmail.getText().toString(), editPassword.getText().toString());
                String name = editName.getText().toString(); // database
                UserService.register(RegisterActivity.this, user.getEmail(), user.getPassword());
               cleanRegisterFields();
            }
}
    private boolean checkFields() {
        if(TextUtils.isEmpty(editName.getText())){
            Toast.makeText(this, "Type the name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(editEmail.getText().toString())){
            Toast.makeText(this, "Type the email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(editPassword.getText().toString())){
            Toast.makeText(this, "Type the password", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validação do formato de e-mail
        if (!isValidEmail(editEmail.getText().toString())) {
            Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validação do formato de senha
        if (!isValidPassword(editPassword.getText().toString())) {
            Toast.makeText(this, "Password must have at least 8 characters, including letters and numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // Método para validar o e-mail usando regex
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    // Método para validar a senha
    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return password.matches(passwordPattern);
    }

    private void cleanRegisterFields() {
        editName.setText("");
        editEmail.setText("");
        editPassword.setText("");
    }
}