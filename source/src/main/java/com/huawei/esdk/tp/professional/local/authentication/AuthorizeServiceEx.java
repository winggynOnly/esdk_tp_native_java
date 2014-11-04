package com.huawei.esdk.tp.professional.local.authentication;

public interface AuthorizeServiceEx
{
    Integer login(String userName,String password);
    
    Integer logout();
    
    Integer keepAlive();
}