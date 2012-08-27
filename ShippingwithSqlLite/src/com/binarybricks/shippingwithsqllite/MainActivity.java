package com.binarybricks.shippingwithsqllite;

import com.binarybricks.DBHelper.DataBaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //This methos will be used to copy db if doesn't exsist
        DataBaseHelper mydatabaseHelper = new DataBaseHelper(this);
        
        //Get Reference of your db
        SQLiteDatabase myDataBase = mydatabaseHelper.openDataBase();
        Cursor result =myDataBase.rawQuery("SELECT * FROM HelloSQL",null);
		if (result != null) {
	           while(result.moveToNext()) {
	                	  String appname = result.getString(result.getColumnIndex("Hello"));
	                	  TextView helloName = (TextView)findViewById(R.id.helloworld);
	                	  helloName.setText(appname);
	                	  break;
	            } 
		   }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
