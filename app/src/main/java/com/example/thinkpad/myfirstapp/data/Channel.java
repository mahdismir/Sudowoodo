package com.example.thinkpad.myfirstapp.data;

import org.json.JSONObject;

/**
 * Created by mitch_000 on 11/4/2015.
 */
public class Channel implements JSONPopulator {
    private Units units;
    private Item item;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void populate(JSONObject data) {
        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));
    }
}
