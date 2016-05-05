package com.gildedrose.adapter;

import com.gildedrose.Item;

import static com.gildedrose.ItemOperations.decreaseSellin;
import static com.gildedrose.ItemOperations.increaseQuality;

/**
 * Created by xtrella on 5/5/16.
 */
public class AgedBrieHandler {

    public static final String ITEM_NAME = "Aged Brie";

    public void update(Item item) {
        decreaseSellin(item);
        increaseQuality(item, item1 -> true);
        increaseQuality(item, item1 -> item1.sellIn < 0);
    }
}
