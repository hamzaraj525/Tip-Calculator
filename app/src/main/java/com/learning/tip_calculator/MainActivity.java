package com.learning.tip_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    EditText editTextTotal;
    TextView textViewSeekTip, textViewPercent, textViewSeekTotal, textViewTipTen, textViewTotalTen,
            textViewTipFifteen, textViewTipTwenty, textTotalTen, textTotalTwenty, textTotalFifteen;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTotalFifteen = findViewById(R.id.edittota2);
        textTotalTwenty = findViewById(R.id.edittota3);
        textTotalTen = findViewById(R.id.txtTotal1);
        textViewTipFifteen = findViewById(R.id.edittip2);
        textViewTipTwenty = findViewById(R.id.edittip3);

        editTextTotal = findViewById(R.id.txtresl);
        textViewTipTen = findViewById(R.id.txtTip10);
        textViewTotalTen = findViewById(R.id.txtTip10);

        seekBar = findViewById(R.id.seekBar2);
        textViewSeekTip = findViewById(R.id.editlast1);
        textViewSeekTotal = findViewById(R.id.editlast2);
        textViewPercent = findViewById(R.id.txtSeekPercent);

        /* seekBar ClickListener*/
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewPercent.setText(progress + "%");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /*text change listener*/
        editTextTotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateTips();
            }
        });
    }

    private void calculateTips() {

        int amount = Integer.parseInt(editTextTotal.getText().toString());

        /*10 Tip*/
        int percentTen = (int) (amount * (10.0f / 100.0f));
        textViewTipTen.setText(String.valueOf(percentTen));
        int totalTen = amount + percentTen;
        textTotalTen.setText(String.valueOf(totalTen));

        /*15 Tip*/
        int percentFifteen = (int) (amount * (15.0f / 100.0f));
        textViewTipFifteen.setText(String.valueOf(percentFifteen));
        int totalFifteen = amount + percentFifteen;
        textTotalFifteen.setText(String.valueOf(totalFifteen));


        /*20 Tip*/
        int percentTwenty = (int) (amount * (20.0f / 100.0f));
        textViewTipTwenty.setText(String.valueOf(percentTwenty));
        int totalTwenty = amount + percentTwenty;
        textTotalTwenty.setText(String.valueOf(totalTwenty));


    }

    /*calculations*/
    private void calculate() {
        float amount = Float.parseFloat(editTextTotal.getText().toString());

        int percent = seekBar.getProgress();
        float tip = amount * percent / 100;
        textViewSeekTip.setText(String.valueOf(tip));
        float total = amount + tip;
        textViewSeekTotal.setText(String.valueOf(total));
    }

}





