package com.example.experimentapplication3;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

public class Features extends AppCompatActivity {

    private RecyclerView user_listview;
    private LinearLayoutManager mLayoutManager;
    private UserAdapt mAdapter;
    private Button add;
    private Button delete;
    private Button modify;
    private Button select;
//    private List<Users> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        modify = (Button) findViewById(R.id.modify);
        select = (Button) findViewById(R.id.select);
        user_listview = (RecyclerView) findViewById(R.id.users_listview);
        mLayoutManager = new LinearLayoutManager(Features.this);
        user_listview.setLayoutManager(mLayoutManager);
//        usersList.addAll(GetUsersList.initUser());
//        mAdapter = new UserAdapt(Features.this,GetUsersList.initUser(Features.this,user_listview));
        GetUsersList.initUser(Features.this,user_listview);
//        user_listview.setAdapter(mAdapter);



//        initUser();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, Features.class);
        context.startActivity(intent);
    }

//    private void initUser() {
//        String sql = "select * from _User";
//        new BmobQuery<Users>().doSQLQuery(sql, new SQLQueryListener<Users>() {
//            @Override
//            public void done(BmobQueryResult<Users> bmobQueryResult, BmobException e) {
//                if (e == null) {
//                    usersList = (List<Users>) bmobQueryResult.getResults();
//                    if (usersList != null && usersList.size() > 0) {
//                        Toast.makeText(Features.this, "查询成功,返回数据", Toast.LENGTH_SHORT).show();
//               /*         usersList.clear();
//                        usersList.addAll();
//                        mAdapter.notifyDataSetChanged();*/
//                        mAdapter = new UserAdapt(Features.this, usersList);
//                        user_listview.setAdapter(mAdapter);
//                        Log.i("smile", "数据为 " + usersList.get(0).getUsername());
//                    } else {
//                        Toast.makeText(Features.this, "查询成功,无数据返回", Toast.LENGTH_SHORT).show();
//                        Log.i("smile", "查询成功,无数据返回 ");
//                    }
//                } else {
//                    Log.i("smile", "查询失败.   错误码" + e.getErrorCode() + "错误描述:" + e.getMessage());
//                }
//            }
//        });
//    }

}
