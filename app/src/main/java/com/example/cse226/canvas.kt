package com.example.cse226

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.ArcShape
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.CircularPropagation
import android.widget.ImageView
import androidx.core.view.doOnLayout
import androidx.core.view.doOnPreDraw
import com.google.android.material.canvas.CanvasCompat

class canvas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas)

        val bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        var shapeDrawable: ShapeDrawable
        //rectangle pos
        var lt = 100
        var tp = 180
        var rt = 500
        var bt = 500

        // draw rectangle shape to canvas
        shapeDrawable = ShapeDrawable(ArcShape(50.toFloat(), 60.toFloat()))
        shapeDrawable.setBounds(lt, tp, rt, bt)
        shapeDrawable.paint.setColor(Color.parseColor("#ef629f"))
        shapeDrawable.draw(canvas)

        val img = findViewById<ImageView>(R.id.imageV)
//        img.drawingTime = 15
//        {
        img.background = BitmapDrawable(resources, bitmap)
//        }

    }
}