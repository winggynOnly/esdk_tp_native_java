package com.huawei.esdk.platform.professional.local.service.common;

import com.huawei.esdk.platform.professional.local.bean.SDKResponse;

public interface PlatformKeyServiceEx
{
    SDKResponse<String> getPublicKey(String secretType);
    
    Integer setSecretKey(String secretType, String secretKey, String iv);
}
