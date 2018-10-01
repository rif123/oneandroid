package id.pastakangen.com.pastakangen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import id.pastakangen.com.pastakangen.R;
import id.pastakangen.com.pastakangen.core.CoreActivity;
import id.pastakangen.com.pastakangen.main.MainActivity;

public class SplashActivity extends CoreActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();
            }
        }, 2000);

        // TODO if user login
//        if(!TextUtils.isEmpty(MainApplication.Companion.getPreferences().getGetToken() )) {
//            // Delay go to login/mainactivity 2 second
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    startActivity(new Intent(getApplication(), MainApplication.class));
//                    finish();
//                }
//            }, 2000);
//        } else {
//            // delay go to Login/main activity 2 second
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    startActivity(new Intent(getApplication(), MainApplication.class));
//                    finish();
//                }
//            }, 2000);
//        }

    }

}
