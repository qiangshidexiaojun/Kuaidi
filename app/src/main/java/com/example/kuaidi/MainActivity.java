package com.example.kuaidi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtcom, txtno;
    private Button btncom, btnno;
    private RecyclerView recyclerView;
    private MyAdapter mMyAdapter;
    private MyAdapter1 mMyAdapter1;
    private List<ListBean.ResultBean> list = new ArrayList<ListBean.ResultBean>();
    private List<ListBean1.ResultBean> list1 = new ArrayList<ListBean1.ResultBean>();
    String urlstr = "http://v.juhe.cn/exp/com";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new ListBean.ResultBean());


        txtcom = (EditText) findViewById(R.id.txtcom);
        txtno = (EditText) findViewById(R.id.txtno);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        btncom = (Button) findViewById(R.id.btncom);
        btnno = (Button) findViewById(R.id.btnno);

        btncom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        kuaidiDemo.getRequest2();
                        mMyAdapter = new MyAdapter(kuaidiDemo.getListBean());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(mMyAdapter);
                                mMyAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();

            }
        });

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String com = txtcom.getText().toString();
                final String no = txtno.getText().toString();
                if (com.isEmpty() || no.isEmpty()) {
                    Toast.makeText(MainActivity.this, "快递公司编号或快递订单号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        kuaidiDemo.getRequest1(com, no);
                        mMyAdapter1 = new MyAdapter1(kuaidiDemo.getListBean1());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(mMyAdapter1);
                                mMyAdapter1.notifyDataSetChanged();
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
