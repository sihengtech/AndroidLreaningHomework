package com.meibaorui.lrcparser.bean;

import com.meibaorui.lrcparser.api.LrcParser;

import java.util.HashMap;

/**
 * Created by meibaorui on 2015/8/6.
 */
public class LrcInfo {
    /**
     * 歌手名
     */
    private String singerName;
    /**
     * LRC制作者名
     */
    private String author;
    /**
     * 专辑名
     */
    private String albumName;
    /**
     * 曲名
     */
    private String singName;
    /**
     * 时间-内容对应列表
     */
    private HashMap<Integer, String> timeWordsMap;

    /**
     * LrcInfo通过LRC解析器构造函数
     *
     * @param lrcParser LRC解析器
     */
    public LrcInfo(LrcParser lrcParser) {
        setSingerName(lrcParser.getSingerName());
        setAuthor(lrcParser.getAuthor());
        setAlbumName(lrcParser.getAlbumName());
        setSingName(lrcParser.getSingName());
        setTimeWordsMap(lrcParser.getTimeWordsMap());
    }

    /**
     * LrcInfo构造函数
     *
     * @param singerName   歌手名
     * @param author       LRC制作者名
     * @param albumName    专辑名
     * @param singName     曲名
     * @param timeWordsMap 时间-内容对应列表
     */
    public LrcInfo(String singerName, String author, String albumName,
                   String singName, HashMap<Integer, String> timeWordsMap) {
        setSingerName(singerName);
        setAuthor(author);
        setAlbumName(albumName);
        setSingName(singName);
        setTimeWordsMap(timeWordsMap);

    }

    private void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    private void setSingName(String singName) {
        this.singName = singName;
    }

    private void setTimeWordsMap(HashMap<Integer, String> timeWordsMap) {
        this.timeWordsMap = timeWordsMap;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getAuthor() {
        return author;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getSingName() {
        return singName;
    }

    public HashMap<Integer, String> getTimeWordsMap() {
        return timeWordsMap;
    }
}
