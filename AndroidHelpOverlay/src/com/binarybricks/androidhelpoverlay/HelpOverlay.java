package com.binarybricks.androidhelpoverlay;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

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

	Context ctx;
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       ctx = this;
       setContentView(R.layout.activity_help_overlay);

       //Call the set overlay, you can put the logic of checking if overlay is already called with a simple sharedpreference
       showOverLay();
       
     /*   
      * This is an old method which does't work in lot of cases please see the new method
         * Create a new framelayout so that we can associate child layouts with it
         
        final FrameLayout overlayFramelayout = new FrameLayout(getApplicationContext());

        //Set the framelayout as root layout in your activity
        setContentView(overlayFramelayout);

        //Get the reference of your main layout and reference of overlay layout 
        View view = getLayoutInflater().inflate(R.layout.activity_help_overlay, overlayFramelayout,false);
        final View overlay_view = getLayoutInflater().inflate(R.layout.overlay_view, overlayFramelayout,false);
        
        //Add both layout to the frame layout
        overlayFramelayout.addView(view);
        overlayFramelayout.addView(overlay_view);
        
        
         * In your application you might want to remove the overlay when some one clicks on it.
         * Put a ontouch or onclick listner so that we can remove overlay layout from the framelayout
         
        overlayFramelayout.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				// Determine if framelayout has overlay before removing it to prevent error
				if(overlayFramelayout.getChildCount()>1)
				overlayFramelayout.removeView(overlay_view);
				
				
				return true;
			}
		});*/
    }
    
    private void showOverLay(){

		final Dialog dialog = new Dialog(ctx, android.R.style.Theme_Translucent_NoTitleBar);

		dialog.setContentView(R.layout.overlay_view);

		LinearLayout layout = (LinearLayout) dialog.findViewById(R.id.overlayLayout);

		layout.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View arg0) {

				dialog.dismiss();

			}

		});

		dialog.show();

	}
}
