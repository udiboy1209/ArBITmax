package code.fundo.arbitmax;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

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
        String username=((TextView)findViewById(R.id.username)).getText().toString();
        String password=((TextView)findViewById(R.id.password)).getText().toString();

        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Logging you in...", true);

        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                BalanceResponse r = (BalanceResponse) o;

                me.balance = Long.valueOf(r.balance);
                storeUser();

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void failure(RetrofitError retrofitError) {

                retrofitError.printStackTrace();
                dialog.dismiss();
                //Toast.makeText(EventsActivity.this, "Error fetching data", Toast.LENGTH_LONG).show();
                showErrorDialog("Can't fetch data:"+retrofitError.getMessage());
            }
        };

        ownServer.getBalance(username,password,callback);
    }
}
