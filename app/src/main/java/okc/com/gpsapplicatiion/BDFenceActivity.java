package okc.com.gpsapplicatiion;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.api.fence.CreateFenceRequest;
import com.baidu.trace.api.fence.CreateFenceResponse;
import com.baidu.trace.api.fence.DeleteFenceResponse;
import com.baidu.trace.api.fence.FenceListResponse;
import com.baidu.trace.api.fence.HistoryAlarmResponse;
import com.baidu.trace.api.fence.MonitoredStatusByLocationResponse;
import com.baidu.trace.api.fence.MonitoredStatusResponse;
import com.baidu.trace.api.fence.OnFenceListener;
import com.baidu.trace.api.fence.UpdateFenceResponse;
import com.baidu.trace.model.CoordType;

/**
 * Created by yinyu-tiejiang on 18-3-22.
 */

public class BDFenceActivity extends Activity {

    // 请求标识
    int tag = 3;
    // 轨迹服务ID
    long serviceId = 0;
    // 围栏名称
    String fenceName = "local_circle";
    // 监控对象
    String monitoredPerson = "myTrace";
    // 围栏圆心
    com.baidu.trace.model.LatLng center = new com.baidu.trace.model.LatLng(39.9151190000, 116.4039630000);
    // 围栏半径（单位 : 米）
    double radius = 2000;
    // 去噪精度
    int denoise = 200;
    // 坐标类型
    CoordType coordType = CoordType.bd09ll;
    private LBSTraceClient mTraceClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdfence);

        // 创建本地圆形围栏请求实例
        CreateFenceRequest localCircleFenceRequest = CreateFenceRequest.buildLocalCircleRequest(tag, serviceId,fenceName, monitoredPerson, center, radius, denoise, coordType);
        mTraceClient = new LBSTraceClient(this);

        // 初始化围栏监听器
        OnFenceListener mFenceListener = new OnFenceListener() {
            // 创建围栏回调
            @Override
            public void onCreateFenceCallback(CreateFenceResponse response) {}
            // 更新围栏回调
            @Override
            public void onUpdateFenceCallback(UpdateFenceResponse response) {}
            // 删除围栏回调
            @Override
            public void onDeleteFenceCallback(DeleteFenceResponse response) {}
            // 围栏列表回调
            @Override
            public void onFenceListCallback(FenceListResponse response) {}
            // 监控状态回调
            @Override
            public void onMonitoredStatusCallback(MonitoredStatusResponse
                                                          response) {}
            // 指定位置监控状态回调
            @Override
            public void onMonitoredStatusByLocationCallback(MonitoredStatusByLocationResponse response) {}
            // 历史报警回调
            @Override
            public void onHistoryAlarmCallback(HistoryAlarmResponse response) {}
        };

        // 创建本地圆形围栏
        mTraceClient.createFence(localCircleFenceRequest, mFenceListener);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
