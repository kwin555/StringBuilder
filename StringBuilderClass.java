package com.KevinNguyen.Algorithms;

public class StringBuilderClass {
    private static final int bufferMuliplier = 2;
    private static final int defaultBufferSize = 16;

    private char [] string;
    private int size;
    private int charCount;

    public StringBuilderClass() {
        this.size = defaultBufferSize;
        this.string = new char[defaultBufferSize];
    }

    public StringBuilderClass(int size) {
        this.size = size;
    }

    public StringBuilderClass(char[] string) {
        this.string = string;
    }

    public StringBuilderClass(String string) {
        this.string = string.toCharArray();
    }

    public StringBuilderClass append(String str) {
        while(resizeRequired(str)) {
            resizeBuffer(str);
        }
        addString(str);
        updateCharCount(str.length());
        return this;
    }

    private boolean resizeRequired(String newInput) {
        return this.charCount + newInput.length() > this.size;
    }

    private void resizeBuffer(String newInput) {
        int oldSize = this.size;
        this.size *= bufferMuliplier;
        char[] newStr = new char[this.size];
        System.out.printf("Resizing array: Increasing size from %d to % d\n", oldSize, this.size);
        //Copy to new array
        System.arraycopy(this.string, 0, newStr, 0, oldSize);
        this.string = newStr;
    }

    private void addString(String str) {
        System.arraycopy(str.toCharArray(), 0, this.string, this.charCount, str.length());
    }

    private void updateCharCount(int charCount) {
        this.charCount += charCount;
    }





}
