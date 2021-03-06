package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public static Item of(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    public static Item of(String name) {
        return of(name, 0, 0);
    }

    public static Item of(ItemName name, int sellIn, int quality) {
        return new Item(name.getName(), sellIn, quality);
    }

    public static Item of(ItemName name) {
        return of(name.getName(), 0, 0);
    }
}
