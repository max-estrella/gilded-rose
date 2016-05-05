package com.gildedrose.handler;

import com.gildedrose.Item;

/**
 * Created by xtrella on 5/5/16.
 */
public interface ItemHandler {

    boolean accept(Item item);

    void update(Item item);
}
