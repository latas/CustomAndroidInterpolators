package com.latas.interpolators;


import android.view.animation.Interpolator;

public class ElasticInterpolator extends EaseInterpolator implements Interpolator {

    public ElasticInterpolator(float duration, float begingValue, float endValue, InterpolatorType interpolatorType) {
        this.duration = duration;
        this.begingValue = begingValue;
        this.endValue = endValue;
        this.mInterpolatorType = interpolatorType;
    }

    public ElasticInterpolator(float duration, InterpolatorType interpolatorType) {
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
        if (t == 0) return b;
        if ((t /= d) == 1) return b + c;
        float p = d * .3f;
        float a = c;
        float s = p / 4;
        return -(a * (float) Math.pow(2, 10 * (t -= 1)) * (float) Math.sin((t * d - s) * (2 * (float) Math.PI) / p)) + b;
    }

    public static float easeIn(float t, float b, float c, float d, float a, float p) {
        float s;
        if (t == 0) return b;
        if ((t /= d) == 1) return b + c;
        if (a < Math.abs(c)) {
            a = c;
            s = p / 4;
        } else {
            s = p / (2 * (float) Math.PI) * (float) Math.asin(c / a);
        }
        return -(a * (float) Math.pow(2, 10 * (t -= 1)) * (float) Math.sin((t * d - s) * (2 * Math.PI) / p)) + b;
    }

    public float easeOut(float t, float b, float c, float d) {
        if (t == 0) return b;
        if ((t /= d) == 1) return b + c;
        float p = d * .3f;
        float a = c;
        float s = p / 4;
        return (a * (float) Math.pow(2, -10 * t) * (float) Math.sin((t * d - s) * (2 * (float) Math.PI) / p) + c + b);
    }

    public float easeOut(float t, float b, float c, float d, float a, float p) {
        float s;
        if (t == 0) return b;
        if ((t /= d) == 1) return b + c;
        if (a < Math.abs(c)) {
            a = c;
            s = p / 4;
        } else {
            s = p / (2 * (float) Math.PI) * (float) Math.asin(c / a);
        }
        return (a * (float) Math.pow(2, -10 * t) * (float) Math.sin((t * d - s) * (2 * (float) Math.PI) / p) + c + b);
    }

    public float easeInOut(float t, float b, float c, float d) {
        if (t == 0) return b;
        if ((t /= d / 2) == 2) return b + c;
        float p = d * (.3f * 1.5f);
        float a = c;
        float s = p / 4;
        if (t < 1)
            return -.5f * (a * (float) Math.pow(2, 10 * (t -= 1)) * (float) Math.sin((t * d - s) * (2 * (float) Math.PI) / p)) + b;
        return a * (float) Math.pow(2, -10 * (t -= 1)) * (float) Math.sin((t * d - s) * (2 * (float) Math.PI) / p) * .5f + c + b;
    }

    public float easeInOut(float t, float b, float c, float d, float a, float p) {
        float s;
        if (t == 0) return b;
        if ((t /= d / 2) == 2) return b + c;
        if (a < Math.abs(c)) {
            a = c;
            s = p / 4;
        } else {
            s = p / (2 * (float) Math.PI) * (float) Math.asin(c / a);
        }
        if (t < 1)
            return -.5f * (a * (float) Math.pow(2, 10 * (t -= 1)) * (float) Math.sin((t * d - s) * (2 * (float) Math.PI) / p)) + b;
        return a * (float) Math.pow(2, -10 * (t -= 1)) * (float) Math.sin((t * d - s) * (2 * (float) Math.PI) / p) * .5f + c + b;
    }
}