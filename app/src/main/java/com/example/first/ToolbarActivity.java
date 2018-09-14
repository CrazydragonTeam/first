package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class ToolbarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar = findViewById(R.id.my_toolbar);
        //给toolbar加载菜单
        //setSupportActionBar(toolbar);//需要重写onCreateOptionMenu()和onOptionItemsSelected()
        toolbar.inflateMenu(R.menu.demo);//需要设置菜单选择的事件监听器
    }
}
