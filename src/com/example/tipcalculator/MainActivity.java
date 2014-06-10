package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import android.view.KeyEvent;

public class MainActivity extends Activity {
	String totalAmount = "";
	TextView tv;
	EditText et;
	SeekBar sb;
	TextView tv1;
	TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.textView1);
		et = (EditText) findViewById(R.id.editText1);
		sb = (SeekBar) findViewById(R.id.seekBar1);
		tv1 = (TextView) findViewById(R.id.textView2);
		tv2 = (TextView) findViewById(R.id.textView3);
		// tv.setText("Tip is : $" + sb.getProgress());
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				tv1.setText("Tip Percentage : " + progress + "%");
				calculateTip(progress);

			}
		});

	}

	public void fromButton(View v) {
		calculateTip(Integer.parseInt(v.getTag().toString()));
	}

	public void calculateTip(int tipPercentage) {

		totalAmount = et.getText().toString();
		if (totalAmount.isEmpty()) {
			Toast.makeText(MainActivity.this, "Enter bill Amount",
					Toast.LENGTH_SHORT).show();
			return;
		} else {
			try {
				double amount = Double.parseDouble(totalAmount);
				double tip = amount * (tipPercentage / 100.0);
				DecimalFormat df = new DecimalFormat("#.##");
				tv.setText("Tip : $" + df.format(tip));
				tv2.setText("Total Amount : $" + df.format(tip + amount));

			} catch (ParseException e) {
				Toast.makeText(MainActivity.this, "Invalid value",
						Toast.LENGTH_SHORT).show();
				return;
			}

		}
	}

}
