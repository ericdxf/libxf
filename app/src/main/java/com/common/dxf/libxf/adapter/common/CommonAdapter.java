package com.common.dxf.libxf.adapter.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author dxf
 * @date 2018/11/30
 * @Description 中转行李核销Adapter
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonHolder> {
    private List<T> list;
    private int layoutId;

    public CommonAdapter(int layoutId, List<T> list) {
        this.list = list;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public CommonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
        CommonHolder holder = new CommonHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommonHolder holder, int position) {
        onBind(holder, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public abstract void onBind(CommonHolder commonHolder, T t);

    public void notifyChange(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
