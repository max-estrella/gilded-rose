package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.ItemName.AGED_BRIE;

/**
 * Created by xtrella on 5/5/16.
 */
public class AgedBrieHandler extends AbstractHandler {

    public void update(Item item) {
        decreaseSellin(item);
        increaseQuality(item, item1 -> true);
        increaseQuality(item, item1 -> item1.sellIn < 0);
    }
}
