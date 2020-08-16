package com.example.animation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var animFram: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //淡出
        fadeoutBtn.setOnClickListener {
            fadeAnimCode(1f,0f)
        }
        //淡入
        fadeinBtn.setOnClickListener {
            fadeAnimCode(0f,1f)
        }
        moveBtn.setOnClickListener {
            moveAnimCode()
        }
        rotateBtn.setOnClickListener {
            rotateAnimCode()
        }
        scaleBtn.setOnClickListener {
            scaleAnimCode()
        }
        setBtn.setOnClickListener {
            setAnimCode()
        }
//        animationView.setOnClickListener {
//            if (animFram.isRunning){
//                animFram.stop()
//            }else{
//                animFram.start()
//            }
//        }
    }

    private fun fadeAnimXml(id:Int){
    (AnimationUtils.loadAnimation(this,id) as AlphaAnimation).also {
        View.startAnimation(it)
    }

}
    private fun fadeAnimCode(from:Float,to:Float){
        AlphaAnimation(from,to).apply {
            duration = 1000
            repeatCount = 2
            fillAfter = true
            repeatMode = Animation.REVERSE
            setAnimationListener(object :Animation.AnimationListener{
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    Log.v("cu","end")
                }

                override fun onAnimationStart(p0: Animation?) {

                }

            })
        }.also {
            View.startAnimation(it)
        }
    }

    private fun moveAnimXml(){
        (AnimationUtils.loadAnimation(this,R.anim.move_anim) as TranslateAnimation).also {
            View.startAnimation(it)
        }

    }
    private fun moveAnimCode(){
        TranslateAnimation(Animation.RELATIVE_TO_PARENT,0f,
                           Animation.RELATIVE_TO_PARENT,0.5f,
                            Animation.RELATIVE_TO_PARENT,0f,
            Animation.RELATIVE_TO_PARENT,0.5f
        ).apply {
            duration = 1000
            fillAfter = true
        }.also {
            View.startAnimation(it)
        }
    }

    private fun rotateAnimXml(){
        (AnimationUtils.loadAnimation(this,R.anim.rotate_anim) as RotateAnimation).also {
            View.startAnimation(it)
        }
    }
    private fun rotateAnimCode(){
        RotateAnimation(0f,360f,
                        Animation.RELATIVE_TO_SELF,1f,
                        Animation.RELATIVE_TO_PARENT,1f
            ).also {
            it.duration = 1000
            it.fillAfter = true
            View.startAnimation(it)
        }
    }

    private fun scaleAnimXml(){
        (AnimationUtils.loadAnimation(this,R.anim.scale_anim)as ScaleAnimation).also {
            View.startAnimation(it)
        }
    }
    private fun scaleAnimCode(){
        ScaleAnimation(1f,2f,1f,2f,
            Animation.RELATIVE_TO_SELF,0.5f,
            Animation.RELATIVE_TO_SELF,0.5f
            ).also {
            it.duration = 1000
            View.startAnimation(it)
        }
    }

    private fun setAnimXml(){
        (AnimationUtils.loadAnimation(this,R.anim.set_anim)as AnimationSet).also {
            View.startAnimation(it)
        }
    }
    private fun setAnimCode(){
        val rotateAnimation = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 1000
            fillAfter = true
        }

        val scaleAnimation = ScaleAnimation(
            1f, 2f, 1f, 2f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 1000
            fillAfter = true
        }

        AnimationSet(true).apply {
            addAnimation(scaleAnimation)
            addAnimation(rotateAnimation)
            View.startAnimation(this)
        }
    }

//    private fun AnimationStart(){
//        val fires = arrayOf(R.drawable.campfire01,
//            R.drawable.campfire02,
//            R.drawable.campfire03,
//            R.drawable.campfire04,
//            R.drawable.campfire05,
//            R.drawable.campfire06,
//            R.drawable.campfire07,
//            R.drawable.campfire08,
//            R.drawable.campfire09,
//            R.drawable.campfire10,
//            R.drawable.campfire11,
//            R.drawable.campfire12,
//            R.drawable.campfire13,
//            R.drawable.campfire14,
//            R.drawable.campfire15,
//            R.drawable.campfire16,
//            R.drawable.campfire17
//        )
//        animFram = AnimationDrawable().apply {
//            for (item in fires){
//                addFrame(getDrawable(item)!!,100)
//            }
//            animationView.setImageDrawable(this)
//            start()
//        }
//    }
}