package com.gildedrose.handler;


import com.gildedrose.Item;
import com.gildedrose.ItemName;

import java.util.function.Predicate;

/**
 * Created by xtrella on 6/5/16.
 */
public abstract class AbstractHandler implements ItemHandler {

    private static final int MAX_QUALITY = 50;

    protected void decreaseQuality(Item item, Predicate<Item> testItem) {
        if (testItem.test(item)) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQuality(Item item, Predicate<Item> testSellin) {
        if (item.quality < MAX_QUALITY && testSellin.test(item)) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }

}
