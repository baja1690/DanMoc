package com.app.diy.views.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;

import com.app.diy.R;

/**
 * Created by Cuong Pham on 3/14/17.
 */

public class SimpleLoadingDialog extends AlertDialog {

    public SimpleLoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public SimpleLoadingDialog(@NonNull Context context) {
        super(context, R.style.dialogStyle);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_progressbar);
    }
}
