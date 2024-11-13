package com.kaykesilva.organizze.services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.kaykesilva.organizze.Factories.AuthFactory;

public class UserService {

    private Context context;

    private UserService(){
        // evitar instâncias indesejadas
    }
    public UserService(Context context){
        this.context = context;
    }

    public void register(String email, String password){
        AuthFactory.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(context, "Sucesso ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        throw task.getException();
                    }
                    catch (Exception e ){
                        Log.i("ExceptionAuth ", e.getMessage());
                        e.printStackTrace();
                    }
                        Toast.makeText(context, "Erro ao cadatrar usuário", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
