package com.example.administrator.popdemo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {
    private PopupWindow pw;
    private LinearLayout ll_order_state;
    private LinearLayout llLayout;
    private TextView tvAll;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv_state;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_order_state = (LinearLayout) findViewById(R.id.ll_order_state);
        tv_state = (TextView) findViewById(R.id.tv_dangqian_state);
        llLayout = (LinearLayout) View.inflate(MainActivity.this,
                R.layout.item_popwindow, null);
        tvAll = (TextView) llLayout.findViewById(R.id.tv_shenhe_all);
        tv1 = (TextView) llLayout.findViewById(R.id.tv_shenhe1);
        tv2 = (TextView) llLayout.findViewById(R.id.tv_shenhe2);
        tv3 = (TextView) llLayout.findViewById(R.id.tv_shenhe3);


        ll_order_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i % 2 == 0) {
                    ShowPop();
                } else {
                    ClosePop();
                }

            }
        });
        tvAll.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
    }

    /**
     * 打开pop
     */
    protected void ShowPop() {
        i++;
        if (pw == null) {
            pw = new PopupWindow();
            pw.setWidth(ll_order_state.getWidth());
            pw.setHeight(ll_order_state.getHeight() * 4);
            pw.setContentView(llLayout);
            pw.setFocusable(false);
        }
        pw.showAsDropDown(ll_order_state);

    }

    /**
     * 关闭pop
     */
    private void ClosePop() {
        i++;
        if (pw != null) {
            pw.dismiss();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_shenhe_all:
                ClosePop();
                tv_state.setText("全部");
                break;
            case R.id.tv_shenhe1:
                ClosePop();
                tv_state.setText("审核成功");
                break;
            case R.id.tv_shenhe2:
                ClosePop();
                tv_state.setText("审核失败");
                break;
            case R.id.tv_shenhe3:
                ClosePop();
                tv_state.setText("等待审核");
                break;
            default:
                break;
        }
    }
}
