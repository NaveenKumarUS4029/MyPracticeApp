package com.example.mypracticeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    EditText srh;
    Button srhbtn;
    WebView wvsrh;
    String srhVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        srh = findViewById(R.id.srch);
        srhbtn = findViewById(R.id.srh_btn);
        wvsrh = findViewById(R.id.webview);

        srhbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srhVar = srh.getText().toString();
                wvsrh.loadUrl("https://www."+srhVar+".com");
                wvsrh.setWebViewClient(new WebViewClient());
            }
        });
    }
}