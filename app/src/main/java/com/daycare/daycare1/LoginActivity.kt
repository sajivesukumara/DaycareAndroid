package com.daycare.daycare1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.view.View
import com.daycare.daycare1.R
import kotlinx.android.synthetic.main.activity_splash.*

class LoginActivity : AppCompatActivity() {
    private val applyConstraintSet = ConstraintSet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        btnLogin.setOnClickListener(View.OnClickListener {

            moveSignFragment()
        })
        btnRegister.setOnClickListener(View.OnClickListener {
            home()
        })
        Handler().postDelayed(Runnable {

               /* TransitionManager.beginDelayedTransition(constraintLayout);
                applyConstraintSet.clone(constraintLayout);
                applyConstraintSet.setVerticalBias(R.id.imageView, 0.3f);
                //applyConstraintSet.setVisibility(R.id.txtvwTerms,View.VISIBLE)
                applyConstraintSet.setGuidelinePercent(R.id.guideline, 0.65f)
                applyConstraintSet.applyTo(constraintLayout);*/
            moveSignFragment()

        }, 15)
    }

    public fun home(){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }


    public fun moveSignFragment() {
        btnRegister.visibility = View.GONE;
        btnLogin.visibility = View.GONE
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
        transaction.replace(R.id.frmlayoutContainer, SignInFragment())
        transaction.commit()
        TransitionManager.beginDelayedTransition(constraintLayout);
        applyConstraintSet.clone(constraintLayout);
        applyConstraintSet.setGuidelinePercent(R.id.guideline, 0.50f)
        applyConstraintSet.applyTo(constraintLayout);

    }
}
