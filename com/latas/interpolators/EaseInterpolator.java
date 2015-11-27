package com.latas.interpolators;

public class EaseInterpolator {
    protected float endValue = 1;
    protected float begingValue = 0;
    protected float duration;
    protected InterpolatorType mInterpolatorType;

    public enum InterpolatorType {
        EASE_IN, EASE_OUT, EASE_IN_OUT
    }

    public float easeIn(float t, float b, float c, float d) {
        return 0;
    }

    public float easeOut(float t, float b, float c, float d) {
        return 0;
    }

    public float easeInOut(float t, float b, float c, float d) {
        return 0;
    }
}
