package com.kaykesilva.organizze.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
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
                .canGoBackward(false) // não é possível voltar
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
                .canGoBackward(false) // não é possível voltar
                .build());

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_cadastro)
                .background(R.color.white)
                .canGoBackward(false) // não é possível voltar
                .canGoForward(false) // não é possível avançar
                .build());
    }

    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void register(View view){
        startActivity(new Intent(this, RegisterActivity.class));
    }

}