package com.kdotj.demo.kotlinmutlichoicedialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class MainActivityTwo  extends AppCompatActivity {

    private AppCompatTextView textViewSelection;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
                                        String [] options = getResources().getStringArray(R.array.custom_options);
                                        Toast.makeText(MainActivityTwo.this, String.format(Locale.getDefault(), getString(R.string.dogs_selection_text), options[i]), Toast.LENGTH_LONG).show();
                                    }
                                });

                alertDialog.show();
            }
        });
    }
}
