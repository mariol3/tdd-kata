package it.addiction.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by Mario Grimaldi <m.grimaldi@addiction.it> with <3
 */
public class RecentlyUsedList {
    private static final int UNLIMTED = Integer.MAX_VALUE;

    private Stack<String> words = new Stack<>();
    private final int maxCapacity;

    private RecentlyUsedList() {
        maxCapacity = UNLIMTED;
    }

    public RecentlyUsedList(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int size() {
        return words.size();
    }

    public void insert(String word) {
        if (words.size() < this.maxCapacity) {
            validateWord(word);
            if (words.contains(word)) {
                words.remove(word);
            }
            words.push(word);
        }
    }

    private void validateWord(String word) {
        Objects.requireNonNull(word);
        if (word.isEmpty()) throw new RuntimeException();
    }

    public String get() {
        return words.pop();
    }

    public String lookupItemAt(int index) {
        return words.get(index);
    }

    public static RecentlyUsedList create() {
        return new RecentlyUsedList();
    }
}
