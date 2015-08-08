package com.meibaorui.lrcparser.api;

import java.util.HashMap;

/**
 * Created by meibaorui on 2015/8/6.
 */
public interface LrcParser {
    /**
     * 获取歌手名
     *
     * @return 歌手名(没有时返回NULL)
     */
    String getSingerName();

    /**
     * 获取LRC制作者名
     *
     * @return LRC制作者名(没有时返回NULL)
     */
    public String getAuthor();

    /**
     * 获取专辑名
     *
     * @return 专辑名(没有时返回NULL)
     */
    String getAlbumName();

    /**
     * 获取歌曲名
     *
     * @return 歌曲名(没有时返回NULL)
     */
    String getSingName();

    /**
     * 获取时间-内容对应列表
     *
     * @return 时间-内容对应列表(没有时空HashMap)
     */
    HashMap<Integer, String> getTimeWordsMap();
}
