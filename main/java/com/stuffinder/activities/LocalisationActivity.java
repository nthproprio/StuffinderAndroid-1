package com.stuffinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.stuffinder.R;
import com.stuffinder.data.Tag;

public class LocalisationActivity extends Activity {

    private static Tag tagLoc;

    TextView nomObjTextView ;
    TextView positionTextView ;


    public static void ChangeTag(Tag tag)
    {
        tagLoc = tag ;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localisation);

        nomObjTextView = (TextView)findViewById(R.id.textViewNomObj);
        positionTextView = (TextView)findViewById(R.id.textViewPosition);

        try {
            nomObjTextView.setText(tagLoc.getObjectName());
            if (distance(tagLoc.getUid()=1))
            {
                positionTextView.setText("est tres proche");
            }
            else {
                if (distance(tagLoc.getUid()=2))
                    positionTextView.setText("est moyennement proche");

                else
                    positionTextView.setText("est loin");
            }

        } catch (tagNotDetectedException e) {
            e.printStackTrace ;
        }

    }

    public void retour9 (View view) {
        Intent intentRetour = new Intent (LocalisationActivity.this, InterieurActivity.class);
        startActivity(intentRetour); }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_localisation, menu);
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
}
