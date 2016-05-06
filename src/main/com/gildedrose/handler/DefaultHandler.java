package com.gildedrose.handler;

import com.gildedrose.Item;

/**
 * Created by xtrella on 6/5/16.
 */
public class DefaultHandler extends AbstractHandler {

    @Override
    public void update(Item item) {
        decreaseSellin(item);
        decreaseQuality(item, item1 -> item1.quality>0);
        decreaseQuality(item, item1 -> item1.sellIn<0 && item1.quality>0);
    }
}
