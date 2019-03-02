package main.java.com.gildedrose.item;

public class GeneralItem implements GlidedRoseItem {

    private final Item item;

    public GeneralItem(Item item) {
        this.item = item;
    }

    public void updateItemState() {
    	getSellingValue();
        if (sellByDayValueIsOverZero()) {
        	getQuality(decreasingValueOverZeroDaysToSell());
        } else {
        	getQuality(decreasingValueForZeroOrLessDaysToSell());
        }
    }

    public int decreasingValueOverZeroDaysToSell() {
        return 1;
    }

    private void getSellingValue() {
        item.sellIn -= 1;
    }

    private boolean sellByDayValueIsOverZero() {
        return item.sellIn > 0;
    }

    private void getQuality(int qualityValue) {
        item.quality -= qualityValue;
    }

    private int decreasingValueForZeroOrLessDaysToSell() {
        return decreasingValueOverZeroDaysToSell() * 2;
    }
}