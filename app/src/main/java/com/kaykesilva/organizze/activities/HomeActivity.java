package com.kaykesilva.organizze.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.kaykesilva.organizze.Factories.AuthFactory;
import com.kaykesilva.organizze.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button bt = findViewById(R.id.buttonExit);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthFactory.getInstance().signOut();
                finish();
            }
        });
    }

    public void addExpensive(View view){
        startActivity(new Intent(this, ExpensiveActivity.class));

    }

    public void addIncome(View view){
        startActivity(new Intent(this, IncomeActivity.class));

    }

}