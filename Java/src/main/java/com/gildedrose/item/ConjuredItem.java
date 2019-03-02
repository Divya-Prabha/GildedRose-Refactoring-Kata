package main.java.com.gildedrose.item;

public class ConjuredItem extends GeneralItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int decreasingValueOverZeroDaysToSell() {
        return 2;
    }
}