package com.gildedrose;

import com.gildedrose.handler.FactoryHandler;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            FactoryHandler
                    .getHandler(item)
                    .update(item);
        }
    }


}
