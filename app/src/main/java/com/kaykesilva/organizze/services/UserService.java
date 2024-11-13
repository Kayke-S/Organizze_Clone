package com.kaykesilva.organizze.services;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserService {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private Context context;

    private UserService(){
        // evitar instâncias indesejadas
    }
    public UserService(Context context){
        this.context = context;
    }

    public void register(String email, String password){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(context, "Sucesso ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Sem sucesso ao cadatrar usuário", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
