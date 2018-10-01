package id.pastakangen.com.pastakangen.utils;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.utils.L;

/**
 * Created by rifky on 29/09/18.
 */

public class ImageLoader {

    private static com.nostra13.universalimageloader.core.ImageLoader sUilImageLoader =
            com.nostra13.universalimageloader.core.ImageLoader.getInstance();

    public static com.nostra13.universalimageloader.core.ImageLoader getUilInstance() {
        return sUilImageLoader;
    }

        // init image use liblary Android-Universal-Image-Loader
    public static  void  initImageLoader(Context context) {
        DisplayImageOptions displayImageOptions =
                new DisplayImageOptions.Builder().resetViewBeforeLoading(true)
                .cacheInMemory(false)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                .build();

        ImageLoaderConfiguration.Builder configBuilder =
                new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(
                        displayImageOptions
                );

        L.writeLogs(false);
        sUilImageLoader.init(configBuilder.build());
    }

    public static void load(String fullUrl, ImageView view) {
        sUilImageLoader.displayImage(fullUrl, view);
    }
}
