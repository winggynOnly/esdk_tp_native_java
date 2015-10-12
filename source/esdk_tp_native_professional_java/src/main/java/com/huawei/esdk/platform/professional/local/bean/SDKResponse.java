package com.huawei.esdk.platform.professional.local.bean;

public class SDKResponse<T>
{
    private int resultCode;

    private T result;

    public T getResult()
    {
        return result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }

    public int getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(int resultCode)
    {
        this.resultCode = resultCode;
    }

}
