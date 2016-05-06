package com.gildedrose.handler;

import com.gildedrose.Item;
import org.junit.Test;

import static com.gildedrose.ItemName.AGED_BRIE;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by xtrella on 5/5/16.
 */
public class AgedBrieHandlerTest {

    private AgedBrieHandler handler = new AgedBrieHandler();

    @Test
    public void given_agedBrie_when_updateQuality_then_should_increase_quality() {
        Item item = Item.of(AGED_BRIE);
        handler.update(item);
        assertEquals(2, item.quality);
    }

    @Test
    public void given_agedBrie_more_than0_when_updateQuality_then_should_increase_quality() {
        Item item = Item.of(AGED_BRIE,1,4);
        handler.update(item);
        assertEquals(5, item.quality);
    }

    @Test
    public void given_quality_more_than_50_when_update_quality_is_never_more_than_50() {
        Item item = Item.of(AGED_BRIE,0,50);
        handler.update(item);
        assertEquals(50, item.quality);
    }

    @Test
    public void given_agedBrieItem_when_accept_then_should_accept() {
        Item item = Item.of(AGED_BRIE,0,0);
        assertTrue(handler.accept(item));
    }

    @Test
    public void given_not_agedBrieItem_when_accept_then_should_not_accept() {
        Item item = Item.of("foo");
        assertFalse(handler.accept(item));
    }


}