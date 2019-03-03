package main.java.com.gildedrose.item;

import main.java.com.gildedrose.item.GlidedRoseItem;
import main.java.com.gildedrose.item.GlidedRoseItemFacade;
import main.java.com.gildedrose.item.Item;
import main.java.com.gildedrose.item.Quality;

public class GildedRose {

    private static final int POSSIBLE_QUALITY_VALUE = 0;
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            glidedRoseItem(item).updateItemState();
            if (isAItemHaslowestQualityValue(item)) {
                item.quality = POSSIBLE_QUALITY_VALUE;
            } else if (isAItemHasHighestQualityValue(item)) {
                item.quality = Quality.highestValuePossible(item);
            }
        }
    }

    private GlidedRoseItem glidedRoseItem(Item item) {
        return new GlidedRoseItemFacade(item).glidedRoseItem(item);
    }

    private boolean isAItemHaslowestQualityValue(Item item) {
        return item.quality < POSSIBLE_QUALITY_VALUE;
    }

    private boolean isAItemHasHighestQualityValue(Item item) {
        return item.quality > Quality.highestValuePossible(item);
    }
}