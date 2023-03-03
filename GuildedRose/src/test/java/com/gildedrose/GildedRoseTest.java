package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {
    //test Sulfuras
    @Test
    void sulfurasNameTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
    }

    @Test
    void sulfurasQualityTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasSellInTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void sulfurasBadQualityTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertNotEquals(79, app.items[0].quality);
    }

    @Test
    void sulfurasBadSellInTest() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",10 , 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertNotEquals(9, app.items[0].quality);
    }

    @Test
    void SellInPeremptionTest() {
        Item[] items = new Item[] { new Item("unItemRandom",-5 , 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void qualityNotNegativeTest() {
        Item[] items = new Item[] { new Item("unItemRandom", 20, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieQualityTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 20, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }
    @Test
    void backstagePassesPeremptionTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void backstagePassesQualityTest() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityAfter10Test() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityAfter5Test() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void BrieQualityNotOver50Test() {
        Item[] items = new Item[] { new Item("Aged Brie", 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }





}
