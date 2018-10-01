package id.pastakangen.com.pastakangen.costum_overwrite;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Created by rifky on 29/09/18.
 */

public class TypeFactory {
    final String NOVA_REGULAR="nova/Nova-Regular.otf";
    final String NOVA_BOLD="nova/Nova-Bold.otf";
    final String NOVA_SEMIBOLD="nova/Nova-Semibold.otf";
    final String NOVA_HEAVY="nova/Nova-Heavy.otf";

    Typeface regular;
    Typeface bold;
    Typeface heavy;
    Typeface semibold;

    public TypeFactory(Context context){
        regular = Typeface.createFromAsset(context.getAssets(),NOVA_REGULAR);
        bold = Typeface.createFromAsset(context.getAssets(),NOVA_BOLD);
        heavy = Typeface.createFromAsset(context.getAssets(),NOVA_HEAVY);
        semibold = Typeface.createFromAsset(context.getAssets(),NOVA_SEMIBOLD);
    }

    public Typeface getRegular(){
        return regular;
    }

    public Typeface getBold() {
        return bold;
    }

    public Typeface getHeavy() {
        return heavy;
    }

    public Typeface getSemibold() {
        return semibold;
    }
}
