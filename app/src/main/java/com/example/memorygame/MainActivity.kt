package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val listImageOchiqYopiq = arrayOf(false, false, false, false, false, false )
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var ochiqrasm = 0
    var animationDoing = false
    var random = Random.nextInt(3)
    var random2 = Random.nextInt(3)
    var random3 = Random.nextInt(3)
    var random4 = Random.nextInt(3)
    var random5 = Random.nextInt(3)
    var random6 = Random.nextInt(3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        image_1.setOnClickListener {
            imageClick(image_1, R.drawable.havo, 0)
        }
        image_2.setOnClickListener {
            imageClick(image_2, R.drawable.download, 1)
        }
        image_3.setOnClickListener {
            imageClick(image_3, R.drawable.apple, 2)
        }
        image_4.setOnClickListener {
            imageClick(image_4, R.drawable.havo, 3)
        }
        image_5.setOnClickListener {
            imageClick(image_5, R.drawable.download, 4)
        }
        image_6.setOnClickListener {
            imageClick(image_6, R.drawable.apple, 5)
        }
    }

    fun imageClick(imageView: ImageView, rasm: Int, index: Int){
        if (animationDoing == false) {
            if (listImageOchiqYopiq[index] == false) {
                animationOchilish(imageView, rasm, index)
            } else {
                animationYopilish(imageView, rasm, index)
            }
        }
    }
    fun animationOchilish(imageView: ImageView, rasm:Int, index: Int){
        var anim = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        imageView.startAnimation(anim)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                animationDoing = true
            }

            override fun onAnimationEnd(p0: Animation?) {
                val anim2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(anim2)
                imageView.setImageResource(rasm)
                anim2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        listImageOchiqYopiq[index] = true
                        imageIndex[ochiqrasm] = index
                        rasmId[ochiqrasm] = rasm
                        ochiqrasm++
                        if (ochiqrasm == 2){
                            if (rasmId[0] == rasmId[1]){
                                imagevievAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                ochiqrasm--
                                imagevievAniqla(imageIndex[1]).visibility = View.INVISIBLE
                                ochiqrasm--
                            }else{
                                animationYopilish(imagevievAniqla(imageIndex[0]),-1, imageIndex[0])
                                animationYopilish(imagevievAniqla(imageIndex[1]),-1, imageIndex[1])
                            }
                        }
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(p0: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })

    }

    fun animationYopilish(imageView: ImageView, rasm:Int, index: Int? ){
        var anim = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        imageView.startAnimation(anim)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                 animationDoing = true
            }

            override fun onAnimationEnd(p0: Animation?) {
                val anim2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(anim2)
                imageView.setImageResource(R.drawable.memory)
                anim2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(p0: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
        listImageOchiqYopiq[index!!] = false
        ochiqrasm--
    }

     fun imagevievAniqla(index: Int?) : ImageView{
         var imageView:ImageView? = null
         when(index){
             0 ->imageView = image_1
             1 ->imageView = image_2
             2 ->imageView = image_3
             3 ->imageView = image_4
             4 ->imageView = image_5
             5 ->imageView = image_6
         }
         return  imageView!!
     }

}