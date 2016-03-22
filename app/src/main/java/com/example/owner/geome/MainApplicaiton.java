package com.example.owner.geome;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import static com.parse.ParseACL.*;

/**
 * Created by Nogah on 3/22/16.
 */
public class MainApplicaiton extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        ParseObject.registerSubclass(GeoSubject.class);
        ParseObject.registerSubclass(GeoExercise.class);
// Add your initialization code here
        Parse.initialize(this);

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
// Optionally enable public read access.
// defaultACL.setPublicReadAccess(true);
        setDefaultACL(defaultACL, true);
    }
}
