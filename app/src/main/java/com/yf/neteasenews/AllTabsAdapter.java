package com.yf.neteasenews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by YF on 2016/7/5.
 */
public class AllTabsAdapter extends RecyclerView.Adapter {

    public interface onAllTabsListener{
        void allTabsItemClick(View view , int position);
    }


    private Context context;
    private LayoutInflater layoutInflater;
    private onAllTabsListener listener;

    public void setListener(onAllTabsListener listener){
        this.listener = listener;
    }

    public AllTabsAdapter(Context context){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public class AllTabsViewHolder extends RecyclerView.ViewHolder{

        private TextView txt;

        public AllTabsViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.tabs_txt);
        }
    }

//***************************继承的方法*******************************************
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AllTabsViewHolder(layoutInflater.inflate(R.layout.item_tabs , null , false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final AllTabsViewHolder viewHolder = (AllTabsViewHolder) holder;
        viewHolder.txt.setText(MainActivity.allTabs.get(position));
        viewHolder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.allTabsItemClick(viewHolder.itemView , position);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (MainActivity.allTabs.size() != 0){
            return MainActivity.allTabs.size();
        }
        else {
            return 0;
        }
    }
}
