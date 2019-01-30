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
import com.android.sspadilla.festiair.controller.Utils;
import com.android.sspadilla.festiair.model.managers.UsersManager;

public class ActivityStart extends Activity {
//    elements
    private TextView btntextObtainId;
    private Button btnAccept;
    private EditText inputId;
    private Utils utils = new Utils();

    private void intents(){
        btntextObtainId.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(ActivityStart.this,ActivityObtainId.class));
            }});

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String idString = inputId.getText().toString();
                try{
                    int id = Integer.valueOf(idString);
                    if (!idString.equals("") && new UsersManager().userExist(id)){
                        startActivity(new Intent(ActivityStart.this,ActivityPrincipal.class));
                        finish();
                    }else { throw new NumberFormatException(); }
                }catch (NumberFormatException e){
                   utils.showAlert(ActivityStart.this,"Verifique su Id");
                }
            }
        });
    }
    private void initializer(){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        btntextObtainId = findViewById(R.id.start_btntext_obtain);
        btnAccept = findViewById(R.id.start_btnAccept);
        inputId = findViewById(R.id.inputId);
        btntextObtainId.setPaintFlags(btntextObtainId.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializer(); intents();
    }

}
