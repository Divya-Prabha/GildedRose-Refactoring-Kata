package com.gildedrose.item;

public class AgedBrie implements GlidedRoseItem {

    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    public void updateState() {
        getSellingValue();
        getQualityValue();
    }

    private void getSellingValue() {
        item.sellIn -= 1;
    }

    private void getQualityValue() {
        item.quality += 1;
    }
}
