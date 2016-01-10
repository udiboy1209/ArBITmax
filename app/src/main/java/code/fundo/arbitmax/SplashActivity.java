package code.fundo.arbitmax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(prefs.contains("user")) {
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    public void login(View v){

    }
}
