package com.steve.ifeve.multipartline.chapter6;

import com.sun.scenario.effect.ImageData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liu on 5/16/17.
 * 这是个加载文本和图片的示例（类似html）
 * 使用completionService使得图片在下载完毕后立即加载出来。
 * 使用CompletionService将Excutor和BlockingQueue的功能联合在一起，它的具体实现类为ExcutorCompletionService
 * 它会在构造函数中创建一个BlockingQueue来保存计算完成的结果，通过blockingQueue的take或者poll方法得到结果，
 *  比起ExecutorService的Future.get()结果更简单明了
 *
 */
public class Render {
    private final ExecutorService executor;

    Render(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source)  {
        List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<ImageData>(executor);
        for(final ImageInfo imageInfo : info){
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }
        renderText();  // 渲染文本
        //渲染文本
        try {
            for (int t = 0, n = info.size(); t < n; t++) {
                Future<ImageData> f = completionService.take();   // 模仿BlockingQueue
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt(); // 中断线程位置
        } catch (ExecutionException e) {
            //throw new Exception(e.getCause()); 抛出实际的异常。
        }
    }

    private void renderImage(ImageData imageData) {
        System.out.println("渲染图像");
    }

    private void renderText() {
        System.out.println("渲染文本。");

    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        //扫描图片
        List<ImageInfo> list = new ArrayList<>();
        ImageInfo image1 = new ImageInfo(3,"image1","url://url1");
        ImageInfo image2 = new ImageInfo(3,"image1","url://url1");
        ImageInfo image3 = new ImageInfo(3,"image1","url://url1");
        list.add(image1);
        list.add(image2);
        list.add(image3);
        return list;
    }

}
