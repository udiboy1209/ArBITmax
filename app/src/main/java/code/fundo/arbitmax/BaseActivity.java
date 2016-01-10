package code.fundo.arbitmax;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import com.google.gson.Gson;

import retrofit.RestAdapter;

/**
 * Created by udiboy on 9/1/16.
 */
public class BaseActivity extends AppCompatActivity{

    public User me;
    SharedPreferences prefs;
    Gson parser = new Gson();
    RestAdapter ownServerAdapter = new RestAdapter.Builder()
            .setEndpoint("arbitmaxurl")
            .build();
    BitClient ownServer;

    RestAdapter bcServerAdapter = new RestAdapter.Builder()
            .setEndpoint("bcurl")
            .build();
    BitClient bcServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs=getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE);

        if(prefs.contains("user"))
            me=parser.fromJson(prefs.getString("user",""),User.class);
        else
            me=new User();

        ownServer = ownServerAdapter.create(BitClient.class);
        bcServer = bcServerAdapter.create(BitClient.class);
    }

    @Override
    protected void onStop() {
        super.onStop();

        storeUser();
    }

    public void showErrorDialog(String content){
        new AlertDialog.Builder(this).setTitle("Internet Error").setMessage(content)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void storeUser(){
        String userjson=parser.toJson(me);
        prefs.edit().putString("user",userjson).commit();
    }
}
