package com.gildedrose.handler;

import com.gildedrose.Item;
import org.junit.Test;

import static com.gildedrose.handler.BackstageHandler.ITEM_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by xtrella on 5/5/16.
 */
public class BackstageHandlerTest {

    private BackstageHandler handler = new BackstageHandler();

    @Test
    public void given_backstage_when_accept_should_return_true() {
        assertTrue(handler.accept(Item.of(ITEM_NAME,11,5)));
    }

    @Test
    public void given_not_backstage_when_accept_should_return_false() {
        assertFalse(handler.accept(Item.of("foo",11,5)));
    }

    @Test
    public void given_backstage_and_more_10days_when_update_quality_increases1() {
        Item item = Item.of(ITEM_NAME,11,5) ;
        handler.update(item);
        assertEquals(6, item.quality);
    }

    @Test
    public void given_backstage_10days_when_update_quality_increases2() {
        Item item = Item.of(ITEM_NAME,10,5) ;
        handler.update(item);
        assertEquals(7, item.quality);
    }

    @Test
    public void given_backstage_less_10days_more5_when_update_quality_increases2() {
        Item item = Item.of(ITEM_NAME,8,5) ;
        handler.update(item);
        assertEquals(7, item.quality);
    }

    @Test
    public void given_backstage_5days_when_update_quality_increases3() {
        Item item = Item.of(ITEM_NAME,5,5) ;
        handler.update(item);
        assertEquals(8, item.quality);
    }


    @Test
    public void given_backstage_less_5days_more0_when_update_quality_increases3() {
        Item item = Item.of(ITEM_NAME,4,5) ;
        handler.update(item);
        assertEquals(8, item.quality);
    }

    @Test
    public void given_backstage_0days_when_update_quality_drop_to0() {
        Item item = Item.of(ITEM_NAME,0,5) ;
        handler.update(item);
        assertEquals(0, item.quality);
    }

}