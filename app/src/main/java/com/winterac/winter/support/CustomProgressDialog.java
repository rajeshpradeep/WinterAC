package com.winterac.winter.support;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.winterac.winter.R;


/**
 * Created by Rajesh on 30/12/2016.
 */
public class CustomProgressDialog extends Dialog{
    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }


    public void onWindowFocusChanged(boolean hasFocus){
        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }

    public void setMessage(CharSequence message) {
        if(message != null && message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.GONE);
            TextView txt = (TextView)findViewById(R.id.message);
            txt.setText(message);
            txt.invalidate();
        }
    }

    public CustomProgressDialog show(Context context, CharSequence message, boolean cancelable) {
        CustomProgressDialog dialog = new CustomProgressDialog(context,R.style.ProgressDialog);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_dialog);
        if(message == null || message.length() == 0) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView)dialog.findViewById(R.id.message);
            txt.setText(message);
        }
        dialog.setCancelable(cancelable);
//        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity= Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount=0.2f;
        dialog.getWindow().setAttributes(lp);
        //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.show();
        return dialog;
    }
}
