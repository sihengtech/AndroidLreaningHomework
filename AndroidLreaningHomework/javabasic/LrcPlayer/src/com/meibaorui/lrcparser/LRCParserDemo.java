package com.meibaorui.lrcparser;

import com.meibaorui.lrcparser.bean.LrcInfo;
import com.meibaorui.lrcparser.api.LrcPlayer;
import com.meibaorui.lrcparser.impl.LrcParsImpl;
import com.meibaorui.lrcparser.impl.LrcPlayImpl;

import java.io.IOException;

/**
 * Created by meibaorui on 2015/8/6.
 */
public class LRCParserDemo {
    public static void main(String[] args) throws IOException {
        LrcInfo lrc=new LrcInfo(new LrcParsImpl("appdata//227250.lrc"));
        LrcPlayer lrcPlayer=new LrcPlayImpl(lrc);
        lrcPlayer.play();
    }
}
