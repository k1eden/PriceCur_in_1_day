package com.k1;

public class Item {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    Money price;

    Item(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object test) {
        if (this == test & test instanceof Item) return true;
        if (test instanceof Item) {
            Item other = (Item) test;
            return name.equals(other.name)
                    && price.equals(other.price);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int result = 1;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        if (price != null) {
            result = (31 * result) + price.hashCode();
        }
        return result;
    }
}
