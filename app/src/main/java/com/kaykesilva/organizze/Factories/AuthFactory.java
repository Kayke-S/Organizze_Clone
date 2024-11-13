package com.kaykesilva.organizze.Factories;

import com.google.firebase.auth.FirebaseAuth;

public class AuthFactory {

    private static FirebaseAuth instance;

    private AuthFactory(){

    }

    public static FirebaseAuth getInstance(){
        if(instance == null){
            instance = FirebaseAuth.getInstance();
        }
        return instance;
    }

}
