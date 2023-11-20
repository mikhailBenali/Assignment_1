package gui_swing_events;

import java.util.ArrayList;
import java.util.Collections;

public class Excel {

    private static ArrayList<Double> field = new ArrayList<>();

    public Excel(ArrayList<Double> numbers){
        field = numbers;
    }

    public Excel(String s) {
        String[] list_s = s.split(" ");
        for (String word : list_s){
            if (word.length() > 0){
                field.add(Double.parseDouble(word));
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (double number : Excel.field) {
            total += number;
        }
        field.clear();
        return total;
    }

    public double getAverage() {
        double total = 0;
        for (double number : Excel.field) {
            total += number;
        }
        total /= Excel.field.size();
        field.clear();
        return total;
    }

    public double getMaximum() {
        double total = Collections.max(Excel.field);
        field.clear();
        return total;
    }

    public double getMinimum() {
        double total = Collections.min(Excel.field);
        field.clear();
        return total;
    }
}