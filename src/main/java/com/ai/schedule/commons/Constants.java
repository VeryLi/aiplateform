package com.ai.schedule.commons;

public class Constants {

    public static final String TraceId = "traceId";

    // 1-人体、2-车辆、3-人脸、4-非机动车
    private static final int BodyObject = 1;
    private static final int VehicleObject = 2;
    private static final int FaceObject = 3;
    private static final int NonVehicleObject = 4;

    /**
     * 服务、AI服务器状态
     */
    // 状态可用
    public static final int NonAvailable = 0;
    // 状态不可用
    public static final int Available = 1;

    /**
     * 返回状态码
     */
    public static final int Successful = 0;
    public static final int Failed = 1;

    /**
     * 流类型
     * 1-实时视频流rtsp、2-离线视频包、3-实时图片流、4-离线图片文件包
     */
    public static final int RealTimeVideoStream = 1;
    public static final int OfflineVideoPackage = 2;
    public static final int RealTimePictureStream = 3;
    public static final int OfflinePicturePackage = 4;

    /**
     * 算法服务类型
     */
    // 视频解析算法
    public static final int VideoAnalysisAlgorithm = 1;
    // 图片解析算法
    public static final int PictureAnalysisAlgorithm = 2;
    // 图片比对算法
    public static final int PictureComparisonAlgorithm = 3;

    /**
     * Task状态
     */
    // 进行中
    public static final int Running = 1;
    // 已完成
    public static final int Completed = 2;
}
