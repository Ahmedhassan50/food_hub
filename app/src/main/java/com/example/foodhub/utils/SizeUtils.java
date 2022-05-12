package com.example.foodhub.utils;

import android.content.Context;

public class SizeUtils {
    public static float Px2Dp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float Dp2Px(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
