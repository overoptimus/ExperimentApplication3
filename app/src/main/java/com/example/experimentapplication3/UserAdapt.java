package com.example.experimentapplication3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by 常江 on 2017/11/19.
 */

public class UserAdapt extends RecyclerView.Adapter<UserAdapt.ViewHolder> {

    private Context mContext;
    private List<Users> mList;


    public UserAdapt(Context mContext, List<Users> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View userView;
        TextView L_username;
        TextView L_birth;
        TextView L_email;
        TextView L_sex;
        TextView L_hobby;


        public ViewHolder(View itemView) {
            super(itemView);

            userView = itemView;
            L_username = userView.findViewById(R.id.L_username);
            L_birth = userView.findViewById(R.id.L_birth);
            L_email = userView.findViewById(R.id.L_email);
            L_sex = userView.findViewById(R.id.L_sex);
            L_hobby = userView.findViewById(R.id.L_hobby);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Users users = mList.get(position);
        holder.L_username.setText(users.getUsername());
        holder.L_birth.setText(users.getBir_date());
        holder.L_hobby.setText(users.getHobby());
        holder.L_sex.setText(users.getSex());
        holder.L_email.setText(users.getEmail());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
