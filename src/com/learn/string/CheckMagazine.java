package com.learn.string;

import java.util.HashMap;

/**
 *
 */
public class CheckMagazine {

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magMap = new HashMap<>();
        HashMap<String, Integer> noteMap = new HashMap<>();
        for (String str : magazine) {
            if (magMap.containsKey(str)) {
                int count = magMap.get(str);
                magMap.put(str, count + 1);
            } else {
                magMap.put(str, 1);
            }
        }

        for (String str : note) {
            if (noteMap.containsKey(str)) {
                int count = magMap.get(str);
                noteMap.put(str, count + 1);
            } else {
                noteMap.put(str, 1);
            }
        }

        boolean canReplicate = true;
        for (String s : noteMap.keySet()) {
            if (!magMap.containsKey(s) || (magMap.get(s) < noteMap.get(s))) {
                canReplicate = false;
                break;
            }
        }

        System.out.println((canReplicate) ? "Yes" : "No");
    }

    public static void main(String[] args) {
        //checkMagazine();
    }
}
