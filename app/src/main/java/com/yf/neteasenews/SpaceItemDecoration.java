package com.yf.neteasenews;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by YF on 2016/7/5.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    int mSpace;

    public SpaceItemDecoration(int space){
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

       int pos =  parent.getChildAdapterPosition(view);

        outRect.left = mSpace;
        outRect.top = 0;
        outRect.bottom = mSpace;
        outRect.right = mSpace;


    }
}
