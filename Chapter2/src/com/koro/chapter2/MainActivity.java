package com.koro.chapter2;

import java.text.NumberFormat;
import java.text.ParseException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String tag="Chapter 2";
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    final EditText mealpricefield = (EditText)  findViewById(R.id.mealprice);
    
    final TextView answerfield = (TextView) findViewById(R.id.answer);
    
    final Button button = (Button) findViewById(R.id.calculate);
    
    
    button.setOnClickListener( new  View.OnClickListener (){

		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
			Log.i(tag, "onClick invoked.");
			
			String mealprice = mealpricefield.getText().toString();
			
			Log.i(tag, "mealprice is ["+mealprice+"]");
			
			String answer ="";
			
			if(mealprice.indexOf("$")==-1){
				
				
				mealprice = "$"+mealprice;
				
			}
			
			float fmp = 0.0F;
			
			NumberFormat nf = java.text.NumberFormat.getCurrencyInstance();
			
			
				fmp = nf.parse(mealprice).floatValue();
				
				fmp *=1.2;
				
				Log.i(tag, "Total meal price (unformatted) id ["+fmp+"]");
				
				answer = "Full price, Including 20% Tip:"+nf.format(fmp);
				
				answerfield.setText(answer);
				
				Log.i(tag, "onClick complete");
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				Log.i(tag,"Parse exception caught");
				
				answerfield.setText("Failed to parse amount?");
			} catch (Exception e) {
				// TODO: handle exception
				Log.i(tag, "Failed to calculate Tip"+e.getMessage());
				answerfield.setText(e.getMessage());
			}
			
			
			
		} 
    	
    	
    } );
    
    
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
