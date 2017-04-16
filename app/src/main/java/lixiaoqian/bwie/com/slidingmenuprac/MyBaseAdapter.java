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

public class MyBaseAdapter extends BaseAdapter{

    private List<DetailBean.DataBean> mBeanList;
    private Context mContext;

    public MyBaseAdapter(List<DetailBean.DataBean> beanList, Context context) {
        mBeanList = beanList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mBeanList.size();
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
        MyViewHolder holder;
        if(convertView==null){
            holder=new MyViewHolder();
            convertView=View.inflate(mContext,R.layout.lv_item,null);
            holder.mTextView2= (TextView) convertView.findViewById(R.id.textView2);
            holder.mTextView3= (TextView) convertView.findViewById(R.id.textView3);
            holder.mTextView4= (TextView) convertView.findViewById(R.id.textView4);
            convertView.setTag(holder);
        }else{
            holder= (MyViewHolder) convertView.getTag();
        }
        holder.mTextView2.setText(mBeanList.get(position).getTitle());
        holder.mTextView3.setText(mBeanList.get(position).getApply());
        holder.mTextView4.setText(mBeanList.get(position).getBuy_price());
        return convertView;
    }

    class MyViewHolder{
        TextView mTextView2;
        TextView mTextView3;
        TextView mTextView4;
    }

}
