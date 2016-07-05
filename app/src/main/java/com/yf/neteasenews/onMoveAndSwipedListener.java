package com.yf.neteasenews;

/**
 * Created by YF on 2016/7/5.
 */
public interface onMoveAndSwipedListener {

    boolean onItemMove(int fromPosition , int toPosition);
    void onItemDismiss(int position);
}
