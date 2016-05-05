package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.ItemOperations.decreaseSellin;
import static com.gildedrose.ItemOperations.increaseQuality;

/**
 * Created by xtrella on 5/5/16.
 */
public class BackstageHandler implements ItemHandler {

    public static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    public static final int BACKSTAGE_SELLIN_INCREASE2_LIMIT = 10;
    public static final int BACKSTAGE_SELLIN_INCREASE3_LIMIT = 5;

    @Override
    public boolean accept(Item item) {
        return false;
    }

    @Override
    public void update(Item item) {
        decreaseSellin(item);
        increaseQuality(item, item1 -> true);
        increaseQuality(item, item1 -> item1.sellIn < BACKSTAGE_SELLIN_INCREASE2_LIMIT);
        increaseQuality(item, item1 -> item1.sellIn < BACKSTAGE_SELLIN_INCREASE3_LIMIT);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
