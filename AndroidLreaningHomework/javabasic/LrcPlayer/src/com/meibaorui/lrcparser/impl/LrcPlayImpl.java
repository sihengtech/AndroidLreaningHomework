package com.meibaorui.lrcparser.impl;

import com.meibaorui.lrcparser.bean.LrcInfo;

/**
 * Created by meibaorui on 2015/8/7.
 */
public class LrcPlayImpl implements com.meibaorui.lrcparser.api.LrcPlayer {
    private LrcInfo lrcInfo;

    public LrcPlayImpl(LrcInfo lrcInfo) {
        setLrcInfo(lrcInfo);
    }

    /**
     * 播放lrc
     */
    public void play() {
        printBasicInfo();
        int seconds = 0;
        while (!lrcInfo.getTimeWordsMap().isEmpty()) {
            if (lrcInfo.getTimeWordsMap().containsKey(seconds)) {
                System.out.print(String.format("\r %s", lrcInfo.getTimeWordsMap().get(seconds)));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //TODO：记录错误日志
                System.out.println("播放歌词出错。");
            }
            seconds++;
        }
    }

    private void printBasicInfo() {
        System.out.println("==============================");
        if (lrcInfo.getAlbumName() != null)
            System.out.println("专  辑：" + lrcInfo.getAlbumName());
        if (lrcInfo.getSingName() != null)
            System.out.println("歌  名：" + lrcInfo.getSingName());
        if (lrcInfo.getSingerName() != null)
            System.out.println("演唱者：" + lrcInfo.getSingerName());
        System.out.println("==============================");
    }

    public LrcInfo getLrcInfo() {
        return lrcInfo;
    }

    private void setLrcInfo(LrcInfo lrcInfo) {
        this.lrcInfo = lrcInfo;
    }
}
