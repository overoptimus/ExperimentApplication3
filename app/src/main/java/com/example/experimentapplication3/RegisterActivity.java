package com.example.experimentapplication3;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

    private final String[] sex_Item = new String[]{"男", "女"};
    private final String[] hobby_Item = new String[]{"听歌", "看书", "旅游"};
    int mYear;
    int mMonth;
    int mDay;

    //初始化各控件
    private EditText r_Username;
    private EditText r_Password;
    private EditText r_Email;
    private EditText r_Sex;
    private EditText r_Hobby;
    private EditText r_Birth;

    //初始化按钮
    private Button r_register_bt;
    private Button r_reset_bt;
    //private Button r_back_bt;
    private ImageView r_back_bt;


    private CheckBox music;
    private CheckBox book;
    private CheckBox tourism;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //隐藏自带的标题栏
//        ActionBar actionBar = getSupportActionBar();
//        if(actionBar != null){
//            actionBar.hide();
//        }


        r_Username = (EditText) findViewById(R.id.r_username);
        r_Password = (EditText) findViewById(R.id.r_password);
        r_Email = (EditText) findViewById(R.id.r_email);
        r_Sex = (EditText) findViewById(R.id.r_sex);
        r_Hobby = (EditText) findViewById(R.id.r_hobby);
        r_Birth = (EditText) findViewById(R.id.r_birth);
        r_register_bt = (Button) findViewById(R.id.r_register_button);
        r_reset_bt = (Button) findViewById(R.id.reset_button);
        r_back_bt = (ImageView) findViewById(R.id.back);
//        music = (CheckBox)findViewById(R.id.music);
//        book = (CheckBox) findViewById(R.id.book);
//        tourism = (CheckBox) findViewById(R.id.tourism);

        r_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.this.finish();
            }
        });

        r_Birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this);
//                datePickerDialog.create();
//                datePickerDialog.show();


                Calendar ca = Calendar.getInstance();
                mYear = ca.get(Calendar.YEAR);
                mMonth = ca.get(Calendar.MONTH);
                mDay = ca.get(Calendar.DAY_OF_MONTH);

                new DatePickerDialog(RegisterActivity.this, DatePickerDialog.THEME_HOLO_LIGHT,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        mYear = i;
                        mMonth = i1;
                        mDay = i2;
                        String days;
                        if (mMonth + 1 < 10) {
                            if (mDay < 10) {
                                days = new StringBuffer().append(mYear).append("年").append("0").
                                        append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                            } else {
                                days = new StringBuffer().append(mYear).append("年").append("0").
                                        append(mMonth).append("月").append(mDay).append("日").toString();
                            }

                        } else {
                            if (mDay < 10) {
                                days = new StringBuffer().append(mYear).append("年").
                                        append(mMonth + 1).append("月").append("0").append(mDay).append("日").toString();
                            } else {
                                days = new StringBuffer().append(mYear).append("年").
                                        append(mMonth + 1).append("月").append(mDay).append("日").toString();
                            }

                        }
                        r_Birth.setText(days);
                    }
                }, mYear, mMonth, mDay).show();

                /**
                 * 通过弹出框来显示日期进行选择
                 * 通过setView()来载入bir_date布局文件进行选择
                 */
//                AlertDialog.Builder builder3 = new AlertDialog.Builder(RegisterActivity.this).setTitle("出生日期").setView(R.layout.bir_date)
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                DatePicker datePicker =  (DatePicker) findViewById(R.id.datepicker);
//                                Log.d("tag", String.valueOf(datePicker.getMaxDate()));
//                                Integer year = datePicker.getYear();
//                                Log.d("tag", "");
//                                Integer month = datePicker.getMonth();
//                                Integer day = datePicker.getDayOfMonth();
//                                String y = year.toString();
//                                String m = month.toString();
//                                String d = day.toString();
//                                String date1 = y + "年" + m + "月" + d + "日";
//                                r_Birth.setText(date1);
//                            }
//                        });
//                builder3.create();
//                builder3.show();
            }
        });

        r_Sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(RegisterActivity.this);
                builder1.setTitle("性别");
                builder1.setSingleChoiceItems(sex_Item, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sex_click = sex_Item[i];
                        r_Sex.setText(sex_click);
//                        Runtime runtime = Runtime.getRuntime();
//                        runtime.exec();
//                        onBackPressed();
                    }
                });
                builder1.setPositiveButton("确定", null);
                builder1.create();
                builder1.show();
            }
        });
        //爱好无法显示出来
        r_Hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i;
                final boolean[] selected = new boolean[]{false, false, false};
                AlertDialog.Builder builder2 = new AlertDialog.Builder(RegisterActivity.this);
                builder2.setTitle("爱好");
                builder2.setMultiChoiceItems(hobby_Item, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        selected[i] = b;
                    }
                });
                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String r = "";
                        for (i = 0; i < 3; i++) {
                            if (selected[i]) {
                                r = r + " " + hobby_Item[i];
                            }
                        }
                        r_Hobby.setText(r);
                    }
                });
//                builder2.setView(R.layout.hobbychoose);
//                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                String r = "";
//                                if(music.isChecked()) {
//                                    r = r + "," + music.getText();
//                                }
//                                if(book.isChecked()) {
//                                    r = r + "," + book.getText();
//                                }
//                                if(tourism.isChecked()) {
//                                    r = r + "," + tourism.getText();
//                                }
//                                r_Hobby.setText(r);
//                            }
//                        });
                builder2.create();
                builder2.show();
            }
        });

        /**
         * 还未添加点击注册按钮后的操作
         *
         */
        r_register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击注册按钮
                final Users register_user = new Users();
                register_user.setUsername(r_Username.getText().toString());
                register_user.setPassword(r_Password.getText().toString());
                register_user.setEmail(r_Email.getText().toString());
                register_user.setBir_date(r_Birth.getText().toString());
                register_user.setHobby(r_Hobby.getText().toString());
                register_user.setSex(r_Sex.getText().toString());
                register_user.signUp(new SaveListener<Users>() {

                    @Override
                    public void done(Users users, BmobException e) {
                        if (e == null) {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败" + e, Toast.LENGTH_SHORT).show();
                            Log.e("TAG", "done: ", e);
                        }
                    }
                });
            }
        });

        r_reset_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击置空按钮
                r_Username.setText("");
                r_Password.setText("");
                r_Email.setText("");
                r_Sex.setText("");
                r_Hobby.setText("");
                r_Birth.setText("");
            }
        });

    }

    public static void ActionStart(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }


}
