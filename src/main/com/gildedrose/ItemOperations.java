package com.gildedrose;

import java.util.function.Predicate;

/**
 * Created by xtrella on 5/5/16.
 */
public class ItemOperations {

    public static void decreaseQuality(Item item, Predicate<Item> testItem) {
        if (testItem.test(item)) {
            item.quality = item.quality - 1;
        }
    }

    public static void increaseQuality(Item item, Predicate<Item> testSellin) {
        if (item.quality < GildedRose.MAX_QUALITY && testSellin.test(item)) {
            item.quality = item.quality + 1;
        }
    }

    public static void decreaseSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}
