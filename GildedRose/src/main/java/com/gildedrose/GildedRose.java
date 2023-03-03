package com.gildedrose;


class GildedRose {
    Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            int levelQuality = 1;
            if (items[i].name != "Sulfuras, Hand of Ragnaros"){
                items[i].sellIn = items[i].sellIn - 1;
            }
            switch (items[i].name) {

                case "Aged Brie":
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                            if (items[i].sellIn < 6) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                            if (items[i].sellIn <= 0){
                                items[i].quality = 0;
                            }
                    }
                    break;

                default:
                    if (items[i].getClass() == ItemConjured.class){
                        levelQuality++;
                    }

                    if (items[i].sellIn < 0 && items[i].quality > levelQuality) {
                        items[i].quality = items[i].quality - levelQuality * 2;
                    }
                    else if (items[i].quality > 0){
                        items[i].quality = items[i].quality - levelQuality;
                    }
            }
        }
    }
}
