package main.java.com.gildedrose.item;

public final class Quality {

    public static int highestValuePossible(Item item) {
        if (item.name.equals(GlidedRoseItemFacade.SULFURAS)) {
            return 80;
        }
        return 50;
    }
}