package com.example.dentistapp.utils;

import android.content.Context;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Auth utils used across the app
 */
public class AuthUtils {

    /**
     * Checks if user is authenticated
     * @return true if authenticated, false otherwise
     */
    public static boolean isAuthenticated() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        return user != null;
    }

    /**
     * Returns the current authenticated user
     * @return Authenticated User
     */
    public static FirebaseUser getUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    /**
     * Executes logout for the current user
     * @param context Activity/Fragment context.
     * @param logoutListener Listener to be called when logout process finishes.
     */
    public static void logout(Context context, OnCompleteListener<Void> logoutListener) {
        AuthUI.getInstance()
                .signOut(context)
                .addOnCompleteListener(logoutListener);
    }
}

