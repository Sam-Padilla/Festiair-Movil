package com.android.sspadilla.festiair.controller.pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.sspadilla.festiair.R;

public class ActivityObtainId extends Activity {
    //    elements
    private Button btnObtain;
    private TextView btntextReturn;

    private void intents(){
        btntextReturn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { finish(); }
        });
        btnObtain.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { }
        });
    }
    private void initializer(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_obtain_id);
        btntextReturn = findViewById(R.id.obtain_btntext_return);
        btnObtain = findViewById(R.id.obtain_btn_obtain_id);
        btntextReturn.setPaintFlags(btntextReturn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializer(); intents();
    }
}
