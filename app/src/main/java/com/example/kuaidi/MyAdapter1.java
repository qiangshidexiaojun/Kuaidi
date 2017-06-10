package com.example.kuaidi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 李志军 on 2017/2/22.
 */


    public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {

        private ListBean1 mListBean1;

        public MyAdapter1(ListBean1 mListBean1){
            this.mListBean1  = mListBean1;

        }

        @Override
        public MyAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyAdapter1.ViewHolder holder, int position) {
            ListBean1.ListBean listBean= mListBean1.getResult().getList().get(position);
            holder.tvCom.setText(listBean.getDatetime());
            holder.tvNo.setText(listBean.getRemark());
        }

        @Override
        public int getItemCount() {
            return mListBean1.getResult().getList().size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvCom;
            TextView tvNo;

            public ViewHolder(View itemView) {
                super(itemView);
                tvCom = (TextView) itemView.findViewById(R.id.tv_com);
                tvNo = (TextView) itemView.findViewById(R.id.tv_No);

            }
        }
    }


