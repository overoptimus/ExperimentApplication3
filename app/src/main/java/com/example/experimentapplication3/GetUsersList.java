package com.example.experimentapplication3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

/**
 * Created by 常江 on 2017/11/20.
 *
 * 封装一个查询数据库的方法
 */

public class GetUsersList {
    public static List<Users> list = new ArrayList<>();
    public static UserAdapt mAdapter;


    public static List<Users> initUser(final Context context, final RecyclerView user_listview) {
        String sql = "select * from _User";
        new BmobQuery<Users>().doSQLQuery(sql, new SQLQueryListener<Users>() {
            @Override
            public void done(BmobQueryResult<Users> bmobQueryResult, BmobException e) {
                if (e == null) {
                    list = (List<Users>) bmobQueryResult.getResults();
                    if (list != null && list.size() > 0) {
//                        Toast.makeText(context, "查询成功,返回数据", Toast.LENGTH_SHORT).show();
               /*         usersList.clear();
                        usersList.addAll();
                        mAdapter.notifyDataSetChanged();*/
                        mAdapter = new UserAdapt(context, list);
                        user_listview.setAdapter(mAdapter);
                        Log.i("smile", "数据为 " + list.get(0).getUsername());
                    } else {
//                        Toast.makeText(context, "查询成功,无数据返回", Toast.LENGTH_SHORT).show();
                        Log.i("smile", "查询成功,无数据返回 ");
                    }
                } else {
                    Log.i("smile", "查询失败.   错误码" + e.getErrorCode() + "错误描述:" + e.getMessage());
                }
            }
        });
        return list;
    }


}
