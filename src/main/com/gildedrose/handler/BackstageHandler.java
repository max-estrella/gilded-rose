package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.ItemName.BACKSTAGE;


/**
 * Created by xtrella on 5/5/16.
 */
public class BackstageHandler extends AbstractHandler {

    private static final int BACKSTAGE_SELLIN_INCREASE2_LIMIT = 10;
    private static final int BACKSTAGE_SELLIN_INCREASE3_LIMIT = 5;

    public BackstageHandler() {
        itemName = BACKSTAGE;
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
