package com.gildedrose.handler;

import com.gildedrose.Item;

/**
 * Created by xtrella on 5/5/16.
 */
public class AgedBrieHandler extends AbstractHandler {

    protected static final String ITEM_NAME = "Aged Brie";

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
