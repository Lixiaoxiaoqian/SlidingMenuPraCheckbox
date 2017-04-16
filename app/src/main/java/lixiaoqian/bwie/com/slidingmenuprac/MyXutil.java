package lixiaoqian.bwie.com.slidingmenuprac;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * @类的用途：
 * @author: 李晓倩
 * @date: 2017/4/15
 */

public class MyXutil {

    private Context context;
    private ListView lv;
    private TextView mTextView;
    private FragmentManager mFragmentManager;
    private ArrayList<String> mList;

    public MyXutil(Context context, ListView lv, TextView textView, FragmentManager fragmentManager) {
        this.context = context;
        this.lv = lv;
        mTextView = textView;
        mFragmentManager = fragmentManager;
    }

    public MyXutil(Context context, ListView lv) {
        this.context = context;
        this.lv = lv;
    }

    public void initData(){
        mList = new ArrayList<>();
        mList.add(UrL.url1);
        mList.add(UrL.url2);
        mList.add(UrL.url3);
    }


    public void getUtil(String uri){
        RequestParams params = new RequestParams(uri);
        x.http().get(params, new Callback.CommonCallback<String>() {
            public void onSuccess(String result) {
                Gson gson=new Gson();
                initData();
                GasonBean gasonBean = gson.fromJson(result, GasonBean.class);
                final List<GasonBean.DataBean> dataBeen = gasonBean.getData();
                MyLeftAdapter myLeftAdapter = new MyLeftAdapter(dataBeen,context);
                lv.setAdapter(myLeftAdapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        MyFragment myFragment = new MyFragment();
                        myFragment.category=mList.get(position);
                        mTextView.setText(dataBeen.get(position).getName());
                        mFragmentManager.beginTransaction().replace(R.id.rela_content,myFragment).commit();
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

        });


    }

    public void getDetailUtil(String uri){
        RequestParams params = new RequestParams(uri);
        x.http().get(params, new Callback.CommonCallback<String>() {
            public void onSuccess(String result) {
                Gson gson=new Gson();
                DetailBean detailBean = gson.fromJson(result, DetailBean.class);
                List<DetailBean.DataBean> data = detailBean.getData();
                MyBaseAdapter myBaseAdapter = new MyBaseAdapter(data,context);
                lv.setAdapter(myBaseAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

        });


    }
}
