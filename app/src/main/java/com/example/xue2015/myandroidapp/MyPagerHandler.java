package com.example.xue2015.myandroidapp;



import java.lang.ref.WeakReference;


import android.os.Handler;
import android.os.Message;

public class MyPagerHandler extends Handler {

    /**
     * ���������ʾ��View
     */
    public static final int MSG_UPDATE_IMAGE = 1;

    /**
     * ������ͣ�ֲ�
     */
    public static final int MSG_KEEP_SILENT = 2;

    /**
     * ��¼���µ�ҳ�ţ����û��ֶ�����ʱ��Ҫ��¼��ҳ�ţ������ʹ�ֲ���ҳ����� ���統ǰ����ڵ�һҳ������׼�����ŵ��ǵڶ�ҳ������ʱ���û���������ĩҳ��
     * ��Ӧ�ò��ŵ��ǵ�һҳ�������������ԭ���ĵڶ�ҳ���ţ����߼��������⡣
     */
    public static final int MSG_BREAK_SILENT = 3;

    public static final int MSG_PAGE_CHANGED = 4;

    // �ֲ����ʱ��
    public static final long MSG_DELAY = 3000;

    // ʹ�������ñ���Handlerй¶.����ķ��Ͳ������Բ���Activity��Ҳ������Fragment��
    private WeakReference<PointshopActivity> weakReference;
    private int currentItem = 0;

    public MyPagerHandler(WeakReference<PointshopActivity> weakReference) {
        this.weakReference = weakReference;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        PointshopActivity activity = weakReference.get();
        if (activity == null)
            return;
        //�����Ϣ���в��Ƴ�δ���͵���Ϣ������Ҫ�Ǳ����ڸ��ӻ�������Ϣ�����ظ������⡣
        if (activity.handler.hasMessages(MSG_UPDATE_IMAGE))
            activity.handler.removeMessages(MSG_UPDATE_IMAGE);
        switch (msg.what) {
            case MSG_UPDATE_IMAGE:
                currentItem++;
                activity.vp.setCurrentItem(currentItem);
                // ׼���´β���
                activity.handler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE,
                        MSG_DELAY);
                break;
            case MSG_KEEP_SILENT:
                break;
            case MSG_BREAK_SILENT:
                activity.handler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE,
                        MSG_DELAY);
                break;
            case MSG_PAGE_CHANGED:
                // ��¼��ǰ��ҳ�ţ����ⲥ�ŵ�ʱ��ҳ����ʾ����ȷ��
                currentItem = msg.arg1;
                break;
            default:
                break;
        }
    }
}
