package ru.tfomsrm.tfoms.other;

import java.io.FileInputStream;

public class SQLReader {

    private String path;
    private String filename;

    public SQLReader(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }

    public String read() throws Exception{

        FileInputStream fileInputStream = new FileInputStream(path + "/" + filename);
        StringBuilder stringBuilder = new StringBuilder();

        int ch;
        while ((ch = fileInputStream.read()) != -1){
            stringBuilder.append((char) ch);
        }

        return stringBuilder.toString();
    }
}
