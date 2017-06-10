package com.example.kuaidi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 李志军 on 2017/2/22.
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ListBean mListBean ;

    public MyAdapter(ListBean mListBean){
        this.mListBean = mListBean;
    }
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comno_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        ListBean.ResultBean resultBean = mListBean.getResult().get(position);
        holder.mTextViewCom.setText(resultBean.getCom());
        holder.mTextViewNo.setText(resultBean.getNo());
    }

    @Override
    public int getItemCount() {
        return mListBean.getResult().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextViewCom;
        TextView mTextViewNo;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewCom  = (TextView) itemView.findViewById(R.id.tv_com);
            mTextViewNo = (TextView) itemView.findViewById(R.id.tv_No);
        }
    }
}

