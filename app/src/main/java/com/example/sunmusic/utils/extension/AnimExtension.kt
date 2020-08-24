package com.example.sunmusic.utils.extension

import android.transition.*
import android.view.Gravity
import android.view.ViewGroup

fun ViewGroup.applyAnimationSlide() {
    val slide = Slide(Gravity.BOTTOM).apply {
        duration = 500
        startDelay = 100
    }
    TransitionManager.beginDelayedTransition(this, slide)
}

fun ViewGroup.applyAnimationExplode() {
    val explode = Explode().apply {
        duration = 500
        startDelay = 100
    }
    TransitionManager.beginDelayedTransition(this, explode)
}

fun ViewGroup.applyAnimationChangeImage() {
    val transitionSet = TransitionSet().apply {
        addTransition(ChangeBounds())
        addTransition(ChangeImageTransform())
    }
    TransitionManager.beginDelayedTransition(this, transitionSet)
}

fun ViewGroup.appAnimationMove() {
    val changeBounds = ChangeBounds().apply {
        pathMotion = ArcMotion().apply { duration = 500 }
    }
    TransitionManager.beginDelayedTransition(this, changeBounds)
}
