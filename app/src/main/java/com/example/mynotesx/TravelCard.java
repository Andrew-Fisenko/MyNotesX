package com.example.mynotesx;

public class TravelCard {

    private String name;
    private int imageResourceId;

    public static final TravelCard[] travelCards = {
            new TravelCard("Тверь", R.drawable.tver),
            new TravelCard("Рязань", R.drawable.razan),
            new TravelCard("Калининград", R.drawable.kaliningrad),
            new TravelCard("Выборг", R.drawable.viborg),
            new TravelCard("Великий Новгород", R.drawable.novgorod_v),
            new TravelCard("Волгоград", R.drawable.volgograd),
            new TravelCard("Гродно", R.drawable.grodno)

    };

    private TravelCard(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
}