package com.meibaorui.lrcparser.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by meibaorui on 2015/8/6.
 */
public class LrcParsImpl implements com.meibaorui.lrcparser.api.LrcParser {

    private final String singerNameAttr = "ar";
    private final String authorAttr = "by";
    private final String albumNameAttr = "al";
    private final String singNameAttr = "ti";
    private final String timeReg = "\\[(\\d{2}:\\d{2}\\.?\\d{0,2})\\]";

    private List<String> lrcLines;

    public LrcParsImpl(String lrcFilePath) throws IOException {
        InputStreamReader lrcFileReader = new InputStreamReader(new FileInputStream(lrcFilePath),"utf-8");//FileNotFoundException
        initLrcLinesFromFileReader(lrcFileReader);
    }

    public LrcParsImpl(InputStreamReader lrcFileReader) throws IOException {
        initLrcLinesFromFileReader(lrcFileReader);
    }

    private void initLrcLinesFromFileReader(InputStreamReader lrcFileReader) throws IOException {
        lrcLines = new ArrayList<String>();
        BufferedReader lrcBufferedReader = new BufferedReader(lrcFileReader);
        String lrcLine = null;
        while ((lrcLine = lrcBufferedReader.readLine()) != null) {
            lrcLines.add(lrcLine);
        }
        lrcBufferedReader.close();
        lrcFileReader.close();
    }

    /**
     * 获取歌手名
     *
     * @return 歌手名(没有时返回NULL)
     */
    @Override
    public String getSingerName() {
        return getAttr(singerNameAttr);
    }

    /**
     * 获取LRC制作者名
     *
     * @return LRC制作者名(没有时返回NULL)
     */
    @Override
    public String getAuthor() {
        return getAttr(authorAttr);
    }

    /**
     * 获取专辑名
     *
     * @return 专辑名(没有时返回NULL)
     */
    @Override
    public String getAlbumName() {
        return getAttr(albumNameAttr);
    }

    /**
     * 获取歌曲名
     *
     * @return 歌曲名(没有时返回NULL)
     */
    @Override
    public String getSingName() {
        return getAttr(singNameAttr);
    }

    /**
     * 获取时间-内容对应列表
     *
     * @return 时间-内容对应列表(没有时空HashMap)
     */
    @Override
    public HashMap<Integer, String> getTimeWordsMap() {
        HashMap<Integer, String> timeWordsMap = new HashMap<Integer, String>();
        Pattern pattern = Pattern.compile(timeReg);
        for (String lrcLine : lrcLines) {
            String words = lrcLine.replaceAll(timeReg, "").replace(" ", "");
            Matcher matcher = pattern.matcher(lrcLine);
            while (matcher.find()) {
                int groupCount = matcher.groupCount();
                for (int i = 0; i <= groupCount; i++) {
                    String timeStr = matcher.group(i);
                    Integer seconds = timeStr2timeInt(timeStr);
                    timeWordsMap.put(seconds, words);
                }
            }
        }
        return timeWordsMap;
    }

    private String getAttr(String attrName) {
        for (String lrcLine : lrcLines) {
            if (lrcLine.startsWith("[" + attrName + ":")) {
                return lrcLine.replace("[" + attrName + ":", "").replace("]", "");
            }
        }
        return null;
    }

    private Integer timeStr2timeInt(String timeStr) {
        int seconds = 0;
        timeStr = timeStr.replace("[", "").replace(".", ":").replace("]", "");
        String[] afterSpiltTimeStrArr = timeStr.split(":");
        for (int i = 0; i < afterSpiltTimeStrArr.length; i++) {
            if (i == 0) {
                seconds += Integer.parseInt(afterSpiltTimeStrArr[i]) * 60;
            }
            if (i == 1) {
                seconds += Integer.parseInt(afterSpiltTimeStrArr[i]);
            }
            if (i == 2) {
                break;
            }
        }
        return seconds;
    }
}
