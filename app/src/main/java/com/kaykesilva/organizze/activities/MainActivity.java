package com.kaykesilva.organizze.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.kaykesilva.organizze.Factories.AuthFactory;
import com.kaykesilva.organizze.R;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_1)
                .background(R.color.white)
                .canGoBackward(false)
                .build());

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_2)
                .background(R.color.white)
                .build());

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_3)
                .background(R.color.white)
                .build());

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_4)
                .background(R.color.white)
                .canGoBackward(false)
                .build());

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_cadastro)
                .background(R.color.white)
                .canGoBackward(false)
                .canGoForward(false)
                .build());
    }

    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void register(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkAuthenticatedUser();

    }

    public void checkAuthenticatedUser(){

        FirebaseAuth auth = AuthFactory.getInstance();
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }

    }

}