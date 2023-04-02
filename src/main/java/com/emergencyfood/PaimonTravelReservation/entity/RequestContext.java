package com.emergencyfood.PaimonTravelReservation.entity;

public class RequestContext {
    private final static ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public static void set(String value) {
        LOCAL.set(value);
    }

    public static String get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}

