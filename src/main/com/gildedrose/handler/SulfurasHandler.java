package com.gildedrose.handler;

import com.gildedrose.Item;

/**
 * Created by xtrella on 5/5/16.
 */
public class SulfurasHandler implements ItemHandler {

    public static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

    @Override
    public boolean accept(Item item) {
        return ITEM_NAME.equals(item.name);
    }

    @Override
    public void update(Item item) {

    }
}
