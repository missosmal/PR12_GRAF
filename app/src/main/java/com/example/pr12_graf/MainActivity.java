package com.example.pr12_graf;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void AlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title).setMessage(message).setCancelable(false).setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    EditText FIO;
    EditText Phone;
    EditText adres;

    public void OnArange(View view){
        FIO = findViewById(R.id.FIO);
        Phone = findViewById(R.id.Phone);
        adres = findViewById(R.id.adres);

        if(FIO.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите Фамилию, Имя и Отчество!");
        else if(Phone.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите номер телефона!");
        else if(adres.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите адрес доставки!");
        else
        {
            AlertDialog("Уведомление", "Заказ оформлен.");
        }
    }
}