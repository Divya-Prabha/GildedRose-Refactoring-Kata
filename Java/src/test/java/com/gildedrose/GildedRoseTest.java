package test.java.com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.com.gildedrose.GildedRose;
import main.java.com.gildedrose.item.Item;

public class GildedRoseTest {
	
	public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public final static String CONJURED_ITEM = "Conjured";
	

    @Test
    public void foo() {
    	GildedRose app = getGildedRose("foo", 0, 0);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void generalItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = getGildedRose("general item", 0, 0);

        app.updateQuality();

        assertEquals(-1, itemSellByDayNumber(app));
    }

    @Test
    public void brieDecreasesSellByDayNumberEachTime() {
        GildedRose app = getGildedRose(BRIE, 0, 0);

        app.updateQuality();

        assertEquals(-1, itemSellByDayNumber(app));
    }

    @Test
    public void backstagePassesItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = getGildedRose(BACKSTAGE_PASSES_ITEM, 0, 0);

        app.updateQuality();

        assertEquals(-1, itemSellByDayNumber(app));
    }

    @Test
    public void conjuredItemDecreasesSellByDayNumberEachTime() {
        GildedRose app = getGildedRose(CONJURED_ITEM, 0, 0);

        app.updateQuality();

        assertEquals(-1, itemSellByDayNumber(app));
    }

    @Test
    public void brieIncreasesInQualityEachTime() {
        GildedRose app = getGildedRose(BRIE, 1, 1);

        app.updateQuality();

        assertEquals(2, itemQualityValue(app));
    }

    @Test
    public void brieQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = getGildedRose(BRIE, 1, 49);

        app.updateQuality();
        app.updateQuality();

        assertEquals(50, itemQualityValue(app));
    }

    @Test
    public void backstagePassesItemDecreasesQualityByOneIfSellByDayMoreThanEleven() {
        GildedRose app = getGildedRose(BACKSTAGE_PASSES_ITEM, 12, 1);

        app.updateQuality();

        assertEquals(2, itemQualityValue(app));
    }

    @Test
    public void backstagePassesItemDecreasesQualityByTwoIfSellByDayIsMoreThanSix() {
        GildedRose app = getGildedRose(BACKSTAGE_PASSES_ITEM, 10, 1);

        app.updateQuality();

        assertEquals(3, itemQualityValue(app));
    }

    @Test
    public void backstagePassesItemDecreasesQualityByThreeIfSellByDayIsMoreThanZero() {
        GildedRose app = getGildedRose(BACKSTAGE_PASSES_ITEM, 5, 1);

        app.updateQuality();

        assertEquals(4, itemQualityValue(app));
    }

    @Test
    public void backstagePassesItemQualityDropsToZeroIfSellByDayIsZeroOrLess() {
        GildedRose app = getGildedRose(BACKSTAGE_PASSES_ITEM, 0,50);

        app.updateQuality();

        assertEquals(0, itemQualityValue(app));
    }

    @Test
    public void backstagePassesItemQualityCannotGoAboveFiftyWhenIncreasing() {
        GildedRose app = getGildedRose(BACKSTAGE_PASSES_ITEM, 5, 50);

        app.updateQuality();

        assertEquals(50, itemQualityValue(app));
    }

    @Test
    public void generalItemDecreasesQualityByOneIfSellByDayIsAboveZero() {
       GildedRose app = getGildedRose("foo", 2, 1);

       app.updateQuality();

       assertEquals(0, itemQualityValue(app));
    }

    @Test
    public void generalItemDecreasesQualityByTwoOnceSellByDayIsZeroOrLess() {
        GildedRose app = getGildedRose("foo",0, 5);

        app.updateQuality();

        assertEquals(3, itemQualityValue(app));
    }

    @Test
    public void generalItemCannotHaveQualityBelowZero() {
        GildedRose app = getGildedRose("foo", 0, 0);

        app.updateQuality();

        assertEquals(0, itemQualityValue(app));
    }

    @Test
    public void sulfurasHasQualityEighty() {
        GildedRose app = getGildedRose(SULFURAS, 1, 80);

        assertEquals(80, itemQualityValue(app));
    }

    @Test
    public void sulfurasItemDoesNotAlterValues() {
        GildedRose app = getGildedRose(SULFURAS, 1, 80);

        app.updateQuality();

        assertEquals(80, itemQualityValue(app));
        assertEquals(1, itemSellByDayNumber(app));
    }

    @Test
    public void conjuredItemDecreasesQualityByTwoIfSellByDayIsAboveZero() {
        GildedRose app = getGildedRose(CONJURED_ITEM, 2, 5);

        app.updateQuality();

        assertEquals(3, itemQualityValue(app));
    }

    @Test
    public void conjuredItemDecreasesQualityByFourOnceSellByDayIsZeroOrLess() {
        GildedRose app = getGildedRose(CONJURED_ITEM,0, 5);

        app.updateQuality();

        assertEquals(1, itemQualityValue(app));
    }

    @Test
    public void conjuredItemCannotHaveQualityBelowZero() {
        GildedRose app = getGildedRose(CONJURED_ITEM, 0, 0);

        app.updateQuality();

        assertEquals(0, itemQualityValue(app));
    }

    private GildedRose getGildedRose(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }

    private int itemSellByDayNumber(GildedRose app) {
        return app.items[0].sellIn;
    }

    private int itemQualityValue(GildedRose app) {
        return app.items[0].quality;
    }
}