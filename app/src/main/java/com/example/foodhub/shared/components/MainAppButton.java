package com.example.foodhub.shared.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.foodhub.R;
import com.example.foodhub.utils.SizeUtils;

public class MainAppButton extends AppCompatTextView {

    private Context context;

    public MainAppButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context =context;

       TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.MainAppButton);

       int padding = a.getInteger(0,R.styleable.MainAppButton_btn_width);

        setTextColor(context.getColor(R.color.white));
        setAllCaps(true);
        setElevation(SizeUtils.Dp2Px(context,8));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
        setTypeface(Typeface.DEFAULT_BOLD);
        setPadding((int)SizeUtils.Dp2Px(context,padding),(int)SizeUtils.Dp2Px(context,18),(int)SizeUtils.Dp2Px(context,padding),(int)SizeUtils.Dp2Px(context,18));

        Drawable normal = getDrawable(context.getColor(R.color.main_color));
        Drawable pressed = getDrawable(context.getColor(R.color.main_btn_color_pressed));
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed},pressed);
        states.addState(new int[]{},normal);
        setBackground(states);


    }



    private Drawable getDrawable(int color){
        GradientDrawable shape =new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(color);
        shape.setCornerRadius(SizeUtils.Dp2Px(context,30));

        return  shape;
    }


}
