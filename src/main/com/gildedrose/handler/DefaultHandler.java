package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.ItemOperations;

import static com.gildedrose.ItemOperations.decreaseSellin;

/**
 * Created by xtrella on 6/5/16.
 */
public class DefaultHandler implements ItemHandler {

    @Override
    public boolean accept(Item item) {
        return true;
    }

    @Override
    public void update(Item item) {
        decreaseSellin(item);
        ItemOperations.decreaseQuality(item, item1 -> item1.quality >0);
        ItemOperations.decreaseQuality(item, item1 -> item1.sellIn<0 && item1.quality>0);
    }
}
