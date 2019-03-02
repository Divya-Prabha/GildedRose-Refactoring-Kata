package main.java.com.gildedrose.item;

public class BackstagePassesItem implements GlidedRoseItem {

    private final Item item;
    
    public BackstagePassesItem(Item item) {
        this.item = item;
    }

    public void updateItemState() {
    	getSellingValue();
        if (sellByDayValue(10)) {
            getQuality(1);
        } else if (sellByDayValue(5)) {
        	getQuality(2);
        } else if (sellByDayValue(0)) {
        	getQuality(3);
        } else {
            dropQuality();
        }
    }

    private void getSellingValue() {
        item.sellIn -= 1;
    }

    private boolean sellByDayValue(int day) {
        return item.sellIn > day;
    }

    private void getQuality(int qualityValue) {
        item.quality += qualityValue;
    }

    private void dropQuality() {
        item.quality = 0;
    }
}