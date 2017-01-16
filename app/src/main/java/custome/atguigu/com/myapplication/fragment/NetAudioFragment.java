package custome.atguigu.com.myapplication.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import custome.atguigu.com.myapplication.base.BaseFragment;


/**
 * Created by 刘红豪 on 2017/1/6.
 */

public class NetAudioFragment extends BaseFragment {
    private TextView textview;
    @Override
    public View initView() {
        textview=new TextView(mcontext);
        textview.setTextColor(Color.RED);
        textview.setGravity(Gravity.CENTER);
        textview.setTextSize(25);
        return textview;
    }

    @Override
    public void initData() {
        textview.setText("网络音乐");

    }
    public void onrefrash() {
        textview.setText("网络音乐刷新");
    }
}
