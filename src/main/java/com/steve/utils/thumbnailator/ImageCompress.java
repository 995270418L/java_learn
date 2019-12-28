package com.steve.utils.thumbnailator;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * 图片压缩
 */
public class ImageCompress {

    private static final String src = "C:\\Users\\steve\\Documents\\work\\IMG_20191228_181447.jpg";
    private static final String srcTar = "C:\\Users\\steve\\Documents\\work\\IMG_20191228_181447_0.5.jpg";
    private static final String src1 = "C:\\Users\\steve\\Documents\\work\\IMG_20191228_181457.jpg";
    private static final String src1Tar = "C:\\Users\\steve\\Documents\\work\\IMG_20191228_181457_0.5.jpg";
    private static final String src2 = "C:\\Users\\steve\\Documents\\work\\IMG_20191228_181554.jpg";
    private static final String src2Tar = "C:\\Users\\steve\\Documents\\work\\IMG_20191228_181554_0.5.jpg";

    private static final String src3 = "C:\\Users\\steve\\Documents\\work\\130kb.jpg";
    private static final String src3Tar = "C:\\Users\\steve\\Documents\\work\\130kb_1200.jpg";


    public static void main(String[] args) throws IOException {
        new ImageCompress().changeResolution();
    }

    public void changeResolution() throws IOException {
        Thumbnails.of(src3)
                .size(800, 800)
                .toFile(src3Tar);
    }
    /**
     * 放缩图片
     */
    public void qualityOut() throws IOException {
        Thumbnails.of(new File(src3))
                .scale(1f)
                .outputQuality(0.5f)
                .toFile(new File(src3Tar));
    }
}
