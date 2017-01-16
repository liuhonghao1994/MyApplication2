package custome.atguigu.com.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import custome.atguigu.com.myapplication.R;


/**
 * Created by 刘红豪 on 2017/1/6.
 */

public class TitleBarView extends LinearLayout implements View.OnClickListener {
    private Context mcontext;
    private TextView tv_search;
    private RelativeLayout rl_game;
    private ImageView iv_clock;
    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mcontext=context;
    }
    //每次布局接在完成后得到此方法

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tv_search= (TextView) getChildAt(1);
        rl_game= (RelativeLayout) getChildAt(2);
        iv_clock= (ImageView) getChildAt(3);
        tv_search.setOnClickListener(this);
        rl_game.setOnClickListener(this);
        iv_clock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_search:
                Toast.makeText(mcontext,"搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_game:
                Toast.makeText(mcontext,"游戏",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_clock:
                Toast.makeText(mcontext,"记录",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
