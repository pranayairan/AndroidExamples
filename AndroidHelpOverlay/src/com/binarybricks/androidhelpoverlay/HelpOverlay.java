package com.binarybricks.androidhelpoverlay;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

/**
 * Copyright (C) 2012
 * @author Pranay Airan
 * AndroidHelpOverlay
 * com.binarybricks.androidhelpoverlay
 * 
 * This is a simple example of creating Help overlay screen
 * for android apps, this overlays/Coach marks helps first time
 * users of your app to get all information while they are using
 * the app, this overlay/coach marks helps in explaining different
 * functionality your app offers
 */
public class HelpOverlay extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*
         * Create a new framelayout so that we can associate child layouts with it
         */
        final FrameLayout overlayFramelayout = new FrameLayout(getApplicationContext());

        //Set the framelayout as root layout in your activity
        setContentView(overlayFramelayout);

        //Get the reference of your main layout and reference of overlay layout 
        View view = getLayoutInflater().inflate(R.layout.activity_help_overlay, overlayFramelayout,false);
        final View overlay_view = getLayoutInflater().inflate(R.layout.overlay_view, overlayFramelayout,false);
        
        //Add both layout to the frame layout
        overlayFramelayout.addView(view);
        overlayFramelayout.addView(overlay_view);
        
        /*
         * In your application you might want to remove the overlay when some one clicks on it.
         * Put a ontouch or onclick listner so that we can remove overlay layout from the framelayout
         */
        overlayFramelayout.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				// Determine if framelayout has overlay before removing it to prevent error
				if(overlayFramelayout.getChildCount()>1)
				overlayFramelayout.removeView(overlay_view);
				
				
				return true;
			}
		});
    }
}
