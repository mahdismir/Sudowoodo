package com.example.thinkpad.myfirstapp.data;

import org.json.JSONObject;

/**
 * Created by mitch_000 on 11/4/2015.
 */
public class Item implements JSONPopulator {
    public Condition getCondition() {
        return condition;
    }

    private Condition condition;
    @Override
    public void populate(JSONObject data) {
        condition = new Condition();

        condition.populate(data.optJSONObject("condition"));
    }
}
