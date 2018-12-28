package com.common.dxf.libxf.adapter.commonEg;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * @author 崔健伟
 * @version V1.0
 * @Title: ViewHolder.java
 * @Package com.yuwei.recyclerviewdemo
 * @Description: 万能的ViewHolder
 * @date 2016/11/20 15:01
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private int mPosition;

    public ViewHolder(Context context, View itemView, ViewGroup parent) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    public static ViewHolder get(Context context, ViewGroup parent, int layoutId) {

        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        ViewHolder holder = new ViewHolder(context, itemView, parent);
        return holder;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 通过viewId获取控件
     **/
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 设置TextView的文本
     **/
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 设置TextView的文本
     **/
    public ViewHolder setTextHtml(int viewId, String content) {
        TextView tv = getView(viewId);
        tv.setText(Html.fromHtml(content));
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 设置TextView的字体颜色
     **/
    public ViewHolder setTextColor(int viewId, int colorId) {
        TextView view = getView(viewId);
        view.setTextColor(ContextCompat.getColor(mContext, colorId));
        return this;
    }

    public ViewHolder setProgressPro(int viewId, int currentount, int maxcount) {
        ProgressBar view = getView(viewId);

        view.setMax(maxcount);
        view.setProgress(currentount);
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 设置控件的显示和隐藏
     **/
    public ViewHolder setViewShowOrGone(int viewId, int show) {
        View view = getView(viewId);
        view.setVisibility(show);
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 设置控件的图片背景
     **/
    public ViewHolder setViewBackgroundForDrawableId(int viewId, int drawableId) {
        View view = getView(viewId);
        view.setBackgroundResource(drawableId);
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 设置控件的颜色背景
     **/
    public ViewHolder setViewBackgroundForColor(int viewId, int colorId) {
        View view = getView(viewId);
        view.setBackgroundColor(ContextCompat.getColor(mContext, colorId));
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 设置ImageView的本地图片显示
     **/
    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:46
     * @desc: 为ImageView设置图片
     **/
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }


    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:47
     * @desc: 设置某一个按钮的点击事件
     **/
    public ViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * @date 创建时间: 2016/12/30
     * @author XiaoFeng
     * @Description 设置itemView的点击事件
     */
    public ViewHolder setOnItemClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
        return this;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:47
     * @desc: 设置当前item的position值
     **/
    public void updatePosition(int position) {
        mPosition = position;
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:47
     * @desc: 获取当前item的position值
     **/
    public int getMPosition() {
        return mPosition;
    }

    /**
     * @date 创建时间: 2017/1/11
     * @author XiaoFeng
     * @Description 设置view Tag
     */
    public ViewHolder setViewTag(int viewId, String tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * @date 创建时间: 2017/1/11
     * @author XiaoFeng
     * @Description 获取view Tag
     */
    public String getViewTag(int viewId) {
        View view = getView(viewId);
        return (String) view.getTag();
    }
}
