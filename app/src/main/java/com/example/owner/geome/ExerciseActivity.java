package com.example.owner.geome;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;

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


        // Locate the class table named "ImageUpload" in Parse.com
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                "GeoSubject");

        // Locate the objectId from the class
        query.whereEqualTo("level", 1);
        query.findInBackground();

        getInBackground("svjq1hEE48",
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

                                            // Close progress dialog
                                            progressDialog.dismiss();

                                        } else {
                                            Log.d("test",
                                                    "There was a problem downloading the data.");
                                        }
                                    }
                                });
                    }
                });
    }

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTV.setText(millisUntilFinished / 1000 +" sec" );
            }

            public void onFinish() {
//                timerTV.setText("done!");
            }
        }.start();
    }
}
