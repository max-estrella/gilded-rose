package com.gildedrose;

import java.util.function.Predicate;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static final int MAX_QUALITY = 50;
    public static final int BACKSTAGE_SELLIN_INCREASE2_LIMIT = 10;
    public static final int BACKSTAGE_SELLIN_INCREASE3_LIMIT = 5;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {


        for (int i = 0; i < items.length; i++) {

            Item item = items[i];

            //ItemAdapter adapter = FactoryAdapter.get(item);

            //adapter.update();


            if (item.name.equals(AGED_BRIE)) {
                decreaseSellin(item);
                updateQualityBrie(item);
            } else if (item.name.equals(BACKSTAGE)) {
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
        decreaseQuality(item, item1 -> item1.quality >0);
        decreaseQuality(item, item1 -> item1.sellIn<0 && item1.quality>0);
    }



    private void updateQualitySulfuras(Item item) {

    }

    private void updateQualityBackstage(Item item) {

        increaseQuality(item, item1 -> true);
        increaseQuality(item, item1 -> item1.sellIn < BACKSTAGE_SELLIN_INCREASE2_LIMIT);
        increaseQuality(item, item1 -> item1.sellIn < BACKSTAGE_SELLIN_INCREASE3_LIMIT);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void decreaseSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateQualityBrie(Item item) {
        increaseQuality(item, item1 -> true);
        increaseQuality(item, item1 -> item1.sellIn < 0);
    }

    private void decreaseQuality(Item item, Predicate<Item> testItem) {
        if (testItem.test(item)) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item, Predicate<Item> testSellin) {
        if (item.quality < MAX_QUALITY && testSellin.test(item)) {
            item.quality = item.quality + 1;
        }
    }
}
