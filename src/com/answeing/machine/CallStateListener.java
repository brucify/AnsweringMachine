package com.answeing.machine;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallStateListener extends PhoneStateListener {
	private Context ctx;
	
	public CallStateListener (Context ctx) {
		this.ctx = ctx;
	}
	
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		switch (state) {
		case TelephonyManager.CALL_STATE_RINGING:
			Toast.makeText(ctx, "Incoming: " + incomingNumber,
					Toast.LENGTH_LONG).show();
			break;
		}
	}
}
