package lifecycle.ru.innobi.lifecycle.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add some sample items.
        addItem(createDummyItem(ITEMS.size(), "Москва"));
        addItem(createDummyItem(ITEMS.size(), "Санкт-Петербург"));
        addItem(createDummyItem(ITEMS.size(), "Ростов-на-Дону"));
        addItem(createDummyItem(ITEMS.size(), "Таганрог"));
        addItem(createDummyItem(ITEMS.size(), "Сочи"));
        addItem(createDummyItem(ITEMS.size(), "Геленджик"));
        addItem(createDummyItem(ITEMS.size(), "Кисловодск"));
        addItem(createDummyItem(ITEMS.size(), "Волгодонск"));
        addItem(createDummyItem(ITEMS.size(), "Новочеркасск"));
        addItem(createDummyItem(ITEMS.size(), "Симферополь"));
        addItem(createDummyItem(ITEMS.size(), "Севастополь"));
        addItem(createDummyItem(ITEMS.size(), "Феодосия"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position, String cityName) {
        return new DummyItem(String.valueOf(position), cityName);
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
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final int temperature;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
            this.temperature = getTemperatureId(id);
        }

        private int getTemperatureId(String id) {
            int temperature;
            switch (id) {
                case "0":
                    temperature = -12;
                    break;
                case "1":
                    temperature = -8;
                    break;
                case "2":
                    temperature = 4;
                    break;
                case "3":
                    temperature = 3;
                    break;
                case "4":
                    temperature = 11;
                    break;
                case "5":
                    temperature = 6;
                    break;
                case "6":
                    temperature = -1;
                    break;
                case "7":
                    temperature = 1;
                    break;
                case "8":
                    temperature = 3;
                    break;
                case "9":
                    temperature = 6;
                    break;
                case "10":
                    temperature = 8;
                    break;
                case "11":
                    temperature = 6;
                    break;
                default:
                    temperature = 0;
                    break;
            }
            return temperature;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
