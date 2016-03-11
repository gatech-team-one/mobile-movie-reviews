package com.example.taitran.buzzmovie.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.taitran.buzzmovie.controller.R;

public class MenuDialog extends DialogFragment implements AdapterView.OnItemSelectedListener{
    private static Spinner sortspinner;
    private static CheckBox moviesSearchBox;
    private static CheckBox seriesSearchBox;
    private static CheckBox episodeSearchBox;


    private static boolean movieSearch;
    private static boolean seriesSearch;
    private static boolean episodeSearch;
    private static boolean sortByRating;
    private static boolean sortByMajor;
    private static boolean sortByNewReleases;

    private static final String[] sortByList = new String[]{"New Releases", "Rating", "Major Rating"};


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        movieSearch = true;
        seriesSearch = true;
        episodeSearch = true;
        sortByMajor = false;
        sortByRating = false;
        sortByNewReleases = false;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.search_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        sortspinner = (Spinner) v.findViewById(R.id.sortspinner);
        moviesSearchBox = ((CheckBox) v.findViewById(R.id.moviesCheckBox));
        episodeSearchBox = ((CheckBox) v.findViewById(R.id.episodeCheckBox));
        seriesSearchBox = ((CheckBox) v.findViewById(R.id.seriesCheckBox));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, sortByList);
        sortspinner.setAdapter(adapter);
        sortspinner.setOnItemSelectedListener(this);

        builder.setView(v).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                movieSearch = moviesSearchBox.isChecked();
                episodeSearch = episodeSearchBox.isChecked();
                seriesSearch = seriesSearchBox.isChecked();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });
        return builder.create();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        String sortBy = ((TextView) v).getText().toString();
        if (sortBy.equals(sortByList[0])) {
            sortByNewReleases = true;
        } else if (sortBy.equals(sortByList[1])) {
            sortByRating = true;
        } else {
            sortByMajor = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}