package lixiaoqian.bwie.com.slidingmenuprac;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_ch;
    private TextView title;
    private SlidingMenu side_drawer;
    private List<String> mList;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mManager = getSupportFragmentManager();
        initControl();

    }

    private void initControl() {
        initSildMenu();
        tv_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(side_drawer.isMenuShowing()){
                    side_drawer.showContent();
                }else{
                    side_drawer.showMenu();
                }
            }
        });
    }

    private void initSildMenu() {
        side_drawer = new SlidingMenu(this);
        WindowManager wm = getWindowManager() ;
        DisplayMetrics displayMetrics = new DisplayMetrics() ;
        wm.getDefaultDisplay() .getMetrics(displayMetrics );
        side_drawer.setBehindWidth( displayMetrics.widthPixels / 3*2);

        //设置侧滑模式为向左侧滑
        side_drawer.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        side_drawer.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        //side_drawer.setShadowWidthRes(R.dimen.shadow_width);
        side_drawer.setShadowWidth(20);
        side_drawer.setShadowDrawable(R.color.colorGray);

        // 设置滑动菜单视图的宽度

       // side_drawer.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        side_drawer.setFadeDegree(0.65f);

        side_drawer.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        side_drawer.setMenu(R.layout.left_drawer_fragment);
        View v=View.inflate(this,R.layout.left_drawer_fragment,null);
        ListView lv= (ListView) v.findViewById(R.id.lv);
        new MyXutil(this,lv,title,mManager).getUtil(UrL.urltitle);

        side_drawer.setMenu(v);
    }

    private void initView() {
        tv_ch = (TextView) findViewById(R.id.tv_ch);
        title = (TextView) findViewById(R.id.title);
    }

}
