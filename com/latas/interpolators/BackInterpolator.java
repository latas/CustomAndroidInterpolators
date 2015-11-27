package com.latas.interpolators;

import android.view.animation.Interpolator;


public class BackInterpolator extends EaseInterpolator implements Interpolator {

    public BackInterpolator(float duration, float begingValue, float endValue, InterpolatorType interpolatorType) {
        this.duration = duration;
        this.begingValue = begingValue;
        this.endValue = endValue;
        this.mInterpolatorType = interpolatorType;
    }

    public BackInterpolator(float duration, InterpolatorType interpolatorType) {
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

    @Override
    public float easeIn(float t, float b, float c, float d) {
        float s = 1.70158f;
        return c * (t /= d) * t * ((s + 1) * t - s) + b;
    }

    @Override
    public float easeOut(float t, float b, float c, float d) {
        float s = 1.70158f;
        return c * ((t = t / d - 1) * t * ((s + 1) * t + s) + 1) + b;
    }

    @Override
    public float easeInOut(float t, float b, float c, float d) {
        float s = 1.70158f;
        if ((t /= d / 2) < 1) return c / 2 * (t * t * (((s *= (1.525f)) + 1) * t - s)) + b;
        return c / 2 * ((t -= 2) * t * (((s *= (1.525f)) + 1) * t + s) + 2) + b;
    }
}
