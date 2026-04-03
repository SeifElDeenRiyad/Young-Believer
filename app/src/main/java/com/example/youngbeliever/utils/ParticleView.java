// ParticleView.java
package com.example.youngbeliever.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

public class ParticleView extends View
{

    private static class Particle
    {
        float x, y, radius, speedY, alpha;
        Particle(float x, float y, float radius, float speedY, float alpha)
        {
            this.x = x; this.y = y; this.radius = radius; this.speedY = speedY; this.alpha = alpha;
        }
    }

    private final ArrayList<Particle> particles = new ArrayList<>();
    private final Paint paint = new Paint();
    private final Random random = new Random();

    public ParticleView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        paint.setColor(0xFFFFFFFF); // white
        paint.setStyle(Paint.Style.FILL);
        initParticles();
    }

    private void initParticles()
    {
        for (int i = 0; i < 50; i++)
        {
            float x = random.nextInt(getWidth() + 1);
            float y = -random.nextInt(300); // start above
            float radius = 5 + random.nextFloat() * 8;
            float speedY = 2 + random.nextFloat() * 4;
            float alpha = 0.5f + random.nextFloat() * 0.5f;
            particles.add(new Particle(x, y, radius, speedY, alpha));
        }
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas)
    {
        super.onDraw(canvas);
        if (particles.isEmpty()) initParticles();
        for (Particle p : particles) {
            paint.setAlpha((int)(p.alpha * 255));
            canvas.drawCircle(p.x, p.y, p.radius, paint);
            p.y += p.speedY;
            if (p.y + p.radius > getHeight())
            {
                p.y = -p.radius;
                p.x = random.nextInt(getWidth() + 1);
            }
        }
        postInvalidateOnAnimation();
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        particles.clear();
        for (int i = 0; i < 50; i++) {
            float x = random.nextInt(w); // full width now
            float y = -random.nextInt(h / 2); // start above
            float radius = 5 + random.nextFloat() * 8;
            float speedY = 2 + random.nextFloat() * 4;
            float alpha = 0.5f + random.nextFloat() * 0.5f;
            particles.add(new Particle(x, y, radius, speedY, alpha));
        }
    }
}