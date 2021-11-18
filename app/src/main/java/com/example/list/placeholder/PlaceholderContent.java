package com.example.list.placeholder;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.Locale;

public class PlaceholderContent {

    public static final List<PlaceholderItem> ITEMS = new ArrayList<>();

    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("EEEE dd MMMM y", Locale.ENGLISH);
        String date = dateFormat.format(new Date());
        return new PlaceholderItem(String.valueOf(position), date, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;

        public PlaceholderItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        @NonNull
        public String toString() {
            return content;
        }
    }
}