package main.java.com.gildedrose.item;

public class AgedBrieItem implements GlidedRoseItem {

    private final Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    public void updateItemState() {
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
