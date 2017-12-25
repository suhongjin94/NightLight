package com.suhongjin.nightlight;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NightLightClientInstrumentedTest {

    private Context context;
    private NightlightClient nightlightClient;

    @Before
    public void setUp() {
        context = InstrumentationRegistry.getTargetContext();
        nightlightClient = NightlightClient.getInstance();
    }

    @Test
    public void testAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.suhongjin.nightlight", context.getPackageName());
    }

    @Test
    /* Ensure color values are passed as params. */
    public void testCreateColorChangeParams() throws Exception {
        int red = 10;
        int green = 20;
        int blue = 30;

        String body = nightlightClient.createColorChangeParams(red, green, blue);
        JSONObject testJson = new JSONObject(body);
        assertEquals(testJson.get(Utils.POST_RED_PARAM), red);
        assertEquals(testJson.get(Utils.POST_GREEN_PARAM), green);
        assertEquals(testJson.get(Utils.POST_BLUE_PARAM), blue);
    }
}
