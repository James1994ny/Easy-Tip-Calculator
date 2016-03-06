package com.example.easytipcalculatorhtcemail;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    
	static int personCount=1;
	static double grandTotalFinal;
	static double DouCostPerPerson;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//THIS SETS CONTENT VIEW TO activity_main
        

        
       
        final EditText inputValue=(EditText) findViewById(R.id.editText3);
        final EditText inputTip=(EditText) findViewById(R.id.editText2);
        final EditText inputTax=(EditText) findViewById(R.id.editText1Email);
        
        Button addPerson=(Button) findViewById(R.id.button1);
        Button subPerson=(Button) findViewById(R.id.button2);
        Button calculateFinal=(Button) findViewById(R.id.button3);
        Button emailIntent=(Button) findViewById(R.id.button4);		//EMAIL BUTTOn
        
        
        final TextView personCountView=(TextView) findViewById(R.id.textView4);//For display to count # of ppl
        String StringPersonCountView=String.valueOf(personCount);//NOTE: anything.setText(String) MUST HAVE A STRING INSIDE IT.
        personCountView.setText(StringPersonCountView);//At start the number of people is 1
        
        
        final TextView grandTotal=(TextView) findViewById(R.id.textView7);
        final TextView costPerPerson=(TextView) findViewById(R.id.textView9);//TEXT FIELD COST PER PERSON
        
        
        calculateFinal.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
			        double doubleTip=0;
			        double doubleTax=0;
			        double doubleValue=0;
				
				
				
				try{String stringValue=inputValue.getText().toString();//converts the 3 values to String
					String stringTip=inputTip.getText().toString();
					String stringTax=inputTax.getText().toString();
					
					doubleTip=Double.parseDouble(stringTip);//Converts the 3 values then to doubles.
					doubleTax=Double.parseDouble(stringTax);
					
					doubleValue=Double.parseDouble(stringValue);
					
				}
				catch(Exception e){ //If there is an exception, the tip tax and value is zero, thus not Stringed
					doubleTip=0;
					doubleTax=0;
					doubleValue=0;
					
					
				}
					
					doubleTip=doubleTip*.01;
				
				
				
				
					doubleTax=doubleTax*.01;

				
				
			    grandTotalFinal=((doubleTax*doubleValue)+(doubleTip*doubleValue)+(doubleValue));//Gets the value of the grand total
				String grandTotalString=String.valueOf("$" + grandTotalFinal);
				grandTotal.setText(grandTotalString);
			
				DouCostPerPerson=((doubleTax*doubleValue)+(doubleTip*doubleValue))/(personCount);
				String StringCPP=String.valueOf("$"+DouCostPerPerson);
				costPerPerson.setText(StringCPP);
				
			}
        
        });
        
        
        
        
        addPerson.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				personCount++;
				String StringPersonCountView=String.valueOf(personCount);
				personCountView.setText(StringPersonCountView);
			}    
    
        });
        
        subPerson.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				personCount--;
				String StringPersonCountView=String.valueOf(personCount);
				personCountView.setText(StringPersonCountView);
			}    
    
        });
        
        emailIntent.setOnClickListener(new OnClickListener(){//Button to create an intent to goto the email page
        			
        	
        			//View bucky android tutorial 12 and 15 to link the two activities
        			//NOTE AN ACTIVITY IS LIKE A NEW PAGE ON AN APP. AN INTENT IS AN ACTION
        			//AN INTENT IS NORMALLY USED TO CREATE A NEW ACTIVITY OR NEW PAGE
        			
			@Override
			public void onClick(View v) {//Creating intent "openEmailIntent" to create/open the email intent/page  //Bucky tutorial 15
				Intent openEmailIntent = new Intent("com.example.easytipcalculatorhtcemail.EMAIL");  				
					
					openEmailIntent.putExtra("IdentifierForTotal",grandTotalFinal);	//Transfers the value from grandTotalFinal value nicknamed value "IdentifierForTotal" to the email class using "Extras"
					openEmailIntent.putExtra("CostPerPersonId",DouCostPerPerson);																//to the email class using "Extras" using method .putExtra   http://stackoverflow.com/questions/13178056/get-data-from-another-activity
				
				startActivity(openEmailIntent);// starts the openEmailIntent intent/action									
			}
				//REMEMBER YOU MUST PUT THE Email.java PAGE IN THE ANDROID MANIFEST
				//BUCKY JAVA ANDROID LESSON 13
				//MAKE SURE <action android:name="com.example.easytipcalculatorhtcemail.EMAIL" />
        
        });
        
    
    }


    
	
	
	
	
	
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
