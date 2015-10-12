
package com.huawei.esdk.demo.autogen;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class Adapter2
    extends XmlAdapter<String, Integer>
{


    public Integer unmarshal(String value) {
        if (null == value)
        {
            return null;
        }
        return ((int)javax.xml.bind.DatatypeConverter.parseInt(value));
    }

    public String marshal(Integer value) {
        if (value == null) {
            return null;
        }
        return (javax.xml.bind.DatatypeConverter.printInt((int)(int)value));
    }
    
}
