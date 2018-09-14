package com.example.first;

import android.app.ActionBar;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TouchActivity extends AppCompatActivity implements View.OnTouchListener {
    private ImageView image;
    private TextView text_view;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        image = findViewById(R.id.image);
        text_view = findViewById(R.id.text_view);
        image.setOnTouchListener(this);
    }

    private float deltaX;
    private float deltaY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getRawX();
        float y = event.getY();
       // 更新坐标的值
       // text_view.setText("坐标位置:"+x+","+y);
        text_view.setText(getResources().getString(R.string.location,x,y));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();
        //当触屏按下的时候，计算所在点的x，y的偏移
        //当触点移动时，计算与按下时的位置的偏移，将图片的参数LayoutParams更改为移动后的偏移
        // 重绘图片
        //先获得可视区域的大小，然后做判断
        Rect rect=new Rect();
        getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(rect);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                deltaX = x - params.leftMargin;
                deltaY = y - params.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                float distanceX = x - deltaX;
                float distanceY = y - deltaY;
                //判断是否超出边界
                if(distanceX>=rect.left && distanceX<=rect.right && distanceY>=rect.top)
                params.leftMargin = (int) distanceX;
                params.topMargin = (int) distanceY;
                v.setLayoutParams(params);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        v.invalidate();
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis() - startTime>2000){
                Toast.makeText(TouchActivity.this,"再按一次退出",Toast.LENGTH_SHORT).show();
                startTime= System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
        }
        return true;
    }
}
