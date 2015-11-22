package bitslab.sq1;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener{
	
	EditText etA, etB, etC;
	TextView tvAns1, tvAns2;
	Button btnSolve, btnNew, btnExit;
	
	String NoSolves = "ÐÀÖÈÎÍÀËÜÍÛÕ ÊÎÐÍÅÉ ÍÅÒ";
	String AnySolve = "X - ËÞÁÎÅ ×ÈÑËÎ";
	
	DecimalFormat df = new DecimalFormat("#.##");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
	etA = (EditText) findViewById (R.id.etA);
	etB = (EditText) findViewById (R.id.etB);
	etC = (EditText) findViewById (R.id.etC);
		
	tvAns1 = (TextView) findViewById (R.id.tvAns1);
	tvAns2 = (TextView) findViewById (R.id.tvAns2);
	
	btnNew = (Button) findViewById (R.id.btnNew);
	btnSolve = (Button) findViewById (R.id.btnSolve);
	btnExit = (Button) findViewById (R.id.btnExit);	
	
	btnSolve.setOnClickListener(this);
	btnNew.setOnClickListener(this);
	btnExit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
			
		switch (v.getId()) {
		
		case R.id.btnSolve:
			float a, b, c, discriminant, x1, x2, x;
			String x1_out, x2_out, x_out;
			//a,b,c from String to Float numbers
			if (TextUtils.isEmpty(etA.getText().toString())) {
				a = 0;
			} else {
			a = Float.parseFloat (etA.getText().toString());
			}
			
			if (TextUtils.isEmpty(etB.getText().toString())) {
				b = 0;
			} else {
			b = Float.parseFloat (etB.getText().toString());
			}
			if (TextUtils.isEmpty(etC.getText().toString())) {
				c = 0;
			} else {
			c = Float.parseFloat (etC.getText().toString());
			}
						
			discriminant = b*b - 4*a*c;//Discriminant solved
			
			if ((a != 0) &  (b != 0) & (c != 0)){ // IF   AX^2+BX+C=0
				
				if (discriminant > 0) {
					x1 = (float) ((b*(-1) + Math.sqrt(discriminant)) / (2*a));
					x2 = (float) ((b*(-1) - Math.sqrt(discriminant)) / (2*a));
					//transfer from float to string
					x1_out = df.format(x1);
					x2_out = df.format(x2);
					//out solves to TextViews
					tvAns1.setText("x1 = " + x1_out);
					tvAns2.setText("x2 = " + x2_out);
					} 
				
				if (discriminant == 0) {
					x = (float) (b*(-1)/(2*a));
					x_out = df.format(x);
					tvAns1.setText(x_out);
					} 
				
				if (discriminant < 0) {
					tvAns1.setText(NoSolves);
					} 
			}
			
			if ((a == 0) & (b != 0) & (c != 0)) { //IF  BX+C=0
				x = (float) (c *(-1)/b);
				x_out = df.format(x);
				tvAns1.setText(x_out);
			}
			
			if ((a == 0) & (b == 0) & (c != 0)) { //IF  C=0
				tvAns1.setText(NoSolves);
			}
			
			if ((a == 0) & (b == 0) & (c == 0)){ //IF 0=0
				tvAns1.setText(AnySolve);
			}
			
			if ((a != 0) && (b == 0) & (c == 0)){ //IF   AX^2=0
				tvAns1.setText("x = 0");
			}
			
			if ((a != 0) & (b != 0) & (c ==0)){// IF AX^2+BX=0
				x1 = (float) (b*(-1)/a);
				x2 = 0;
				x1_out = df.format(x1);
				x2_out = df.format(x2);
				tvAns1.setText("x1 = " + x1_out);
				tvAns2.setText("x2 = " + x2_out);
			}
			
			if ((a == 0) & (b != 0) & (c ==0)){ //IF BX=0
				tvAns1.setText("x = 0");
			}
			
			if ((a != 0) & (b == 0) & (c !=0)){ //if AX^2+C=0
				if ((c/a) < 0) {
					x1 = (float) (Math.sqrt(c/a*(-1)));
					x2 = (float) (Math.sqrt(c/a*(-1))*(-1));
					x1_out = df.format(x1);
					x2_out = df.format(x2);
					tvAns1.setText("x1 = " + x1_out);
					tvAns2.setText("x2 = " + x2_out);
				} else {
					tvAns1.setText(NoSolves);
				}
			}
			
			break;
			
		case R.id.btnNew:
			etA.setText("");
			etB.setText("");
			etC.setText("");
			tvAns1.setText("");
			tvAns2.setText("");
			break;
			
		case R.id.btnExit:
			finish();
			break;
			
			
		}
	}

	
}
