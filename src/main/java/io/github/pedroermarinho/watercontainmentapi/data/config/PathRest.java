package io.github.pedroermarinho.watercontainmentapi.data.config;

public class PathRest {
    private PathRest() {
        throw new IllegalStateException("Utility class");
    }

    public static final String API = "/api";
    public static final String VERSION = "/v1";

    public static final String SENSOR = "/sensor";
    public static final String LED = "/led";
}
