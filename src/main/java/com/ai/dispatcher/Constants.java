package com.ai.dispatcher;

public class Constants {

    /**
     * 服务、AI服务器状态
     */
    // 状态可用
    public static final int NonAvailable = 0;
    // 状态不可用
    public static final int Available = 1;

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
