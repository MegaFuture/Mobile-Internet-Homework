package com.example.homework2.Exercise2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.homework2.R;

    /**
     * 作业2：一个抖音笔试题：统计页面所有view的个数
     * Tips：ViewGroup有两个API
     * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
     * 用一个TextView展示出来
     */
public class Exercise2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        TextView showNum = findViewById(R.id.tv_center);
        View v = findViewById(R.id.rootView);
        showNum.setText(Integer.toString(getAllChildViewCount(v)-1));
    }

    public int getAllChildViewCount(View view) {
        int viewCount = 1;
        if (view==null) return 0;
        if (view instanceof ViewGroup)
            for (int i=0; i<((ViewGroup) view).getChildCount(); i++)
                viewCount+=getAllChildViewCount(((ViewGroup) view).getChildAt(i));
        else return 1;
        return viewCount;
    }
}

