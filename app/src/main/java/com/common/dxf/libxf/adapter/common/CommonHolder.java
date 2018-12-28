package com.common.dxf.libxf.adapter.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author dxf
 * @date 2018/12/28
 * @Description 通用ViewHolder
 */
public class CommonHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private Context mContext;
    private int mPosition;

    public CommonHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
        mContext = itemView.getContext();
    }

    public static CommonHolder get(ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        CommonHolder holder = new CommonHolder(itemView);
        return holder;
    }

    /**
     * @date 2018/12/21
     * @author dxf
     * @Description 根据ViewId获取view
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置当前item的position值
     */
    public void updatePosition(int position) {
        mPosition = position;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 获取当前item的position值
     */
    public int getMPosition() {
        return mPosition;
    }

    /**
     * @date 2018/12/21
     * @author dxf
     * @Description 设置TextView文本信息
     */
    public CommonHolder setText(int id, String content) {
        TextView textView = itemView.findViewById(id);
        textView.setText(content);
        return this;
    }

    /**
     * @date 2018/12/21
     * @author dxf
     * @Description 设置TextView文本信息
     */
    public CommonHolder setText(int id, int content) {
        TextView textView = itemView.findViewById(id);
        textView.setText(content);
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置TextView的字体颜色
     */
    public CommonHolder setTextColor(int viewId, int colorId) {
        TextView view = getView(viewId);
        view.setTextColor(ContextCompat.getColor(mContext, colorId));
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置控件的显示和隐藏
     */
    public CommonHolder setViewShowOrGone(int viewId, int show) {
        View view = getView(viewId);
        view.setVisibility(show);
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置控件的图片背景
     */
    public CommonHolder setViewBackgroundForDrawableId(int viewId, int drawableId) {
        View view = getView(viewId);
        view.setBackgroundResource(drawableId);
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置控件的颜色背景
     */
    public CommonHolder setViewBackgroundForColor(int viewId, int colorId) {
        View view = getView(viewId);
        view.setBackgroundColor(ContextCompat.getColor(mContext, colorId));
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置ImageView的本地图片显示
     */
    public CommonHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 为ImageView设置图片
     */
    public CommonHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置某一个按钮的点击事件
     */
    public CommonHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * @date 2018/12/28
     * @author dxf
     * @Description 设置某一个按钮的点击事件
     */
    public CommonHolder setOnItemClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
        return this;
    }
}

