package com.kdotj.demo.kotlinmutlichoicedialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.Locale;

public class MainActivityTwo extends AppCompatActivity {

    private AppCompatTextView textViewSelection;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSelection = findViewById(R.id.textViewSelection);

        AppCompatButton btnSingleChoiceDialog = findViewById(R.id.btnCustomDialog);
        btnSingleChoiceDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog =
                        DialogUtil.createSingleChoiceDialog(MainActivityTwo.this,
                                getString(R.string.dogs_title), 0,
                                getResources().getStringArray(R.array.custom_options),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String[] options = getResources().getStringArray(R.array.custom_options);
                                        textViewSelection.setText(String.format(Locale.getDefault(), getString(R.string.dogs_selection_text), options[i]));
                                    }
                                });

                alertDialog.show();
            }
        });

        // or without the wrapper
        btnSingleChoiceDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityTwo.this, R.style.AppTheme_Dialog);
                builder.setTitle(getString(R.string.dogs_title))
                builder.setSingleChoiceItems(getResources().getStringArray(R.array.custom_options), 0,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String[] options = getResources().getStringArray(R.array.custom_options);
                                textViewSelection.setText(String.format(Locale.getDefault(), getString(R.string.dogs_selection_text), options[i]));
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}
