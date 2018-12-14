package com.example.quinnh.icons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{
double converion_rate = 0.22;
double amount_entered = 0.0;
double conversion_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText calculate = (EditText) findViewById(R.id.text_conversion);
        final RadioButton gpb_usd = (RadioButton) findViewById(R.id.gpb_to_usd);
        final RadioButton usd_gpb = (RadioButton) findViewById(R.id.usd_to_gpb);
        final TextView result = (TextView) findViewById(R.id.text_result);
        Button convert = (Button) findViewById(R.id.btn_convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount_entered = Double.parseDouble(calculate.getText().toString());
                DecimalFormat formater = new DecimalFormat("###,###.##");
                if (gpb_usd.isChecked()) {
                    conversion_amount = amount_entered * converion_rate;
                    result.setText("There is $" + formater.format(conversion_amount) + " dollars.");
                }
                if (usd_gpb.isChecked()) {
                    if (amount_entered >= 0.02) {
                        conversion_amount = amount_entered * converion_rate;
                        result.setText("There is " + formater.format(conversion_amount) + " pounds.");
                    } else {
                        Toast.makeText(MainActivity.this, "The amount of british pounds is equivilant to zero US dollars.", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
}
}
