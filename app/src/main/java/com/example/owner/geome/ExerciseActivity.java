package com.example.owner.geome;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import static com.parse.ParseConfig.getInBackground;

/**
 * Created by Nogah on 3/15/16.
 */
public class ExerciseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exercise);

        ImageView centerIV = (ImageView) findViewById(R.id.exerciseActivity_centerIV);

        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(centerIV);

        final TextView timerTV = (TextView) findViewById(R.id.exerciseActivity_timerTV);

        final TextView question = (TextView) findViewById(R.id.exerciseActivity_question);

        Log.d("yarkoni", "Making queries");
        ParseQuery<GeoSubject> query = ParseQuery.getQuery("GeoSubjects");
        query.whereEqualTo("level", 1);
        query.findInBackground(new FindCallback<GeoSubject>() {
            public void done(List<GeoSubject> geoSubjectList, ParseException e) {
                if (e == null) {
                    Log.d("yarkoni", "Retrieved " + geoSubjectList.size());
                    Log.d("yarkoni", "Retrieved " + geoSubjectList.get(0).getObjectId());

                    getGeoExercisesByGeoSubjectId(geoSubjectList.get(0).getObjectId());


                } else {
                    Log.d("yarkoni", "Error: " + e.getMessage());
                }
            }
        });

        /*getInBackground("svjq1hEE48",
                new GetCallback<ParseObject>() {

                    public void done(ParseObject object,
                                     ParseException e) {
                        // TODO Auto-generated method stub

                        // Locate the column named "ImageName" and set
                        // the string
                        ParseFile fileObject = (ParseFile) object
                                .get("ImageFile");
                        fileObject
                                .getDataInBackground(new GetDataCallback() {

                                    public void done(byte[] data,
                                                     ParseException e) {
                                        if (e == null) {
                                            Log.d("test",
                                                    "We've got data in data.");
                                            // Decode the Byte[] into
                                            // Bitmap
                                            Bitmap bmp = BitmapFactory
                                                    .decodeByteArray(
                                                            data, 0,
                                                            data.length);

                                            // Get the ImageView from
                                            // main.xml
                                            ImageView image = (ImageView) findViewById(R.id.image);

                                            // Set the Bitmap into the
                                            // ImageView
                                            image.setImageBitmap(bmp);
                                        } else {
                                            Log.d("test",
                                                    "There was a problem downloading the data.");
                                        }
                                    }
                                });
                    }
                }); */

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTV.setText(millisUntilFinished / 1000 + " sec");
            }

            public void onFinish() {
//                timerTV.setText("done!");
            }
        }.start();
    }

    private void getGeoExercisesByGeoSubjectId(String objectId) {

        ParseQuery<GeoExercise> query = ParseQuery.getQuery("GeoExercises");
        query.whereEqualTo("subjectid", objectId);
        query.findInBackground(new FindCallback<GeoExercise>() {
            public void done(List<GeoExercise> geoExerciseList, ParseException e) {
                if (e == null) {
                    Log.d("yarkoni", "exercises size " + geoExerciseList.size());



                } else {
                    Log.d("yarkoni", "Error: " + e.getMessage());
                }
            }
        });
    }

    private void getInBackground(String svjq1hEE48, GetCallback<ParseObject> getCallback) {

    }


}