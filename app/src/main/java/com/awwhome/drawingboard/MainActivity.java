package com.awwhome.drawingboard;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private ImageView iv_draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_draw = (ImageView) findViewById(R.id.iv_draw);

        // 1.把bg转化为bitmap
        Bitmap bgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);

        // 2.创建模板
        Bitmap copyBitmap = Bitmap.createBitmap(bgBitmap.getWidth(), bgBitmap.getHeight(), bgBitmap.getConfig());

        // 3.以copyBitmap为模板创建画布
        Canvas canvas = new Canvas(copyBitmap);

        // 4.创建画笔
        Paint paint = new Paint();

        // 5.开始作画
        canvas.drawBitmap(bgBitmap, new Matrix(), paint);

        // 6.将画布显示在控件上
        iv_draw.setImageBitmap(bgBitmap);


    }

}
