package com.huawei.esdk.csdemo.enums;


public enum ContinuousPresenceMode {

    CP_NONE("CP_None"),
    CP_1_1("CP_1_1"),
    CP_2_1("CP_2_1"),
    CP_2_2("CP_2_2"),
    CP_2_3("CP_2_3"),
    CP_3_1("CP_3_1"),
    CP_3_2("CP_3_2"),
    CP_3_3("CP_3_3"),
    CP_3_4("CP_3_4"),
    CP_3_5("CP_3_5"),
    CP_3_6("CP_3_6"),
    CP_4_1("CP_4_1"),
    CP_4_2("CP_4_2"),
    CP_4_3("CP_4_3"),
    CP_4_4("CP_4_4"),
    CP_4_5("CP_4_5"),
    CP_4_6("CP_4_6"),
    CP_5_1("CP_5_1"),
    CP_5_2("CP_5_2"),
    CP_5_3("CP_5_3"),
    CP_5_4("CP_5_4"),
    CP_6_1("CP_6_1"),
    CP_6_2("CP_6_2"),
    CP_6_3("CP_6_3"),
    CP_6_4("CP_6_4"),
    CP_6_5("CP_6_5"),
    CP_7_1("CP_7_1"),
    CP_7_2("CP_7_2"),
    CP_7_3("CP_7_3"),
    CP_7_4("CP_7_4"),
    CP_7_5("CP_7_5"),
    CP_8_1("CP_8_1"),
    CP_8_2("CP_8_2"),
    CP_8_3("CP_8_3"),
    CP_8_4("CP_8_4"),
    CP_9_1("CP_9_1"),
    CP_10_1("CP_10_1"),
    CP_10_2("CP_10_2"),
    CP_10_3("CP_10_3"),
    CP_10_4("CP_10_4"),
    CP_10_5("CP_10_5"),
    CP_10_6("CP_10_6"),
    CP_13_1("CP_13_1"),
    CP_13_2("CP_13_2"),
    CP_13_3("CP_13_3"),
    CP_13_4("CP_13_4"),
    CP_13_5("CP_13_5"),
    CP_16_1("CP_16_1"),
    CP_20_1("CP_20_1"),
    CP_24_1("CP_24_1");
    private final String value;

    ContinuousPresenceMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContinuousPresenceMode fromValue(String v) {
        for (ContinuousPresenceMode c: ContinuousPresenceMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
    
    public static Integer getIndex(String v) {
    	int i = 0;
        for (ContinuousPresenceMode c: ContinuousPresenceMode.values()) {
            if (c.value.equals(v)) {
                return i;
            }
          i++;
        }
        throw new IllegalArgumentException(v);
    }
}
