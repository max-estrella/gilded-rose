package com.gildedrose.handler;

import com.gildedrose.Item;


/**
 * Created by xtrella on 5/5/16.
 */
public class BackstageHandler extends AbstractHandler {

    protected static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    private static final int BACKSTAGE_SELLIN_INCREASE2_LIMIT = 10;
    private static final int BACKSTAGE_SELLIN_INCREASE3_LIMIT = 5;

    @Override
    public boolean accept(Item item) {
        return ITEM_NAME.equals(item.name);
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
