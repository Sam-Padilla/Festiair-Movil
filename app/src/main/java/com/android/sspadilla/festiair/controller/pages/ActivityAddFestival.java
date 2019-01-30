package com.android.sspadilla.festiair.controller.pages;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.android.sspadilla.festiair.R;

public class ActivityAddFestival extends Activity {
   //    elements
   private TextView btntextReturn;
   private Button btnAdd;

   private void intents(){
      this.btntextReturn.setOnClickListener(new View.OnClickListener() {
         @Override public void onClick(View v) { finish(); }
      });
      btnAdd.setOnClickListener(new View.OnClickListener() {
         @Override public void onClick(View v) {
            finish();
            startActivity(new Intent(ActivityAddFestival.this,ActivityPrincipal.class));
         }
      });
   }
   private void initializer(){
      this.requestWindowFeature(Window.FEATURE_NO_TITLE);
      setContentView(R.layout.activity_add_festival);
      btnAdd = findViewById(R.id.festival_btn_add);
      btntextReturn = findViewById(R.id.festival_btntext_return);
      btntextReturn.setPaintFlags(btntextReturn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
   }
   @Override protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      initializer(); intents();
   }
}
