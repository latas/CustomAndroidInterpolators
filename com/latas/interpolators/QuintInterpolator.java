package com.latas.interpolators;

import android.view.animation.Interpolator;


public class QuintInterpolator extends EaseInterpolator implements Interpolator {

    public QuintInterpolator(float duration, float begingValue, float endValue, InterpolatorType interpolatorType) {
        this.duration = duration;
        this.begingValue = begingValue;
        this.endValue = endValue;
        this.mInterpolatorType = interpolatorType;
    }

    public QuintInterpolator(float duration, InterpolatorType interpolatorType) {
        this.duration = duration;
        this.mInterpolatorType = interpolatorType;
    }

    @Override
    public float getInterpolation(float input) {
        switch (mInterpolatorType) {
            case EASE_IN:
                return easeIn(duration * input, begingValue, endValue - begingValue, duration);
            case EASE_OUT:
                return easeOut(duration * input, begingValue, endValue - begingValue, duration);
            case EASE_IN_OUT:
                return easeInOut(duration * input, begingValue, endValue - begingValue, duration);
        }
        return 0;
    }

    public float easeIn(float t, float b, float c, float d) {
        return c * (t /= d) * t * t * t * t + b;
    }

    public float easeOut(float t, float b, float c, float d) {
        return c * ((t = t / d - 1) * t * t * t * t + 1) + b;
    }

    public float easeInOut(float t, float b, float c, float d) {
        if ((t /= d / 2) < 1) return c / 2 * t * t * t * t * t + b;
        return c / 2 * ((t -= 2) * t * t * t * t + 2) + b;
    }
}
