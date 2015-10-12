package com.huawei.esdk.platform.professional.local.impl.autogen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.10
 * 2014-10-17T16:40:08.918+08:00
 * Generated source version: 2.6.10
 * 
 */
@WebService(targetNamespace = "esdk_platform", name = "Platform.KeyMgr")
@XmlSeeAlso({ObjectFactory.class})
public interface PlatformKeyMgr {

    @WebResult(name = "resultCode", targetNamespace = "")
    @RequestWrapper(localName = "setSecretKey", targetNamespace = "esdk_platform", className = "com.huawei.esdk.platform.professional.local.impl.autogen.SetSecretKey")
    @WebMethod(action = "esdk_platformsetSecretKey")
    @ResponseWrapper(localName = "setSecretKeyResponse", targetNamespace = "esdk_platform", className = "com.huawei.esdk.platform.professional.local.impl.autogen.SetSecretKeyResponse")
    public int setSecretKey(
        @WebParam(name = "secretType", targetNamespace = "")
        java.lang.String secretType,
        @WebParam(name = "secretKey", targetNamespace = "")
        java.lang.String secretKey,
        @WebParam(name = "iv", targetNamespace = "")
        java.lang.String iv
    );

    @RequestWrapper(localName = "getPublicKey", targetNamespace = "esdk_platform", className = "com.huawei.esdk.platform.professional.local.impl.autogen.GetPublicKey")
    @WebMethod(action = "esdk_platformgetPublicKey")
    @ResponseWrapper(localName = "getPublicKeyResponse", targetNamespace = "esdk_platform", className = "com.huawei.esdk.platform.professional.local.impl.autogen.GetPublicKeyResponse")
    public void getPublicKey(
        @WebParam(name = "secretType", targetNamespace = "")
        java.lang.String secretType,
        @WebParam(mode = WebParam.Mode.OUT, name = "resultCode", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.Integer> resultCode,
        @WebParam(mode = WebParam.Mode.OUT, name = "publicKey", targetNamespace = "")
        javax.xml.ws.Holder<java.lang.String> publicKey
    );
}
