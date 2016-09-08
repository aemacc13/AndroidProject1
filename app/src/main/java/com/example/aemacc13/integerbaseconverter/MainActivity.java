package com.example.aemacc13.integerbaseconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BaseConversion converter= new BaseConversion();
    private int lightRed= Color.rgb(249, 145, 145);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText integer= (EditText)findViewById(R.id.integer);
        final EditText initialBase= (EditText)findViewById(R.id.initialBase);
        final EditText newBase= (EditText)findViewById(R.id.newBase);
        final Button enter= (Button)findViewById(R.id.enter);
        final TextView error= (TextView)findViewById(R.id.error);
        final TextView result= (TextView)findViewById(R.id.result);

        enter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String one= integer.getText().toString();
                String two= initialBase.getText().toString();
                String three= newBase.getText().toString();

                integer.setBackgroundColor(Color.TRANSPARENT);
                initialBase.setBackgroundColor(Color.TRANSPARENT);
                newBase.setBackgroundColor(Color.TRANSPARENT);

                try {
                    result.setText(converter.convert(one, two, three));
                    error.setText("");
                } catch (NumberFormatException exception) {
                    if (converter.check(one, two, three) == 1){
                        integer.setBackgroundColor(lightRed);
                        integer.setText("");
                        integer.requestFocus();
                    } else if (converter.check(one, two, three) == 2){
                        initialBase.setBackgroundColor(lightRed);
                        initialBase.setText("");
                        initialBase.requestFocus();
                    } else if (converter.check(one, two, three) == 3) {
                        newBase.setBackgroundColor(lightRed);
                        newBase.setText("");
                        newBase.requestFocus();
                    } error.setText("The highlighted field must contain an Integer");
                }
            }
        });
    }

}
