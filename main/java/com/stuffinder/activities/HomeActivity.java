package com.stuffinder.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.stuffinder.R;
import com.stuffinder.data.Tag;
import com.stuffinder.engine.NetworkServiceProvider;
import com.stuffinder.exceptions.NetworkServiceException;
import com.stuffinder.exceptions.NotAuthenticatedException;

import java.util.List;


public class HomeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

    }

    public void goToInterieur(View view){

        try {
            List<Tag> list = NetworkServiceProvider.getNetworkService().getTags();

            InterieurActivity.ChangeTagsList(list);
            Intent intentInt = new Intent (HomeActivity.this, InterieurActivity.class);
            startActivity(intentInt);
        } catch (NotAuthenticatedException e) {// abnormal error.
            Toast.makeText(this, "Une erreur anormale est survenue. Veuiller redémarrer l'application", Toast.LENGTH_LONG).show();
        } catch (NetworkServiceException e) {
            Toast.makeText(this, "Une erreur réseau est survenue.", Toast.LENGTH_LONG).show();
        }

    }

    public void goToExterieur(View view){
        Intent intentExt = new Intent(HomeActivity.this, ExterieurActivity.class);
        startActivity(intentExt);}

    public void goToConfiguration(View view){
        Intent intentConf = new Intent(HomeActivity.this, ConfigurationActivity.class);
        startActivity(intentConf);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() { // à modifier pour quitter l'application, ou se déconnecter et revenir à l'écran de connexion.
        super.finish();
    }
}
