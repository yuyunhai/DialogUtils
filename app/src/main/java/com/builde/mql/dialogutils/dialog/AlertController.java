package com.builde.mql.dialogutils.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by 13661 on 2017/5/5.
 */

 class AlertController {
    private AlertDialog mDialog;
    private Window mWindow;
    private DialogViewHelper mViewHelper;
    public AlertController(AlertDialog Dialog, Window window) {
        this.mDialog=Dialog;
        this.mWindow=window;
    }

    public AlertDialog getDialog() {
        return mDialog;
    }

    
    public Window getWindow() {
        return mWindow;
    }

    //设置文本
    public void setText(int viewId, CharSequence text) {
        mViewHelper.setText(viewId,text);
    }
    public <T extends View> T getView(int viewId) {

        return mViewHelper.getView(viewId);
    }

    //设置点击事件
    public void setOnClickListener(int viewId,View.OnClickListener listener) {
        mViewHelper.setOnClickListener(viewId,listener);
    }

    public void setViewHelper(DialogViewHelper mViewHelper) {
        this.mViewHelper = mViewHelper;
    }

    public static class AlertParams{
        public Context mContext;
        public int mThemeResId;
        //点击空白是否可以取消
        public boolean mCancelable=true;
        //dialog 取消监听
        public DialogInterface.OnCancelListener mOnCancelListener;
        //dialog消失监听
        public DialogInterface.OnDismissListener mOnDismissListener;
        //dialog按键监听
        public DialogInterface.OnKeyListener mOnKeyListener;
        //dialog显示的布局
        public View mView;
        //dialog显示的布局的ID
        public int mViewLayoutResId;
        //存放字体的修改
        public SparseArray<CharSequence>mTextArray=new SparseArray<>();
        //存放点击事件
        public SparseArray<View.OnClickListener>mClickArray=new SparseArray<>();
        //宽度
        public int mWidth= ViewGroup.LayoutParams.WRAP_CONTENT;
        //高度
        public int mHeight=ViewGroup.LayoutParams.WRAP_CONTENT;
        //动画
        public int mAnimations=0;
        //位置
        public int mGravity= Gravity.CENTER;

        public AlertParams(Context context, int themeResId) {
            this.mContext=context;
            this.mThemeResId=themeResId;
        }

        public void apply(AlertController mAlert) {
            //1.设置dialog布局
            DialogViewHelper viewHelper=null;
            if (mViewLayoutResId!=0){
                viewHelper=new DialogViewHelper(mContext,mViewLayoutResId);
            }
            if (mView!=null){
                viewHelper=new DialogViewHelper();
                viewHelper.setContentView(mView);
            }
            if (viewHelper==null){
                throw  new IllegalArgumentException("请设置布局，调用setContView()");
            }
            //给dialog设置布局\
            mAlert.getDialog().setContentView(viewHelper.getContentView());
            //设置AlertController的辅助类
            mAlert.setViewHelper(viewHelper);
            //2设置文本
            int textArraySize=mTextArray.size();
            for (int i=0;i<textArraySize;i++ ){
                mAlert.setText(mTextArray.keyAt(i),mTextArray.valueAt(i));
            }

            //3设置点击事件
            int clickArraySize=mClickArray.size();
            for (int i=0;i<clickArraySize;i++ ){
                mAlert.setOnClickListener(mClickArray.keyAt(i), mClickArray.valueAt(i));
            }

            Window window=mAlert.getWindow();
            window.setGravity(mGravity);

            //4.设置动画
            if (mAnimations!=0){
                window.setWindowAnimations(mAnimations);
            }
            //设置宽高
           WindowManager.LayoutParams params= window.getAttributes();
           params.width=mWidth;
           params.height=mHeight;
           window.setAttributes(params);
        }
    }
}
