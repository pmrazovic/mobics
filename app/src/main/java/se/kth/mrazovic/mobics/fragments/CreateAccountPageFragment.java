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
import se.kth.mrazovic.mobics.activities.WelcomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAccountPageFragment extends Fragment {
    private SessionManager mSessionManager;
    private TextView mEmailTextView;
    private TextView mPasswordTextView;
    private TextView mPasswordConfirmTextView;
    private TextView mUsernameTextView;


    public CreateAccountPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mSessionManager = new SessionManager(getActivity());

        // Inflate the layout for this fragment
        View inputView = inflater.inflate(R.layout.fragment_create_account_page, container, false);

        // Find email, username and password text views
        mEmailTextView = (TextView) inputView.findViewById(R.id.email);
        mUsernameTextView = (TextView) inputView.findViewById(R.id.username);
        mPasswordTextView = (TextView) inputView.findViewById(R.id.password);
        mPasswordConfirmTextView = (TextView) inputView.findViewById(R.id.password_confirm);

        // Set onClick listener on Create Account button
        Button createAccountBtn = (Button) inputView.findViewById(R.id.btn_create_account);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

        return inputView;
    }

    public void createAccount(){
        if (((WelcomeActivity) getActivity()).isNetworkAvailable()) {
            // Network connection available
            String email = mEmailTextView.getText().toString();
            String username = mUsernameTextView.getText().toString();
            String password = mPasswordTextView.getText().toString();
            String passwordConfirm = mPasswordConfirmTextView.getText().toString();
            if (email.trim().length() > 0 && username.trim().length() > 0 && password.trim().length() > 0) {
                if (password.equals(passwordConfirm)) {
                    // TODO: replace with real information from server
                    mSessionManager.createLoginSession("test", "test@test.com");
                } else {
                    AlertDialog.Builder alertDialogBuilder =
                            new AlertDialog.Builder(getActivity())
                                    .setTitle(R.string.signup_failed)
                                    .setMessage(R.string.passwords_dont_match)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                        }
                                    });
                    alertDialogBuilder.show();
                }
            } else {
                AlertDialog.Builder alertDialogBuilder =
                        new AlertDialog.Builder(getActivity())
                                .setTitle(R.string.signup_failed)
                                .setMessage(R.string.fill_all_signup_details)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                    }
                                });
                alertDialogBuilder.show();
            }
        } else {
            // Network connection disabled
            AlertDialog.Builder alertDialogBuilder =
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Connection problem")
                            .setMessage("Please make sure you have access to Internet.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
            alertDialogBuilder.show();
        }
    }


}
