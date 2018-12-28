package com.common.dxf.libxf.adapter.commonEg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author 崔健伟
 * @version V1.0
 * @Title: CommonAdapter.java
 * @Package com.yuwei.recyclerviewdemo
 * @Description: 最底层的抽象adapter
 * @date 2016/11/20 15:06
 */
public abstract class CommonAdapter1<T> extends RecyclerView.Adapter<ViewHolder> {
    public static final String TAG = "CommonAdapter";
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter1(Context mContext, int mLayoutId, List<T> mDatas) {
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, parent, mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        if (mDatas.size() != 0) {
            if (position == mDatas.size())
                convert(holder, mDatas.get(position - 1));
            else
                convert(holder, mDatas.get(position));
        }
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * @author: cuijianwei
     * @time: 2016/11/21 14:31
     * @desc: 抽象的对外方法，在activity中进行实现
     **/
    public abstract void convert(ViewHolder holder, T t);
}
