package com.example.taitran.buzzmovie.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Frag3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frag3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag3 extends Fragment {

    public Frag3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag3,container,false);
        return view;
    }

}
