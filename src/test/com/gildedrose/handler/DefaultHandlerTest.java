package com.gildedrose.handler;


import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xtrella on 6/5/16.
 */
public class DefaultHandlerTest {

    private DefaultHandler handler = new DefaultHandler();

    @Test
    public void given_foo_and_sell_passed_when_update_quality_degrades_twice() {
        Item item = Item.of("foo",0,6);
        handler.update(item);
        assertEquals(4, item.quality);
    }

    @Test
    public void given_foo_and_not_sell_passed_when_update_quality_degrades() {
        Item item = Item.of("foo",2,10);
        handler.update(item);
        assertEquals(9, item.quality);
    }

    @Test
    public void given_foo_with_quality_zero_when_update_quality_is_never_negative() {
        Item item = Item.of("foo",10,0);
        handler.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void given_foo_when_update_quality_sellIn_decreases() {
        Item item = Item.of("foo",10,10);
        handler.update(item);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void given_any_item_name_when_accept_then_should_accept() {
        assertTrue(handler.accept(Item.of("foo")));
        assertTrue(handler.accept(Item.of("xxx")));
        assertTrue(handler.accept(Item.of(SulfurasHandler.ITEM_NAME)));
    }


}