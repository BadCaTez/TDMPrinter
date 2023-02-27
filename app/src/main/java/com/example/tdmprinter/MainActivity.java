package com.example.tdmprinter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tscdll.TSCActivity;

public class MainActivity extends AppCompatActivity {

    TSCActivity TscDLL = new TSCActivity();
    TextView testText = (TextView) findViewById(R.id.text_test);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aboba(View view) {
        TscDLL.openport("");
        TscDLL.setup(30,30,2,4,0,0,0);
        TscDLL.clearbuffer();
        TscDLL.sendcommand("TEXT 100,250,\"3\",0,15,15,\"Beer\"\n");
        TscDLL.barcode(100, 100, "128", 100, 1, 0, 3, 3, "123456789");
        TscDLL.printerfont(100, 250, "3", 0, 1, 1, "987654321");
        TscDLL.closeport(5000);
    }
}