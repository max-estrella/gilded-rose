package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.ItemOperations.decreaseSellin;
import static com.gildedrose.ItemOperations.increaseQuality;

/**
 * Created by xtrella on 5/5/16.
 */
public class AgedBrieHandler implements ItemHandler {

    public static final String ITEM_NAME = "Aged Brie";

    @Override
    public boolean accept(Item item) {
        return ITEM_NAME.equals(item.name);
    }

    public void update(Item item) {
        decreaseSellin(item);
        increaseQuality(item, item1 -> true);
        increaseQuality(item, item1 -> item1.sellIn < 0);
    }
}
