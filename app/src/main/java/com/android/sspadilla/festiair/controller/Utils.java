package com.android.sspadilla.festiair.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;



public class Utils {
//   java fx utilities
   // to change scene

   public void showAlert(Activity context, String message){
      AlertDialog alertDialog = new AlertDialog.Builder(context).create();
      alertDialog.setTitle("Alerta");
      alertDialog.setMessage(message);
      alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Aceptar",
              new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); }
              });
      alertDialog.show();
      }

//   text methods
   public String removeSecondWord (String word){
   if (word.contains(" ")){
      word = word.substring(0, word.indexOf(" "));
   }
   return word;
}
   public String toCamelCase(final String init) {
      if (init==null) return null;
      final StringBuilder ret = new StringBuilder(init.length());
      for (final String word : init.split(" ")) {
         if (!word.isEmpty()) {
            ret.append(word.substring(0, 1).toUpperCase());
            ret.append(word.substring(1).toLowerCase());
         }
         if (!(ret.length()==init.length())) ret.append(" ");
      }
      return ret.toString().replace(" ","");
   }
   public String toStringFormatted(String text){
      return text.replaceAll("(.)(\\p{Upper})", "$1 $2");
   }

}
