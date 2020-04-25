package com.k1;

import static org.junit.jupiter.api.Assertions.*;

class PriceCurTest {

    @org.junit.jupiter.api.Test
    void adder() throws Exception {
        PriceCur test = new PriceCur();
        test.adder(1, new Item("light",  new Money(5, 92)));
        test.adder(2, new Item("rain",  new Money(34, 99)));
        test.adder(5, new Item("jer",  new Money(1234, 0)));
        test.adder(102, new Item("fork",  new Money(221, 83)));
        assertEquals(test.getById(2), new Item("rain",  new Money(34, 99)));
        assertEquals(test.getById(1), new Item("light",  new Money(5, 92)));
        assertEquals(test.getById(5), new Item("jer",  new Money(1234, 0)));
        assertEquals(test.getById(102), new Item("fork",  new Money(221, 83)));
    }

    @org.junit.jupiter.api.Test
    void changerP() throws Exception {
        PriceCur res = new PriceCur();
        PriceCur res1 = new PriceCur();
        res.adder(1, new Item("bed", new Money (999,20)));
        res.adder(2, new Item("cheer", new Money (140,25)));
        res1.adder(1, new Item("bed", new Money (999,20)));
        res1.adder(2, new Item("cheer", new Money (140,25)));

        res.changerP(1,new Money(900, 0));
        res.changerP(2, new Money(0, 0));
        assertNotEquals(res, res1);
    }

    @org.junit.jupiter.api.Test
    void changerN() throws Exception {
        PriceCur res = new PriceCur();
        PriceCur res1 = new PriceCur();
        res.adder(1, new Item("bed", new Money (999,20)));
        res.adder(2, new Item("cheer", new Money (140,25)));
        res1.adder(1, new Item("bed", new Money (999,20)));
        res1.adder(2, new Item("cheer", new Money (140,25)));

        res.changerN(1, "bad");
        res1.changerN(2,"cher");
        assertNotEquals(res.getById(1).getName(), res1.getById(1).getName());
        assertNotEquals(res.getById(2).getName(), res1.getById(2).getName());
    }

    @org.junit.jupiter.api.Test
    void delete() throws Exception {
        PriceCur res = new PriceCur();
        PriceCur res1 = new PriceCur();

        res.adder(1, new Item("flat", new Money(3303,23)));
        res1.adder(1, new Item("flat", new Money(3303,23)));
        res.delete(1);
        assertNotEquals(res,res1 );
        res1.delete(1);
        assertEquals(res, res1);
    }

    @org.junit.jupiter.api.Test
    void getById() throws Exception {
        PriceCur res = new PriceCur();

        res.adder(3, new Item("ball", new Money(50,0)));
        assertEquals(res.getById(3), new Item("ball", new Money(50,0)));
    }

    @org.junit.jupiter.api.Test
    void totalCost() throws Exception {
        PriceCur res = new PriceCur();

        res.adder(2, new Item("glass", new Money(22,22)));
        res.adder(3, new Item("gl", new Money(33,33)));
        assertEquals(res.totalCost(2,2), new Money(44,44));
        assertEquals(res.totalCost(3,4), new Money(133, 32));
    }
}