package com.gildedrose;

import com.gildedrose.handler.BackstageHandler;
import com.gildedrose.handler.FactoryHandler;
import com.gildedrose.handler.ItemHandler;

import static com.gildedrose.ItemOperations.decreaseSellin;
import static com.gildedrose.ItemOperations.increaseQuality;

class GildedRose {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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
            } else if (item.name.equals(BackstageHandler.ITEM_NAME)) {
                decreaseSellin(item);
                updateQualityBackstage(item);
            } else if (item.name.equals(SULFURAS)) {
                updateQualitySulfuras(item);
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



    private void updateQualitySulfuras(Item item) {

    }

    private void updateQualityBackstage(Item item) {

        increaseQuality(item, item1 -> true);
        increaseQuality(item, item1 -> item1.sellIn < BackstageHandler.BACKSTAGE_SELLIN_INCREASE2_LIMIT);
        increaseQuality(item, item1 -> item1.sellIn < BackstageHandler.BACKSTAGE_SELLIN_INCREASE3_LIMIT);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

}
