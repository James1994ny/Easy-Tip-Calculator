package com.example.easytipcalculatorhtcemail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends Activity{//WATCH JAVA TUT 12 for reference
									//THIS IS THE EMAIL ACTIVITY
	
	
	@Override
	protected void onCreate(Bundle emailPageThing) {
		// TODO Auto-generated method stub
		super.onCreate(emailPageThing);
		setContentView(R.layout.emailpage);	//This was added by me. Created an xml page called email and
											//set the R.layout to email.
											//Bucky tutorial 11 for xml page setup
	
	Bundle extras = getIntent().getExtras();	//Imports the extras from MainActivity and stores them as varibable "extras"
	final Double EmailGrandTotal= extras.getDouble("IdentifierForTotal");	//Sets the variable EmailGrandTotalString with the identifier in the MainActivity class.
	final Double EmailCostPerPerson=extras.getDouble("CostPerPersonId");	
	

	
	
	final EditText EmailInput=(EditText) findViewById(R.id.editText1Email);
	final EditText LocationInput=(EditText) findViewById(R.id.editText1Location);
	final EditText NameInput=(EditText) findViewById(R.id.editText1Recipient);
	
	
	final TextView emailTotalCost=(TextView) findViewById(R.id.GrandTotalText);	
	emailTotalCost.setText("Grand total is " + EmailGrandTotal);	
	
	final TextView EmCostPerPerson=(TextView) findViewById(R.id.textView4);
	EmCostPerPerson.setText("Cost per person is "+ EmailCostPerPerson);
	
	
	
	
	
	
	
	
	Button sendButton=(Button)findViewById(R.id.button1Send);
	sendButton.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			String stringEmailInput=EmailInput.getText().toString();		//When the button is clicked, it grabs the user data and saves them
			String stringLocationInput=LocationInput.getText().toString();	
			String stringNameInput=NameInput.getText().toString();
			
			String EmailgrandTotalString=String.valueOf("$" + EmailGrandTotal);
			String EmailgrandCostPerPerson=String.valueOf("$" + EmailCostPerPerson);
			
		
			String MyMessage=		//My message to input to my email
			"Hi "+stringNameInput+"! "+"Your grand total sum from your stay at "
			+ stringLocationInput+" is "+EmailgrandTotalString+"and your cost per person value is "+
			EmailCostPerPerson;
			
			
			
			Intent myEmailIntent = new Intent(android.content.Intent.ACTION_SEND);  //Starts up intent
			myEmailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,stringEmailInput); //Puts in the email input into the EMAIL intent
			myEmailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Your tip or tax!"); // The subject of the email
			myEmailIntent.setType("plain/text");
			myEmailIntent.putExtra(android.content.Intent.EXTRA_TEXT,MyMessage);   //Put the message I created earlier into the email
			
			startActivity(myEmailIntent);
			
		}
		
		
		
	
	
	
	
	});
	
	
	
	Button goBackButton=(Button)findViewById(R.id.button1GoBack);	
	goBackButton.setOnClickListener(new OnClickListener(){	//THIS IS THE GO BACK TO MAIN ACTIVITY BUTTON/INTENT CREATOR BUTTON

		@Override
		public void onClick(View arg0) {
			Intent goBackIntent= new Intent(Email.this, MainActivity.class);//NOTE: This is the constructor to go back to Main class. 
			
			/* Variable goBackIntent was created as an Intent variable. new Intent(Parameter1.this, Parameter2.this)
			Parameter1 is the current intent, so Email.this  Parameter 2 is the goto intent which is MainActivity.class
			
			Here is the layout to create a new intent :Intent openEmailIntent = new Intent("com.example.easytipcalculatorhtcemail.EMAIL");
			assuming that the activity you want to open name is "com.example.easytipcalculatorhtcemail.EMAIL"
			
			Here is the layout to open an existing intent:Intent i=new Intnet(Activity1.this,Activity2.class) 
			assuming that your current class name is Actvity1 startActivity(i);
			*/
			
			//startActivity(goBackIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));  //Same thing I think, forum says to use this
			
			startActivity(goBackIntent);
		
		}
	
	});
	
	
	
	
	
	}												
	}





