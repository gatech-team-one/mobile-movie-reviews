package com.example.taitran.buzzmovie.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import com.example.taitran.buzzmovie.model.UserManagement;
import com.example.taitran.buzzmovie.model.UserManager;


public class EditProfileActivity extends Fragment implements AdapterView.OnItemSelectedListener, OnClickListener{
    /**
     * The user manager.
     */
    private UserManagement userMan;

    /**
     * The text view for the email.
     */
    private TextView emailTextView;
    /**
     * To edit the text.
     */
    private EditText emailEditText;

    /**
     * Boolean for editing the email.
     */
    private boolean editingEmail = false;
    /**
     * The text view for the major.
     */
    private TextView majorTextView;
    /**
     * The spinner.
     */
    private Spinner spinner;
    /**
     * Boolean for editing the major.
     */
    private boolean editingMajor = false;

    private TextView bioTextView;
    /**
     * Edit the bio.
     */
    private EditText bioEditText;
    /**
     * Boolean to edit the bio.
     */
    private boolean editingBio = false;

    /**
     * Empty constructor.
     */
    public EditProfileActivity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_edit_profile, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userMan = new UserManager(getActivity());
        TextView usernameTextView = (TextView) getActivity().findViewById(R.id.displayUsernameText);
        usernameTextView.setText(userMan.getActiveUser().getUsername());

        emailTextView = (TextView) getActivity().findViewById(R.id.displayEmailText);
        emailTextView.setText(userMan.getActiveUser().getEmail());

        emailEditText = (EditText) getActivity().findViewById(R.id.editEmailText);
        emailEditText.setText(userMan.getActiveUser().getEmail());

        Button editEmailButton = (Button) getActivity().findViewById(R.id.editEmailBtn);
        editEmailButton.setText(R.string.edit);
        editEmailButton.setOnClickListener(this);

        majorTextView = (TextView) getActivity().findViewById(R.id.displayMajor);
        String major = ("Major: " + userMan.getActiveUser().getMajor());
        majorTextView.setText(major);

        Button editPassButton = (Button) getActivity().findViewById(R.id.editPassBtn);
        editPassButton.setOnClickListener(this);

        Button editMajorButton = (Button) getActivity().findViewById(R.id.editMajorBtn);
        editMajorButton.setText(R.string.edit);
        editMajorButton.setOnClickListener(this);

        Button editBioButton = (Button) getActivity().findViewById(R.id.editBioBtn);
        editBioButton.setText(R.string.edit);
        editBioButton.setOnClickListener(this);

        spinner = (Spinner) getActivity().findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, userMan.getMajors());
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        bioTextView = (TextView) getActivity().findViewById(R.id.displayBioText);
        bioTextView.setText(userMan.getActiveUser().getBio());

        bioEditText = (EditText) getActivity().findViewById(R.id.editBioText);
        bioEditText.setText(userMan.getActiveUser().getBio());

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        userMan.updateMajor(((TextView)v).getText().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    /**
     * edit and change the bio for the user in database
     * @param v reference to the bio button
     */


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editEmailBtn:
                Button b = (Button) v;
                if (!editingEmail) {
                    b.setText(R.string.set);
                    editingEmail = true;

                    emailEditText.setText(emailTextView.getText().toString());
                    emailTextView.setVisibility(View.INVISIBLE);
                    emailEditText.setVisibility(View.VISIBLE);
                    emailEditText.requestFocus();


                } else {
                    CharSequence text = "Email Changed";

                    try {
                        userMan.updateEmail(emailEditText.getText().toString());
                    } catch (IllegalArgumentException e) {
                        text = e.getMessage();
                    }

                    Context context = getActivity().getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast message = Toast.makeText(context, text, duration);
                    message.show();

                    emailTextView.setText(userMan.getActiveUser().getEmail());
                    emailEditText.setVisibility(View.INVISIBLE);
                    emailTextView.setVisibility(View.VISIBLE);
                    b.setText(R.string.edit);
                    editingEmail = false;
                }
                break;
            case R.id.editPassBtn:
                Log.d("Edit Profile Activity", "edit password button pressed");
                Intent intent = new Intent(getActivity(), EditPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.editMajorBtn:
                Button mButton = (Button) v;
                if (!editingMajor) {
                    majorTextView.setText(R.string.major);
                    spinner.setVisibility(View.VISIBLE);
                    mButton.setText(R.string.set);
                    editingMajor = true;
                } else {
                    String major = "Major: " + userMan.getActiveUser().getMajor();
                    majorTextView.setText(major);
                    spinner.setVisibility(View.GONE);
                    mButton.setText(R.string.edit);
                    editingMajor = false;
                    Context context = getActivity().getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast message = Toast.makeText(context, "Major Changed", duration);
                    message.show();
                }
                break;
            case R.id.editBioBtn:
                Button c = (Button) v;
                if (!editingBio) {
                    c.setText(R.string.set);
                    editingBio = true;
                    bioTextView.setVisibility(View.INVISIBLE);
                    bioEditText.setVisibility(View.VISIBLE);
                    bioEditText.requestFocus();
                } else {
                    CharSequence text = "Bio Changed";
                    try {
                        userMan.updateBio(bioEditText.getText().toString());
                    } catch (IllegalArgumentException e) {
                        text = e.getMessage();
                    }
                    Context context = getActivity().getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast message = Toast.makeText(context, text, duration);
                    message.show();

                    bioTextView.setText(userMan.getActiveUser().getBio());
                    bioEditText.setVisibility(View.INVISIBLE);
                    bioTextView.setVisibility(View.VISIBLE);
                    c.setText(R.string.edit);
                    editingBio = false;
                }
                break;
        }
    }
}
