package com.k1;

public class Money {

    public int getRub() {
        return rub;
    }

    int rub;

    public int getCop() {
        return cop;
    }

    int cop;

    public Money(int rub, int cop) {
        if (rub >= 0 & cop >= 0 & cop < 100) {
            this.rub = rub;
            this.cop = cop;
        } else throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return rub + " рублей" + cop + " копеек";
    }

    @Override
    public boolean equals(Object test) {
        if (test == this & test instanceof Money)
            return true; else
        if (!(test instanceof Money))
            return false;
        Money other = (Money) test;
        return other.rub == rub && other.cop == cop;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + Integer.hashCode(rub);
        hash = hash * 31 + Integer.hashCode(cop);
        return hash;
    }
}
