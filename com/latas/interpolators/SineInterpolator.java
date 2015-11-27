package com.latas.interpolators;

import android.view.animation.Interpolator;

public class SineInterpolator extends EaseInterpolator implements Interpolator {

    public SineInterpolator(float duration, float begingValue, float endValue, InterpolatorType interpolatorType) {
        this.duration = duration;
        this.begingValue = begingValue;
        this.endValue = endValue;
        this.mInterpolatorType = interpolatorType;
    }

    public SineInterpolator(float duration, InterpolatorType interpolatorType) {
        this.duration = duration;
        this.mInterpolatorType = interpolatorType;
    }


    /**
     * Maps a value representing the elapsed fraction of an animation to a value that represents
     * the interpolated fraction. This interpolated value is then multiplied by the change in
     * value of an animation to derive the animated value at the current elapsed animation time.
     *
     * @param input A value between 0 and 1.0 indicating our current point
     *              in the animation where 0 represents the start and 1.0 represents
     *              the end
     * @return The interpolation value. This value can be more than 1.0 for
     * interpolators which overshoot their targets, or less than 0 for
     * interpolators that undershoot their targets.
     */
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
        return -c * (float) Math.cos(t / d * (Math.PI / 2)) + c + b;
    }

    public float easeOut(float t, float b, float c, float d) {
        return c * (float) Math.sin(t / d * (Math.PI / 2)) + b;
    }

    public float easeInOut(float t, float b, float c, float d) {
        return -c / 2 * ((float) Math.cos(Math.PI * t / d) - 1) + b;
    }
}
