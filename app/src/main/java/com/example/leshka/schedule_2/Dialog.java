package com.example.leshka.schedule_2;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

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
        inputBundle = getArguments();
        if (inputBundle.getString("1") != null) {
           dialog_text.setText(getPref(inputBundle.getString("1")));
        }
        return v;
    }

    public String getPref(String str) {
        SharedPreferences sPref;
        sPref = getActivity().getSharedPreferences("Gym_file", MODE_PRIVATE);
        if (sPref.contains(str)) {
            return sPref.getString(str, "");
        }
        else {
            SharedPreferences.Editor e = sPref.edit();
            e.putString(str, "66");
            e.apply();
        }
        return sPref.getString(str, "");
    }

    public void setPref(String tag,String value) {
        SharedPreferences sPref;
        sPref = getActivity().getSharedPreferences("Gym_file", MODE_PRIVATE);
        SharedPreferences.Editor e = sPref.edit();
        Log.d("1",value);
        e.putString(tag, value);
        e.apply();
    }

    public void onClick(View v) {
        int mass = Integer.valueOf(dialog_text.getText().toString());
        int mass2= mass;
        switch (v.getId()){
            case R.id.reduce:
                if(mass>0){
                    mass--;
                    //setPref(inputBundle.getString("1"), String.valueOf(mass));
                    dialog_text.setText(String.valueOf(mass));
                }
                break;
            case R.id.add_num:
                mass++;
                //setPref(inputBundle.getString("1"), String.valueOf(mass));
                dialog_text.setText(String.valueOf(mass));
                break;
            case R.id.btnYes:
                Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());
                setPref(inputBundle.getString("1"), String.valueOf(mass2));
                dismiss();
                break;
            case R.id.btnNo:
                Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());
                dismiss();
                break;

        }
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