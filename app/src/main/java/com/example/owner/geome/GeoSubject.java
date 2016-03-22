package com.example.owner.geome;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Nogah on 3/22/16.
 */
@ParseClassName("GeoSubjects")
public class GeoSubject extends ParseObject {

    public int getLevel(){
        return getInt("level");
    }

    public String getExplanation(){
        return getString("explanation");
    }

    public String getTitle(){
        return getString("title");
    }
}
