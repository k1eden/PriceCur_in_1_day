package com.k1;

import java.util.HashMap;

public class PriceCur {
    private HashMap<Integer, Item> cur = new HashMap<>();

    public void adder(int id, Item item) throws Exception {
        if (!cur.containsKey(id)) cur.put(id, item); else
            throw new Exception("Current item is already added");
    }

    public void changerP(int id, Money price) throws Exception {
        if (!cur.containsKey(id)) throw new Exception("You cannot change the price of a non-existing item"); else
        cur.get(id).setPrice(price);
    }

    public void changerN(int id, String name) throws Exception {
        if (!cur.containsKey(id)) throw new Exception("You cannot change the name of a non-existing item"); else
        cur.get(id).setName(name);
    }

    public void delete(int id) throws Exception {
        if (!cur.containsKey(id)) throw new Exception("You can't delete non-existing item"); else
        cur.remove(id);
    }

    public Item getById(int id) throws Exception {
        if (!cur.containsKey(id)) throw new Exception("Invalid Id");
        return cur.get(id);
    }

    public Money totalCost(int id, int number) {
        if (cur.get(id).price.cop * number > 99) {
            int rub = cur.get(id).getPrice().getRub() * number + cur.get(id).price.getCop() * number / 100;
            int cop = cur.get(id).getPrice().getCop() * number % 100;
            return new Money(rub, cop);
        } else {
            int rub = cur.get(id).getPrice().getRub() * number;
            int cop = cur.get(id).getPrice().getCop() * number;
            return new Money(rub, cop);
        }
    }

    @Override
    public String toString() {
        StringBuilder overRideBuilder = new StringBuilder();
            for (int code : cur.keySet()) {
                overRideBuilder.append("Code: ").append(code).
                        append("Name: ").append(cur.get(code).getName()).
                        append("Price: ").append(cur.get(code).getPrice());
            }
            return overRideBuilder.toString();

    }

    @Override
    public int hashCode() {
        return cur.hashCode();
    }

    @Override
    public boolean equals(Object test) {
        if (this == test & test instanceof PriceCur) return true;
        if (test instanceof PriceCur) {
            PriceCur other = (PriceCur) test;
            return cur.equals(other.cur);
        }
        return false;
    }
}
