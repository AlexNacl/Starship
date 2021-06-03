package com.nir.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;


public class Enemy {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 1;
    private final Random random_delay_asteroid = new Random();
    private int maxX;
    private int minX;

    private int maxY;
    private int minY;

    Context context;
    Activity activity;

    private Rect detectCollision;

    public Enemy(Context context, int screenX, int screenY) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;

        this.context = context;

        activity = (Activity) context;
        Random generator = new Random();
        speed = generator.nextInt(5) + 8;
        x = screenX;
        y = generator.nextInt(maxY) - bitmap.getHeight();
        detectCollision = new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void update(int playerSpeed) {
        x -= playerSpeed;
        x -= speed;
        if (x < minX - bitmap.getWidth()) {
            Random generator = new Random();
            speed = generator.nextInt(10) + 8;
            int num = random_delay_asteroid.nextInt(1000);
            num = num + 200;
            x = maxX+num;
            y = generator.nextInt(maxY) - bitmap.getHeight();
        }
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
    }

    public void setX(int x){
        this.x = x;
    }

    public Rect getDetectCollision() {
        return detectCollision;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
