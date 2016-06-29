package com.qunar.java.countmostimport;

import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: 刘能
 * Date: 16-6-28
 * Time: 上午3:01
 * 功能：根据指定项目目录下（可以认为是java源文件目录）中，统计被import最多的类，前十个是什么
 */
public class CountMostImport {

    private HashMap<String, Integer> classTimes = new HashMap<String, Integer>();
    private static final String directorStr = "D:\\commonsoftware\\IntelliJIDEA\\IntelliJ IDEA 10.0.2\\qunar\\src\\com\\qunar\\java\\exchangerate";

    public static void main(String[] args) {
        CountMostImport cmi = new CountMostImport();
        cmi.fileTraversal(directorStr);
        ArrayList<Map.Entry<String, Integer>> list = cmi.sortHashMap(cmi.getClassTimes());
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }


    public void fileTraversal(String fileDirectory) {
        File file = new File(fileDirectory);
        String[] fList = file.list();
        for (String fileName : fList) {
            getClassTimes(fileName);
        }
    }

    public void setClassTimes(HashMap<String, Integer> classTimes) {
        this.classTimes = classTimes;
    }

    public HashMap<String, Integer> getClassTimes() {
        return classTimes;
    }

    public ArrayList<Map.Entry<String, Integer>> sortHashMap(HashMap<String, Integer> map) {
        //将map.entrySet()转换成list
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //降序排序
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }


    public void getClassTimes(String fileName) {
        try {
            InputStreamReader inStrR = new InputStreamReader(new FileInputStream(directorStr + "/" + fileName)); //byte streams to character streams
            BufferedReader br = new BufferedReader(inStrR);
            String line = br.readLine();
            while (line != null) {
                if (line.contains("import") && !line.contains("*")) {
                    String key = line.substring(line.lastIndexOf(".") + 1, line.length() - 1);
                    if (classTimes.containsKey(key)) {
                        int times = classTimes.get(key);
                        classTimes.put(key, ++times);
                    } else {
                        classTimes.put(key, 1);
                    }
                }
                line = br.readLine();
            }
            br.close();
            inStrR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}