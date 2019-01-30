package com.android.sspadilla.festiair.controller.pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.android.sspadilla.festiair.R;

public class ActivityPrincipal extends Activity {
   //    elements
   private Button btnAddFestival;
   private TextView btntextExitStart;

   private void intents(){

      btnAddFestival.setOnClickListener(new View.OnClickListener() {
         @Override public void onClick(View v) {
            startActivity(new Intent(ActivityPrincipal.this,ActivityAddFestival.class));
         }});
      btntextExitStart.setOnClickListener(new View.OnClickListener() {
         @Override public void onClick(View v) {
            finish();
         }});
   }
   private void initializer(){
      this.requestWindowFeature(Window.FEATURE_NO_TITLE);
      setContentView(R.layout.activity_principal);
      btnAddFestival = findViewById(R.id.principal_btn_add);
      btntextExitStart = findViewById(R.id.principal_btntext_exit);
     // btnAddFestival.setPaintFlags(btnAddFestival.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
   }
   @Override protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      initializer(); intents();
   }
}
