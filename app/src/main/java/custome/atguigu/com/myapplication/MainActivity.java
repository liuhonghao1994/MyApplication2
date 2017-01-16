package custome.atguigu.com.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import java.util.ArrayList;

import custome.atguigu.com.myapplication.base.BaseFragment;
import custome.atguigu.com.myapplication.fragment.LocalAudioFragment;
import custome.atguigu.com.myapplication.fragment.LocalVideoFragment;
import custome.atguigu.com.myapplication.fragment.NetAudioFragment;
import custome.atguigu.com.myapplication.fragment.RecyclerFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_main;
    private ArrayList<BaseFragment> fragments;
    private int position;
    //设置一个缓存
    private Fragment tempFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_main= (RadioGroup) findViewById(R.id.rg_main);
        initFragment();
        initListener();

    }


    private void initListener() {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_local_video:
                        position=0;
                        break;
                    case R.id.rb_local_audio:
                        position=1;
                        break;
                    case R.id.rb_net_audio:
                        position=2;
                        break;
                    case R.id.rb_net_video:
                        position=3;
                        break;
                }
                Fragment currentfg = fragments.get(position);
                switchFragment(currentfg);
            }
        });
        rg_main.check(R.id.rb_local_video);
    }



    private void initFragment() {
        fragments=new ArrayList<>();
        fragments.add(new LocalVideoFragment());
        fragments.add(new LocalAudioFragment());
        fragments.add(new NetAudioFragment());
        fragments.add(new RecyclerFragment());
    }

    private void switchFragment(Fragment currentfg) {
        if(tempFragment!=currentfg){
            //开启事务
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(currentfg!=null){
                //如果没有添加到事务中
                if(!currentfg.isAdded()){
                    if(tempFragment!=null){
                        ft.hide(tempFragment);
                    }
                    //如果没有添加就先去添加
                    ft.add(R.id.fl_main_content,currentfg);
                }else{
                    if(tempFragment!=null){
                        ft.hide(tempFragment);
                    }
                    //如果添加过了，就去显示出来
                    ft.show(currentfg);
                }
                ft.commit();
            }
            tempFragment = currentfg;
        }

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

}
