package com.huawei.esdk.demo.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public abstract class Encrypt
{
    private static final Logger LOGGER = Logger.getLogger(Encrypt.class.getName());
    public static String getEncryptPassword(String randomkey, String key)
    {
    	if (StringUtils.isEmpty(key) || StringUtils.isEmpty(randomkey)) {
			return null;
		}
        byte[] encryptPassword;
        MessageDigest md;
        String ep = null;
        try
        {
            md = MessageDigest.getInstance("SHA-256");

            md.update(key.getBytes());
            encryptPassword = md.digest();

            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(BytesUtils.bytesToHexString(encryptPassword));
            String password = sBuilder.toString();

            sBuilder = new StringBuilder();

            sBuilder.append(BytesUtils.bytesToHexString(Base64Utils
                    .getFromBASE64(randomkey)));
            password += sBuilder.toString();

            md.update(password.getBytes());
            encryptPassword = md.digest();

            sBuilder.append(BytesUtils.bytesToHexString(encryptPassword));
            ep = Base64Utils.encode(encryptPassword);
        }
        catch (NoSuchAlgorithmException e)
        {
            LOGGER.log(java.util.logging.Level.WARNING, "Exception happened in getEncryptPassword()", e);
        }
        return ep;
    }
}
