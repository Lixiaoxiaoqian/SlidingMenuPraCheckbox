package lixiaoqian.bwie.com.slidingmenuprac;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @类的用途：
 * @author: 李晓倩
 * @date: 2017/4/15
 */

public class MyLeftAdapter extends BaseAdapter{
    private List<GasonBean.DataBean> mList;
    private Context mContext;

    public MyLeftAdapter(List<GasonBean.DataBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(mContext,R.layout.left_item,null);
            holder.mTextView= (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.mTextView.setText(mList.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        TextView mTextView;
    }
}
