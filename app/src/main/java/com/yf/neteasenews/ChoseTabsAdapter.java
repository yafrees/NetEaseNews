package com.yf.neteasenews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;

/**
 * Created by YF on 2016/7/5.
 */
public class ChoseTabsAdapter extends RecyclerView.Adapter implements onMoveAndSwipedListener {

    private Context context;
    private LayoutInflater layoutInflater;

    public ChoseTabsAdapter(Context context){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public class ChoseTabsViewHolder extends RecyclerView.ViewHolder {


        private TextView txt;


        public ChoseTabsViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.tabs_txt);

        }
    }

//    ************继承和实现的方法************************
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChoseTabsViewHolder(layoutInflater.inflate(R.layout.item_tabs , null , false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ChoseTabsViewHolder viewHolder = (ChoseTabsViewHolder) holder;
        viewHolder.txt.setText(MainActivity.choseTabs.get(position));
    }

    @Override
    public int getItemCount() {
        return MainActivity.choseTabs.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //交换mItems的数据位置
        Collections.swap(MainActivity.choseTabs , fromPosition , toPosition);
        //交换RecycleView列表中item的位置
        notifyItemMoved(fromPosition , toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        //删除mItems的数据
        MainActivity.choseTabs.remove(position);
        //删除RecycleView列表对应item
        notifyItemRemoved(position);

    }
}
