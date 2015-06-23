package se.kth.mrazovic.mobics;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import java.util.HashMap;

import se.kth.mrazovic.mobics.activities.MainActivity;
import se.kth.mrazovic.mobics.activities.WelcomeActivity;

/**
 * Created by Petar Mrazovic on 21.06.15..
 */
public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String PREF_FILE_KEY = "se.kth.mrazovic.mobics.MOBICS_USER_DETAILS";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_FILE_KEY, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String username, String email) {
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
        // TODO: Authentication token needs to be stored in shared preferences
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_USERNAME, sharedPreferences.getString(KEY_USERNAME, null));
        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));
        return user;
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, WelcomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        ((AppCompatActivity) context).finish();
    }

    public void checkLogin() {
        if ((sharedPreferences.getString(KEY_USERNAME, null) == null) &&
                (sharedPreferences.getString(KEY_EMAIL, null) == null)) {
            Intent intent = new Intent(context, WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            ((AppCompatActivity) context).finish();
        }
    }
}
