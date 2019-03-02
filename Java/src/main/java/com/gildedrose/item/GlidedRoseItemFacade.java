package main.java.com.gildedrose.item;

import java.util.HashMap;
import java.util.Map;

public class GlidedRoseItemFacade {

    private final static Map<String, GlidedRoseItem> ITEMS_LIST = new HashMap<>();
    
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public final static String CONJURED_ITEM = "Conjured";

    public GlidedRoseItemFacade(Item item) {
        ITEMS_LIST.put(SULFURAS, new SulfurasItem());
        ITEMS_LIST.put(BRIE, new AgedBrieItem(item));
        ITEMS_LIST.put(BACKSTAGE_PASSES_ITEM, new BackstagePassesItem(item));
        ITEMS_LIST.put(CONJURED_ITEM, new ConjuredItem(item));
    }

    public GlidedRoseItem glidedRoseItem(Item item) {
        if (isGeneralItem(item)) {
            return new GeneralItem(item);
        }
        return ITEMS_LIST.get(item.name);
    }

    private boolean isGeneralItem(Item item) {
        return !ITEMS_LIST.keySet().contains(item.name);
    }
}
