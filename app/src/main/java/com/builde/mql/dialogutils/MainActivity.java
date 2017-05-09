package com.builde.mql.dialogutils;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.builde.mql.dialogutils.dialog.AlertDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        createNativeDialog();

    }
    public void createOwnerDialog(){
        final AlertDialog dialog= new AlertDialog.Builder(this)
                .setContentView(R.layout.detail_comment_dialog)
                .setText(R.id.tv_title,"这是标题")
                .setCancelable(true)
                .addDefaultAnimation()
                .show();
//        dialog.setOnClickListener(R.id.btn_cancel, new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
//                dialog.cancel();
//            }
//        });
//        dialog.setOnClickListener(R.id.btn_sure, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"确定",Toast.LENGTH_SHORT).show();
//                dialog.cancel();
//            }
//        });
    }
    public void createNativeDialog(){
        //创建Builder
//        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);

//        alertDialogBuilder.setTitle("安卓dialog");//设置标题
//        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);//设置图表
//        alertDialogBuilder.setMessage("安卓dialog");//设置显示文本
//
//        alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(),"确定",Toast.LENGTH_SHORT).show();
//            }
//        });
//        alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(), "取消", Toast.LENGTH_SHORT).show();
//            }
//        });
    /*设置下方按钮*/
        //alertDialogBuilder.setPositiveButton();
        //  alertDialogBuilder.setNegativeButton();
        // alertDialogBuilder.setNeutralButton();
    /*对话框内容区域的设置提供了多种方法*/
        //alertDialogBuilder.setItems();//设置对话框内容为简单列表项
        //alertDialogBuilder.setSingleChoiceItems();//设置对话框内容为单选列表项
        //alertDialogBuilder.setMultiChoiceItems();//设置对话框内容为多选列表项
        //alertDialogBuilder.setAdapter();//设置对话框内容为自定义列表项
//        alertDialogBuilder.setView(R.layout.my_dialog);//设置对话框内容为自定义View
        //设置对话框是否可取消 默认为true
//        alertDialogBuilder.setCancelable(false);
//        alertDialogBuilder.setCancelListener(onCancelListener)
//        alertDialogBuilder.show();
//        alertDialog.show();
    }
    public void click(View view){
        createOwnerDialog();
    }
}
