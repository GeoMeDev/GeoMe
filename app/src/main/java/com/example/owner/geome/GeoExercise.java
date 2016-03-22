package com.example.owner.geome;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.File;

/**
 * Created by Nogah on 3/22/16.
 */
@ParseClassName("GeoExercises")
public class GeoExercise extends ParseObject {

    public String getQuestion(){
        return getString("question");
    }

    public String getQuestion(){
        return getString("question");
    }

    public String correctAnswer(){
        return getString("correctAnswer");
    }

    public String wrongAnswer1(){
        return getString("wrongAnswer1");
    }

    public String wrongAnswer2(){
        return getString("wrongAnswer2");
    }

    public String wrongAnswer3(){
        return getString("wrongAnswer3");
    }

//    public File getImageFile(){
//        return getImageFile(imageFile);
//    }

}
