package lixiaoqian.bwie.com.slidingmenuprac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @类的用途：
 * @author: 李晓倩
 * @date: 2017/4/15
 */
@ContentView(R.layout.fragment_lay)
public class MyFragment extends Fragment{
    @ViewInject(R.id.flv)
    ListView listView;
    public String category;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new MyXutil(getContext(),listView).getDetailUtil(category);
    }
}
