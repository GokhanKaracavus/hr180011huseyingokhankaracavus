package com.hr180011_huseyin_gokhan_karacavus_final_proje.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.hr180011_huseyin_gokhan_karacavus_final_proje.R;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.activity.ListeActivity;
import com.hr180011_huseyin_gokhan_karacavus_final_proje.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();

    }

    private void init() {
        internetControl();
    }

    private void openNextActivity() {
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {


            }

            @Override
            public void onFinish() {
                Intent secondActivityIntent = new Intent(getApplicationContext(), ListeActivity.class);
                startActivity(secondActivityIntent);
                finish();
            }
        }.start();
    }

    private void internetControl() {
        if (NetworkUtil.internetControl(getApplicationContext())) {
            openNextActivity();
        } else {
            internetAlert();
        }
    }

    private void internetAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.kontrol).setPositiveButton(getResources().getString(R.string.Evet), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));

            }
        });
        builder.setNegativeButton(getResources().getString(R.string.Hayır), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        final AlertDialog alert = builder.create();
        alert.show();

    }
}