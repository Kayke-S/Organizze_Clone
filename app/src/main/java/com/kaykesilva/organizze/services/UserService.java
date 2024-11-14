package com.kaykesilva.organizze.services;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.kaykesilva.organizze.Factories.AuthFactory;
import com.kaykesilva.organizze.activities.HomeActivity;
import com.kaykesilva.organizze.activities.LoginActivity;
import com.kaykesilva.organizze.activities.RegisterActivity;

public class UserService {

    private Context context;

    private UserService(){

    }

    public UserService(Context context){
        this.context = context;
    }

   public void register(String email, String password){
        AuthFactory.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finishActivity();}

                else{
                    String exceptionMsg = "";
                    try{
                        throw task.getException();
                    }
                    catch (FirebaseAuthUserCollisionException e ){
                        exceptionMsg = "This account has already been registered";
                    }
                    catch (Exception e ){
                        exceptionMsg = "Error registering user: " + e.getMessage();
                        e.printStackTrace();
                    }
                        Toast.makeText(context, exceptionMsg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void login(String email, String password){
        AuthFactory.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    finishActivity();
                    openHomeActivity();
                }
                else{
                    String exceptionMsg ="";
                    try{
                        throw task.getException();
                    }
                    catch (FirebaseAuthInvalidCredentialsException e){
                        exceptionMsg = "Email and password do not match registered users";
                    }
                    catch (Exception e){
                        exceptionMsg = "Error registering user: " + e.getMessage();
                    }

                    Toast.makeText(context, exceptionMsg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openHomeActivity(){
        context.startActivity(new Intent(context, HomeActivity.class));
    }

    public void finishActivity(){
        if(context instanceof LoginActivity){
            ((LoginActivity) context).finish();
        }
        else{
            ((RegisterActivity) context).finish();
        }
    }
}
