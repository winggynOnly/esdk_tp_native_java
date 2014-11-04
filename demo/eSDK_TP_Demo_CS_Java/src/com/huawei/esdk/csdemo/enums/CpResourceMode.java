package com.huawei.esdk.csdemo.enums;

public enum CpResourceMode {

    CP_1_1("CP_None"),
    CP_2_1("CP_2_1"),
    CP_3_1("CP_3_1"),
    CP_4_1("CP_4_1"),
    CP_5_1("CP_5_1"),
    CP_6_1("CP_6_1"),
    CP_7_1("CP_7_1"),
    CP_8_1("CP_8_1");
    
    private final String value;

    CpResourceMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CpResourceMode fromValue(String v) {
        for (CpResourceMode c: CpResourceMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
    
    public static Integer getIndex(String v) {
        int i = 0;
        for (CpResourceMode c: CpResourceMode.values()) {
            if (c.value.equals(v)) {
                return i;
            }
          i++;
        }
        throw new IllegalArgumentException(v);
    }
}