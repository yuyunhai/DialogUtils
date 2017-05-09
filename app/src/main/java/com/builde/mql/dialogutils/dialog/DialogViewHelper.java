package com.builde.mql.dialogutils.dialog;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

 /**
  * Created by 13661 on 2017/5/5.
  */
 class DialogViewHelper {
   private View mContentView = null;
  //防止霸气侧漏
   private SparseArray<WeakReference<View>> mViews;

   public DialogViewHelper(Context mContext, int mViewLayoutResId) {
     this();
     mContentView = LayoutInflater.from(mContext).inflate(mViewLayoutResId, null);
   }

   public DialogViewHelper() {
     mViews = new SparseArray<>();
   }

  //设置布局
   public void setContentView(View mView) {
     this.mContentView = mView;
   }

  //设置文本
  public void setText(int viewId, CharSequence text) {
    TextView textView = getView(viewId);
       if (textView != null) {
        textView.setText(text);
       }
    }

  public <T extends View> T getView(int viewId) {
      //侧漏的问题
      WeakReference<View> viewReference = mViews.get(viewId);
 //  View view=mViews.get(viewId).get();
     View view = null;
     if (viewReference != null) {
         view = viewReference.get();
     }
     if (view == null) {
        view = mContentView.findViewById(viewId);
        if (view != null) {
        mViews.put(viewId, new WeakReference<View>(view));
        }
     }
     return (T) view;
   }

    //设置点击事件
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
       View view = getView(viewId);
       if (view != null) {
          view.setOnClickListener( listener);
       }
    }

   //获取Content内容的View
    public View getContentView() {
     return mContentView;
   }
 }
