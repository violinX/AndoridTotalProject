package com.example.wangalei.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wangalei.myapplication.Activity.ShowDemoRecyclerViewActivity;
import com.example.wangalei.myapplication.R;

/**
 * Created by JD on 2017/6/12.
 */

public class DemoRecyclerAdapter extends RecyclerView.Adapter<DemoRecyclerAdapter.MyViewHolder> {
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                ShowDemoRecyclerViewActivity.this).inflate(R.layout.activity_show_demo_recycler_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
        }
    }
}
