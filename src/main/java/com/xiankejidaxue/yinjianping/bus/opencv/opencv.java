package com.xiankejidaxue.yinjianping.bus.opencv;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

/**
 * @Author:yinjianping
 * @Description: opencv操作
 * @Date:Created in 14:25 2019/5/11
 * @Modified By:
 */

public class OpenCV {
    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public Integer faceNum(){
        CascadeClassifier cascadeClassifier = new CascadeClassifier();
        cascadeClassifier.load("D:\\软件安装\\opencv\\opencv\\sources\\data\\haarcascades/haarcascade_frontalface_default.xml");

        try{
            VideoCapture videoCapture = new VideoCapture(0);
            int height = (int)videoCapture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
            int width = (int)videoCapture.get(Videoio.CAP_PROP_FRAME_WIDTH);

            if (height == 0 || width == 0){
                 throw new Exception("摄像头获取失败！");
            }

            //打开一张图片
//            Mat  image = Imgcodecs.imread("");
            Mat image = new Mat();
            videoCapture.read(image);
            //在图片中检测人脸
            MatOfRect faceDetections = new MatOfRect();
            cascadeClassifier.detectMultiScale(image,faceDetections);

            //toArray操作
            Rect[] rects = faceDetections.toArray();

            System.out.println("检测到的人脸数目为："+rects.length);

            //圈出人脸区域
            if (rects != null && rects.length >= 1){
                for (Rect rect : rects){
                    Imgproc.rectangle(image,
                            new Point(rect.x,rect.y),
                            new Point(rect.x+rect.width,rect.y+rect.height),
                            new Scalar(0,0,255),
                            2);
                }
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
            return 0;
    }
}
