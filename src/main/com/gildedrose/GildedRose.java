package com.gildedrose;

import com.gildedrose.handler.FactoryHandler;
import com.gildedrose.handler.ItemHandler;

import static com.gildedrose.ItemOperations.decreaseSellin;

class GildedRose {

    public static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            Item item = items[i];

            ItemHandler handler = FactoryHandler.getHandler(item);

            if (null != handler){
                handler.update(item);
            } else {
                decreaseSellin(item);
                updateQualityOther(item);
            }
        }
    }

    private void updateQualityOther(Item item) {
        ItemOperations.decreaseQuality(item, item1 -> item1.quality >0);
        ItemOperations.decreaseQuality(item, item1 -> item1.sellIn<0 && item1.quality>0);
    }

}
