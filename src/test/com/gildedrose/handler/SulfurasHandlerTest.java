package com.gildedrose.handler;

import com.gildedrose.Item;
import org.junit.Test;

import static com.gildedrose.ItemName.SULFURAS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by xtrella on 5/5/16.
 */
public class SulfurasHandlerTest {
    
    private SulfurasHandler handler = new SulfurasHandler();

    @Test
    public void given_quality_more_than_50_when_update_quality_is_never_more_than_50() {
        Item item = Item.of(SULFURAS, 0, 50);
        
        handler.update(item);
        assertEquals(50, item.quality);
    }

    @Test
    public void given_sulfuras_when_update_quality_never_decreases() {
        Item item = Item.of(SULFURAS, 10, 5);
        
        handler.update(item);
        assertEquals(5, item.quality);
    }

    @Test
    public void given_sulfuras_when_update_quality_never_is_sold() {
        Item item = Item.of(SULFURAS, 10, 5);
        
        handler.update(item);
        assertEquals(10, item.sellIn);
    }

}