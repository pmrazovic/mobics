package se.kth.mrazovic.mobics.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import se.kth.mrazovic.mobics.R;
import se.kth.mrazovic.mobics.SessionManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginPageFragment extends Fragment {
    private TextView mEmailTextView;
    private TextView mPasswordTextView;
    private SessionManager mSessionManager;


    public LoginPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mSessionManager = new SessionManager(getActivity());

        // Inflate the layout for this fragment
        View inputView = inflater.inflate(R.layout.fragment_login_page, container, false);

        // Find email and password text views
        mEmailTextView = (TextView) inputView.findViewById(R.id.email);
        mPasswordTextView = (TextView) inputView.findViewById(R.id.password);

        // Set onClick listener on Sign In button
        Button signInBtn = (Button) inputView.findViewById(R.id.btn_sign_in);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser();
            }
        });

        return inputView;
    }

    public void signInUser(){
        String email = mEmailTextView.getText().toString();
        String password = mPasswordTextView.getText().toString();
        if (email.trim().length() > 0 && password.trim().length() > 0){
            if (email.equals("test") && password.equals("test")) {
                // TODO: replace with real information from server
                mSessionManager.createLoginSession("test", "test@test.com");
            } else {
                AlertDialog.Builder alertDialogBuilder =
                        new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.login_failed)
                        .setMessage(R.string.incorrect_combination)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {}});
                alertDialogBuilder.show();
            }
        } else {
            AlertDialog.Builder alertDialogBuilder =
                    new AlertDialog.Builder(getActivity())
                            .setTitle(R.string.login_failed)
                            .setMessage(R.string.enter_cridentials)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {}});
            alertDialogBuilder.show();
        }
    }


}
