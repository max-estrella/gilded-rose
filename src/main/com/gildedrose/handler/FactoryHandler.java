package com.gildedrose.handler;

import com.gildedrose.Item;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xtrella on 5/5/16.
 */
public class FactoryHandler {

    private static final List<ItemHandler> handlers = Arrays.asList(
            new AgedBrieHandler()
    );

    public static ItemHandler getHandler(Item item) {
        return handlers.stream()
                .filter(itemHandler -> itemHandler.accept(item))
                .findFirst()
                .orElse(null);
    }
}
