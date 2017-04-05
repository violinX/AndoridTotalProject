package com.example.wangalei.myapplication.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wangalei.myapplication.R;

import java.util.ArrayList;

public class ShowDemoDialogActivity extends AppCompatActivity implements OnClickListener {

    private Button showdemo_dialog_1;
    private Button showdemo_dialog_2;
    private Button showdemo_dialog_3;
    private Button showdemo_dialog_4;
    private Button showdemo_dialog_5;
    private Button showdemo_dialog_6;
    private Button showdemo_dialog_7;
    private Button showdemo_dialog_8;
    int yourChoice;//第3个Dialog列表使用，用于记录选择的值。
    ArrayList<Integer> yourChoices = new ArrayList<>();//第4个Dialog列表使用，用于记录多选。
    private AlertDialog menuDialogout;//自定义dialog使用
    private Button bt_cancel;
    private Button bt_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_demo_dialog);
        showdemo_dialog_1 = (Button) findViewById(R.id.showdemo_dialog_1);
        showdemo_dialog_2 = (Button) findViewById(R.id.showdemo_dialog_2);
        showdemo_dialog_3 = (Button) findViewById(R.id.showdemo_dialog_3);
        showdemo_dialog_4 = (Button) findViewById(R.id.showdemo_dialog_4);
        showdemo_dialog_5 = (Button) findViewById(R.id.showdemo_dialog_5);
        showdemo_dialog_6 = (Button) findViewById(R.id.showdemo_dialog_6);
        showdemo_dialog_7 = (Button) findViewById(R.id.showdemo_dialog_7);
        showdemo_dialog_8 = (Button) findViewById(R.id.showdemo_dialog_8);
        showdemo_dialog_1.setText("普通的dialog，取消关闭dialog,确定关闭当前界面。");
        showdemo_dialog_1.setOnClickListener(this);
        showdemo_dialog_2.setText("Dialog中有一个列表，点击列表返回参数。");
        showdemo_dialog_2.setOnClickListener(this);
        showdemo_dialog_3.setText("Dialog中单选列表，默认选中第三项。");
        showdemo_dialog_3.setOnClickListener(this);
        showdemo_dialog_4.setText("Dialog中多选列表，list记录多选值。");
        showdemo_dialog_4.setOnClickListener(this);
        showdemo_dialog_5.setText("这是一个阻止了屏幕点击的等待事件。");
        showdemo_dialog_5.setOnClickListener(this);
        showdemo_dialog_6.setText("这是一个横向进度条，尽头处会自动消失。");
        showdemo_dialog_6.setOnClickListener(this);
        showdemo_dialog_7.setText("一个带有输入框的dialog");
        showdemo_dialog_7.setOnClickListener(this);
        showdemo_dialog_8.setText("一个自定义的dialog，样式根据XML决定，实现按钮的监听");
        showdemo_dialog_8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showdemo_dialog_1:
                dialog_1();
                break;
            case R.id.showdemo_dialog_2:
                dialog_2();
                break;
            case R.id.showdemo_dialog_3:
                dialog_3();
                break;
            case R.id.showdemo_dialog_4:
                dialog_4();
                break;
            case R.id.showdemo_dialog_5:
                dialog_5();
                break;
            case R.id.showdemo_dialog_6:
                dialog_6();
                break;
            case R.id.showdemo_dialog_7:
                dialog_7();
                break;
            case R.id.showdemo_dialog_8:
                dialog_8();
                break;
            case R.id.bt_cancel:
                Toast.makeText(this, "点击取消", Toast.LENGTH_SHORT).show();
                menuDialogout.cancel();
                break;
            case R.id.bt_confirm:
                Toast.makeText(this, "点击确认", Toast.LENGTH_SHORT).show();
                menuDialogout.cancel();
                break;
        }
    }

    protected void dialog_1() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(ShowDemoDialogActivity.this);
        normalDialog.setIcon(R.drawable.show_demo_image_1);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        dialog.dismiss();
                        finish();
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        dialog.dismiss();
                    }
                });
        normalDialog.setNegativeButton("按钮3", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
                Toast.makeText(ShowDemoDialogActivity.this, "几个按钮就看你心情喽", Toast.LENGTH_SHORT).show();
            }
        });
        // 显示
        normalDialog.show();
    }

    protected void dialog_2() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(ShowDemoDialogActivity.this);
        listDialog.setTitle("我是一个列表Dialog");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                Toast.makeText(ShowDemoDialogActivity.this,
                        "你点击了" + items[which],
                        Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }

    protected void dialog_3() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(ShowDemoDialogActivity.this);
        singleChoiceDialog.setTitle("我是一个单选Dialog");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 2,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {
                            Toast.makeText(ShowDemoDialogActivity.this,
                                    "你选择了" + items[yourChoice],
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        singleChoiceDialog.show();
    }

    protected void dialog_4() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        // 设置默认选中的选项，全为false默认均未选中
        final boolean initChoiceSets[] = {false, false, false, false};
        yourChoices.clear();
        AlertDialog.Builder multiChoiceDialog =
                new AlertDialog.Builder(ShowDemoDialogActivity.this);
        multiChoiceDialog.setTitle("我是一个多选Dialog");
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            yourChoices.add(which);
                        } else {
                            yourChoices.remove(which);
                        }
                    }
                });
        multiChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = yourChoices.size();
                        String str = "";
                        for (int i = 0; i < size; i++) {
                            str += items[yourChoices.get(i)] + " ";
                        }
                        Toast.makeText(ShowDemoDialogActivity.this,
                                "你选中了" + str,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        multiChoiceDialog.show();

    }

    protected void dialog_5() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        ProgressDialog waitingDialog =
                new ProgressDialog(ShowDemoDialogActivity.this);
        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    protected void dialog_6() {
    /* @setProgress 设置初始进度
     * @setProgressStyle 设置样式（水平进度条）
     * @setMax 设置进度最大值
     */
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog =
                new ProgressDialog(ShowDemoDialogActivity.this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("我是一个进度条Dialog");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
    /* 模拟进度增加的过程
     * 新开一个线程，每个100ms，进度增加1
     */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 进度达到最大值后，窗口消失
                progressDialog.cancel();
            }
        }).start();
    }

    protected void dialog_7() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(ShowDemoDialogActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(ShowDemoDialogActivity.this);
        inputDialog.setTitle("我是一个输入Dialog").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ShowDemoDialogActivity.this,
                                editText.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    protected void dialog_8() {
        //dialog 不能用Application的Context
        menuDialogout = new AlertDialog.Builder(this, R.style.style_Dialog_Service).create();
        menuDialogout.show();
        Window window = menuDialogout.getWindow();
        window.setContentView(R.layout.activity_show_demo_dialog_custom_notification);
        window.setGravity(Gravity.CENTER); //设置对话框在界面底部显示
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = (this.getWindowManager().getDefaultDisplay().getWidth()) / 4 * 3;  //设置对话框的宽度为屏幕宽 （此处得到的是我一开始获得并存放起来的屏幕宽）
        window.setAttributes(params);//此句代码一定要放在show()后面，否则不起作用
        menuDialogout.setCanceledOnTouchOutside(true);
        bt_cancel = (Button) window.findViewById(R.id.bt_cancel);
        bt_confirm = (Button) window.findViewById(R.id.bt_confirm);
        bt_cancel.setOnClickListener(this);
        bt_confirm.setOnClickListener(this);
    }
}
