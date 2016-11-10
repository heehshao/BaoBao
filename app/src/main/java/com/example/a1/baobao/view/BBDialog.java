package com.example.a1.baobao.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.a1.baobao.R;


/**
 * Created by syc 2016/11/10.
 */
public class BBDialog extends Dialog {
    private Context mContext;

    private TextView mTextView;

    private CharSequence title;
    private RotateLoading loading;

    protected BBDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public BBDialog(Context context, int theme) {
        super(context, theme);
    }

    public BBDialog(Context context) {
        super(context, R.style.dialog_style_01);
        mContext = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.bb_dialog, null);
        setContentView(view);

        loading = (RotateLoading) view.findViewById(R.id.rotateLoading1);
        mTextView = (TextView) view.findViewById(R.id.content_text);
        mTextView.setText(title);
        loading.start();
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = mContext.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.4); // 高度设置为屏幕的0.6
        lp.height = (int) (d.widthPixels * 0.4); // 高度设置为屏幕的0.6
        dialogWindow.setAttributes(lp);
    }

    public void setContentTv(CharSequence content) {
        title = content;
    }

    @Override
    public void dismiss() {
        loading.stop();
        super.dismiss();
    }

}
