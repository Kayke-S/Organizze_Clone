package com.kaykesilva.organizze;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

public class MainActivity extends IntroActivity {

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .fragment(R.layout.intro_1)
                .background(R.color.white)
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
                .build());

    }
}