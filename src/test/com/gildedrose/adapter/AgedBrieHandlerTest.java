package com.gildedrose.adapter;

import com.gildedrose.Item;
import org.junit.Test;

import static com.gildedrose.adapter.AgedBrieHandler.ITEM_NAME;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by xtrella on 5/5/16.
 */
public class AgedBrieHandlerTest {

    private AgedBrieHandler handler = new AgedBrieHandler();

    @Test
    public void given_agedBrie_when_updateQuality_then_should_increase_quality() {
        Item item = new Item(ITEM_NAME, 0, 0);
        handler.update(item);
        assertEquals(2, item.quality);
    }

    @Test
    public void given_agedBrie_more_than0_when_updateQuality_then_should_increase_quality() {
        Item item = new Item(ITEM_NAME, 1, 4);
        handler.update(item);
        assertEquals(5, item.quality);
    }

    @Test
    public void given_quality_more_than_50_when_update_quality_is_never_more_than_50() {
        Item item = new Item(ITEM_NAME, 0, 50);
        handler.update(item);
        assertEquals(50, item.quality);
    }


}