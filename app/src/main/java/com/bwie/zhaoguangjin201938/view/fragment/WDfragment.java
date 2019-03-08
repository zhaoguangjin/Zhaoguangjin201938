package com.bwie.zhaoguangjin201938.view.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bwie.zhaoguangjin201938.R;

/**
 * @Auther: zh
 * @Date: 2019/3/8 14:01
 * @Description: :${赵光金}
 */
public class WDfragment extends Fragment {

    private ImageView woimg;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wdfragment, container, false);
        woimg = view.findViewById(R.id.wodimg);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float translationY = woimg.getTranslationY();
                ObjectAnimator translationY1 = ObjectAnimator.ofFloat(woimg, "translationY", 0, 300, 0);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(woimg, "alpha", 1f, 0.3f, 1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(translationY1).with(alpha);
                animatorSet.setDuration(5000);
                animatorSet.start();
            }
        });
        return view;
    }
}
