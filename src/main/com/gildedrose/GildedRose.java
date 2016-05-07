package com.gildedrose;

import com.gildedrose.handler.ItemHandlerFactory;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            ItemHandlerFactory
                    .getHandler(item)
                    .update(item);
        }
    }


}
