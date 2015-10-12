package com.huawei.esdk.tp.professional.local.bean;

public class TPSDKResponseEx<T>
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
