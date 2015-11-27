package com.latas.interpolators;


import android.view.animation.Interpolator;

public class BounceInterpolator extends EaseInterpolator implements Interpolator {

    public BounceInterpolator(float duration, float begingValue, float endValue, InterpolatorType interpolatorType) {
        this.duration = duration;
        this.begingValue = begingValue;
        this.endValue = endValue;
        this.mInterpolatorType = interpolatorType;

    }

    public BounceInterpolator(float duration, InterpolatorType interpolatorType) {
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
        return c - easeOut(d - t, 0, c, d) + b;
    }

    public float easeOut(float t, float b, float c, float d) {
        if ((t /= d) < (1 / 2.75f)) {
            return c * (7.5625f * t * t) + b;
        } else if (t < (2 / 2.75f)) {
            return c * (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f) + b;
        } else if (t < (2.5 / 2.75)) {
            return c * (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f) + b;
        } else {
            return c * (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f) + b;
        }
    }

    public float easeInOut(float t, float b, float c, float d) {
        if (t < d / 2) return easeIn(t * 2, 0, c, d) * .5f + b;
        else return easeOut(t * 2 - d, 0, c, d) * .5f + c * .5f + b;
    }
}
