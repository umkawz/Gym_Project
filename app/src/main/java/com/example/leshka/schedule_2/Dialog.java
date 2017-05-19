package com.example.leshka.schedule_2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Dialog extends DialogFragment implements View.OnClickListener {

    final String LOG_TAG = "myLogs";
    private TextView dialog_text;
    Bundle inputBundle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Редактор веса");
        View v = inflater.inflate(R.layout.activity_dialog, null);
        v.findViewById(R.id.btnYes).setOnClickListener(this);
        v.findViewById(R.id.btnNo).setOnClickListener(this);
        v.findViewById(R.id.reduce).setOnClickListener(this);
        v.findViewById(R.id.add_num).setOnClickListener(this);
        dialog_text = (TextView) v.findViewById(R.id.dialog_text);
        if (inputBundle.getString("1") != null) {
           dialog_text.setText(inputBundle.getString("1"));
        } else {
            Log.d(LOG_TAG, "Const");
            dialog_text.setText("50");
        }
        Log.d("Start View", "123");
        return v;
    }

    public void onClick(View v) {
        int mass;
        switch (v.getId()){
            case R.id.reduce:
                mass = Integer.valueOf(dialog_text.getText().toString());
                mass--;
                dialog_text.setText(String.valueOf(mass));
                break;
            case R.id.add_num:
                mass = Integer.valueOf(dialog_text.getText().toString());
                mass++;
                dialog_text.setText(String.valueOf(mass));
                break;
            case R.id.btnYes:
                Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());
                dismiss();
            case R.id.btnNo:
                Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());
                dismiss();

        }
    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        inputBundle = getArguments();
        //dialog_text.setText(inputBundle.getString("1"));
        //Log.d("2323", inputBundle.getString("1"));
        Log.d("Start Create", "123");
        return super.onCreateDialog(savedInstanceState);
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
}