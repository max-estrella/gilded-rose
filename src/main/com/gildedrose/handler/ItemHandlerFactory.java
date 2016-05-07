package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.ItemName;

import java.util.HashMap;
import java.util.Map;

import static com.gildedrose.ItemName.*;

/**
 * Created by xtrella on 5/5/16.
 */
public class ItemHandlerFactory {

    private static final Map<ItemName, ItemHandler> HANDLERS = new HashMap<>();

    static {
        HANDLERS.put(AGED_BRIE, new AgedBrieHandler());
        HANDLERS.put(BACKSTAGE, new BackstageHandler());
        HANDLERS.put(SULFURAS, new SulfurasHandler());
    }

    private static final ItemHandler DEFAULT_HANDLER = new DefaultHandler();

    public static ItemHandler getHandler(Item item) {
        ItemName itemName = ItemName.from(item);
        return HANDLERS.containsKey(itemName)
                ? HANDLERS.get(itemName)
                : DEFAULT_HANDLER;
    }
}
