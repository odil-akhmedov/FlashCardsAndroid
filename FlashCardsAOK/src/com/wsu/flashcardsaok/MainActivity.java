package com.wsu.flashcardsaok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements
		AdapterView.OnItemClickListener {

	static char operation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] items = { "Adding", "Substraction", "Multiplication",
				"Division"};

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);

		ListView menuList = (ListView) findViewById(R.id.menuList);
		menuList.setAdapter(adapter);
		menuList.setOnItemClickListener(this);

		if (savedInstanceState == null) {
			// getFragmentManager().beginTransaction()
			// .add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		TextView textView = (TextView) view;
		String title = textView.getText().toString();

		switch (title) {
		case "Adding":
			operation = '+';
			break;
		case "Substraction":
			operation = '-';
			break;
		case "Multiplication":
			operation = '*';
			break;
		case "Division":
			operation = '/';
			break;
		}

		Intent i = new Intent(view.getContext(), CalculationActivity.class);
		i.putExtra("OPERATION", operation);

		startActivity(i);
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
