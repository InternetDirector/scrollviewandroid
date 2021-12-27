package com.example.firstproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton witcherBtn = findViewById(R.id.witcherBtn);
        ImageButton flutterBtn = findViewById(R.id.flutterBtn);
        ImageButton screenShotBtn = findViewById(R.id.screenShotBtn);
        Button closeBtn=findViewById(R.id.closeApp);
        Button manyButtonsAlert=findViewById(R.id.manyButtonsAlert);
        witcherBtn.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Нажата кнопка скрина ведьмака", Toast.LENGTH_SHORT).show());
        flutterBtn.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Нажато изображение флаттера", Toast.LENGTH_SHORT).show());
        screenShotBtn.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Нажата кнопка скрина скриншота", Toast.LENGTH_SHORT).show());
        closeBtn.setOnClickListener(this::onCloseButtonClick);
        manyButtonsAlert.setOnClickListener(this::manyButtonsAlert);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public void manyButtonsAlert(View view){
        String[] ingredients={"Томаты","Шампиньоны","Курица"};
        final  boolean[] selectedIngredients={false,false,false};

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выберите ингредиенты")
                .setMultiChoiceItems(ingredients, null, (dialog, which, isChecked) -> selectedIngredients[which]=isChecked)
                .setPositiveButton("OK", (dialog, which) -> {
                    Toast.makeText(getApplicationContext(), "Нажата ОК", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                });
        AlertDialog alert=builder.create();
        alert.show();
    }

    public void onCloseButtonClick(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выход из приложения")
                .setMessage("Вы уверенны что хотите выйти из приложения?")
                .setPositiveButton("OK", (dialog, which) -> {
                    Toast.makeText(getApplicationContext(), "Нажата ОК", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .setNegativeButton("Отмена", (dialog, which) -> {
                    Toast.makeText(getApplicationContext(), "Нажата отмена", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                });
        AlertDialog alert=builder.create();
        alert.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView infoTextView = findViewById(R.id.infoTextView);
        switch (id) {
            case (R.id.action_cat1):
                infoTextView.setText("Вы выбрали кота!");
                return true;
            case (R.id.action_cat2):
                infoTextView.setText("Вы выбрали кошку!");
                return true;
            case (R.id.action_cat3):
                infoTextView.setText("Вы выбрали котёнка!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}