package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {


    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void given_agedBrie_when_updateQuality_then_should_increase_quality() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void given_agedBrie_more_than0_when_updateQuality_then_should_increase_quality() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void given_foo_and_sell_passed_when_update_quality_degrades_twice() {
        Item[] items = new Item[] { new Item("foo", 0, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void given_foo_with_quality_zero_when_update_quality_is_never_negative() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void given_foo_when_update_quality_sellIn_decreases() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void given_quality_more_than_50_when_update_quality_is_never_more_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void given_sulfuras_when_update_quality_never_decreases() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void given_sulfuras_when_update_quality_never_is_sold() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    public void given_backstage_and_more_10days_when_update_quality_increases1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void given_backstage_10days_when_update_quality_increases2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void given_backstage_less_10days_more5_when_update_quality_increases2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void given_backstage_5days_when_update_quality_increases3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }


    @Test
    public void given_backstage_less_5days_more0_when_update_quality_increases3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void given_backstage_0days_when_update_quality_drop_to0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }




}
