package id.pastakangen.com.pastakangen.costum_overwrite;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import id.pastakangen.com.pastakangen.MainApplication;
import id.pastakangen.com.pastakangen.R;
/**
 * Created by rifky on 30/09/18.
 */

public class CustomTextView extends AppCompatTextView {
    private int typeFaceType;

    public CustomTextView(Context context, AttributeSet attrs){
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView,
                0, 0
        );

        try {
            typeFaceType = array.getInteger(R.styleable.CustomTextView_font_name, 0);
        }finally {
            array.recycle();
        }
        if (!isInEditMode()) {
            setTypeface(MainApplication.Companion.getTypeFace(context,typeFaceType));
        }


    }
}
