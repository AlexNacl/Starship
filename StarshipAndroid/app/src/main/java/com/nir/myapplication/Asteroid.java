package com.nir.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Asteroid {
    private final Random random_delay_asteroid = new Random();
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 1;

    private int maxX;
    private int minX;

    private int maxY;
    private int minY;
    private Rect detectCollision;

    public Asteroid(Context context, int screenX, int screenY) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.asteroid);
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        Random generator = new Random();
        speed = generator.nextInt(8) + 12;
        x = screenX;
        y = generator.nextInt(maxY) - bitmap.getHeight();
        detectCollision = new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }

    public void update(int playerSpeed) {
        x -= playerSpeed;
        if (speed <=20){
            x -= speed;
        } else {
            x -= 20;
        }
        if (x < minX - bitmap.getWidth()) {
            Random generator = new Random();
            speed = generator.nextInt(10) + 10;
            int num = random_delay_asteroid.nextInt(3000);
            num = num + 200;
            x = maxX+num;
            y = generator.nextInt(maxY) - bitmap.getHeight();
        }

        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
    }

    public Rect getDetectCollision() {
        return detectCollision;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setSpeed(int up) {this.speed += up;}
}
