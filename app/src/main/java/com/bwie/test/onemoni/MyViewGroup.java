package com.bwie.test.onemoni;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ASUS on 2017/11/4.
 */

public class MyViewGroup extends ViewGroup {
    private int width;
    private int height;
    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        View child1=getChildAt(0);
        View child2=getChildAt(1);
        View child3=getChildAt(2);
        View child4=getChildAt(3);
        if(child1!=null){
            child1.layout(0,0, child1.getMeasuredWidth(), child1.getMeasuredHeight());
        }
        if(child2!=null){
            child2.layout(child1.getMeasuredWidth(),child1.getMeasuredHeight(), child1.getMeasuredWidth()+child2.getMeasuredWidth(), child1.getMeasuredHeight()+child2.getMeasuredHeight());
        }
        if(child3!=null){
            child3.layout(child1.getMeasuredWidth()+child2.getMeasuredWidth(), child1.getMeasuredHeight()+child2.getMeasuredHeight(), child3.getMeasuredWidth()+child1.getMeasuredWidth()+child2.getMeasuredWidth(),  child3.getMeasuredHeight()+child1.getMeasuredHeight()+child2.getMeasuredHeight());
        }
        if(child4!=null){
            child4.layout(child3.getMeasuredWidth()+child1.getMeasuredWidth()+child2.getMeasuredWidth(),child3.getMeasuredHeight()+child1.getMeasuredHeight()+child2.getMeasuredHeight(), child3.getMeasuredWidth()+child1.getMeasuredWidth()+child2.getMeasuredWidth()+child4.getMeasuredWidth(), child4.getMeasuredHeight()+child3.getMeasuredHeight()+child1.getMeasuredHeight()+child2.getMeasuredHeight());
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height=getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        measureChildren(width, height);
    }


}
