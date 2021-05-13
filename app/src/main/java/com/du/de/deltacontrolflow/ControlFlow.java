package com.du.de.deltacontrolflow;

import android.util.Log;

public class ControlFlow {
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public void start() {
        char[] sentenceToTest = toCharacterArray("The quick red fox jumps over the lazy brown dog");
        char[] missingLetters = new char[26];

        int numOfMissingLetters = 0;

        for (int i = 0; i < alphabet.length; i++) {
            char letterToFind = alphabet[i];
            if (hasLetter(letterToFind, sentenceToTest) == false) {
                missingLetters[numOfMissingLetters] = letterToFind;
                numOfMissingLetters++;
            }
        }

        writeSuccess(numOfMissingLetters, missingLetters, sentenceToTest);
    }

    public void writeSuccess(int aNumMissing, char[] aMissingLetters, char[] aSentence) {
        Log.e("OPERATOR", "testing sentence: " + String.valueOf(aSentence));
        String message = String.valueOf(aNumMissing) + " missing:" + String.valueOf(aMissingLetters);
        Log.e("OPERATOR", message);
    }

    public char[] toCharacterArray(String s) {
        if (s == null) {
            return null;
        }
        char[] array = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i);
        }
        return array;
    }

    public boolean hasLetter(char aLetter, char[] aSentence) {

        boolean found = false;
        int position = 0;
        while (!found) {
            if (aLetter == aSentence[position]) {
                found = true;
            } else if (position == aSentence.length - 1) {
                break;
            } else {
                position++;
            }
        }
        return found;
    }
}