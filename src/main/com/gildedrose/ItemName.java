package com.gildedrose;

/**
 * Created by xtrella on 6/5/16.
 */
public enum ItemName {

    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert");

    private String name;

    ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ItemName from(Item item) {
        for (ItemName itemName : values()) {
            if (itemName.name.equals(item.name)) {
                return itemName;
            }
        }
        return null;
    }
}
