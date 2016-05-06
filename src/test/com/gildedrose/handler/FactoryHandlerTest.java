package com.gildedrose.handler;

import com.gildedrose.Item;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by xtrella on 5/5/16.
 */
public class FactoryHandlerTest {

    @Test
    public void given_agedBrie_item_when_getHandler_should_return_handler() {
        ItemHandler handler = FactoryHandler.getHandler(Item.of(AgedBrieHandler.ITEM_NAME));
        assertNotNull(handler);
        assertThat(handler, instanceOf(AgedBrieHandler.class));
    }

    @Test
    public void given_backstage_item_when_getHandler_should_return_handler() {
        ItemHandler handler = FactoryHandler.getHandler(Item.of(BackstageHandler.ITEM_NAME));
        assertNotNull(handler);
        assertThat(handler, instanceOf(BackstageHandler.class));
    }

    @Test
    public void given_sulfuras_item_when_getHandler_should_return_handler() {
        ItemHandler handler = FactoryHandler.getHandler(Item.of(SulfurasHandler.ITEM_NAME));
        assertNotNull(handler);
        assertThat(handler, instanceOf(SulfurasHandler.class));
    }

    @Test
    public void given_other_item_when_getHandler_should_return_null() {
        ItemHandler handler = FactoryHandler.getHandler(Item.of("foo",1,4));
        assertThat(handler, instanceOf(DefaultHandler.class));
    }

}