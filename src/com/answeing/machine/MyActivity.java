package com.answeing.machine;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.util.Log;

public class MyActivity extends Activity {

	private final String TAG = this.getClass().getSimpleName();
	private final String RESTORE = "";
	private final String state = "fortytwo";
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my, menu);
		return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		System.out.println("asdsadsadads: " + TAG);
		String answer = null;
		if (savedInstanceState != null) {
			answer = savedInstanceState.getString("answer");
		}
		Log.i(TAG, "onCreate"
				+ (null == savedInstanceState ? "" : (RESTORE + "" + answer)));
		Log.i(TAG, "this is a msg.");
		// Show the Up button in the action bar.
		// getActionBar().setDisplayHomeAsUpEnabled(true);

		// savedInstanceState is non-null when there is fragment state
		// saved from previous configurations of this activity
		// (e.g. when rotating the screen from portrait to landscape).
		// In this case, the fragment will automatically be re-added
		// to its container so we don't need to manually add it.
		// For more information, see the Fragments API guide at:
		//
		// http://developer.android.com/guide/components/fragments.html
		//
		// if (savedInstanceState == null) {
		// // Create the detail fragment and add it to the activity
		// // using a fragment transaction.
		// Bundle arguments = new Bundle();
		// arguments.putString(ItemDetailFragment.ARG_ITEM_ID, getIntent()
		// .getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
		// ItemDetailFragment fragment = new ItemDetailFragment();
		// fragment.setArguments(arguments);
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.item_detail_container, fragment).commit();
		// }
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause" + (isFinishing() ? " Finishing" : ""));
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG,
				"onDestroy" + Integer.toString(getChangingConfigurations(), 16));
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("answer", state);
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState");
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		Log.i(TAG, "onRetainNonConfigurationInstance");
		return new Integer(getTaskId());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedState) {
		super.onRestoreInstanceState(savedState);
		String answer = null != savedState ? savedState.getString("answer")
				: "";
		@SuppressWarnings("deprecation")
		Object oldTaskObject = getLastNonConfigurationInstance();
		if (oldTaskObject != null) {
			int oldtask = ((Integer) oldTaskObject).intValue();
			int currentTask = getTaskId();
			assert oldtask == currentTask;
		}
		Log.i(TAG, "onRestoreInstanceState"
				+ (savedState == null ? "" : RESTORE) + "" + answer);
	}

	@Override
	protected void onPostCreate(Bundle savedState) {
		super.onPostCreate(savedState);
		String answer = null;
		if (savedState != null) {
			answer = savedState.getString("answer");
		}
		Log.i(TAG, "onPostCreate"
				+ (savedState == null ? "" : (RESTORE + "" + answer)));
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		Log.i(TAG, "onPostResume");
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		Log.i(TAG, "onUserLeaveHint");
	}

}

