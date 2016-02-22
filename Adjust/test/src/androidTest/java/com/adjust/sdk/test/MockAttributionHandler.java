package com.adjust.sdk.test;

import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.IActivityHandler;
import com.adjust.sdk.IAttributionHandler;
import com.adjust.sdk.SessionResponseData;

/**
 * Created by pfms on 09/01/15.
 */
public class MockAttributionHandler implements IAttributionHandler {
    private MockLogger testLogger;
    private String prefix = "AttributionHandler ";
    IActivityHandler activityHandler;
    ActivityPackage attributionPackage;
    SessionResponseData lastSessionResponseData;

    public MockAttributionHandler(MockLogger testLogger) {
        this.testLogger = testLogger;
    }

    @Override
    public void init(IActivityHandler activityHandler,
                     ActivityPackage attributionPackage,
                     boolean startPaused,
                     boolean hasListener) {
        testLogger.test(prefix + "init, startPaused: " + startPaused +
                ", hasListener: " + hasListener);
        this.activityHandler = activityHandler;
        this.attributionPackage = attributionPackage;
    }

    @Override
    public void getAttribution() {
        testLogger.test(prefix + "getAttribution");
    }

    @Override
    public void checkSessionResponse(SessionResponseData responseData) {
        testLogger.test(prefix + "checkSessionResponse");

        this.lastSessionResponseData = responseData;
    }

    @Override
    public void pauseSending() {
        testLogger.test(prefix + "pauseSending");
    }

    @Override
    public void resumeSending() {
        testLogger.test(prefix + "resumeSending");
    }
}
