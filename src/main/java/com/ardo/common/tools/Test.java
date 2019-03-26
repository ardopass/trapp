package com.ardo.common.tools;

import com.xiaoleilu.hutool.io.file.FileReader;

public class Test {

    public static void main(String args[]){
        FileReader fileReader = new FileReader("file/6city.json");
        String result = fileReader.readString();
        System.out.println(result);
    }
}
