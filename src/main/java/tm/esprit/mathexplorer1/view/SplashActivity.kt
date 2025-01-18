package tm.esprit.mathexplorer1.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import tm.esprit.mathexplorer1.R

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_DISPLAY_LENGTH = 5000 // 2 seconds
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoImageView: ImageView = findViewById(R.id.logoImageView)
        val appName: TextView = findViewById(R.id.appName)
        val appSlogan: TextView = findViewById(R.id.appSlogan)

        // Combined animation for logo
        val animationSet = AnimationSet(true).apply {
            addAnimation(TranslateAnimation(0f, 0f, -25f, 0f).apply {
                duration = 1000
                fillAfter = true
            })
            addAnimation(AlphaAnimation(0f, 1f).apply {
                duration = 1000
                fillAfter = true
            })
        }
        logoImageView.startAnimation(animationSet)

        // Delay for text animations
        Handler(Looper.getMainLooper()).postDelayed({
            appName.visibility = View.VISIBLE
            appSlogan.visibility = View.VISIBLE

            appName.animate().alpha(1f).duration = 1000
            appSlogan.animate().alpha(1f).duration = 1000
        }, 500)

        // Delay to switch to AuthActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, AuthActivity::class.java))
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}
