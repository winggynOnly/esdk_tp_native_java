package com.huawei.esdk.tp.professional.local.impl.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AESCbc128Utils
{
    private static final int AES_128_KEY_LEN = 16; // 128 bit
    
    private static final byte[] BT_KEY = getBytes("PASSWORD@ESDKNATIVE12");
    
    private static final byte[] BT_IV = getBytes("INITIAL@NATIVE12");
    
    private static byte[] getBytes(String str)
    {
        try
        {
            return str.getBytes("UTF-8");
        }
        catch(UnsupportedEncodingException e)
        {
            return null;
        }
    }
    
    /**
     * @param btPlain 明文
     * @return 密文
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static byte[] encode(byte[] btPlain) throws BadPaddingException,
            IllegalBlockSizeException, InvalidAlgorithmParameterException,
            InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException
    {
        return encodeDecode(btPlain, BT_KEY, BT_IV, 0);
    }

    /**
     * @param btPlain 明文
     * @param btKey 密钥
     * @param btIV 初始向量
     * @return 密文
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static byte[] encode(byte[] btPlain, byte[] btKey, byte[] btIV)
            throws BadPaddingException, IllegalBlockSizeException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException
    {
        return encodeDecode(btPlain, btKey, btIV, 0);
    }

    /**
     * @param btCipher 密文
     * @return 明文
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static byte[] decode(byte[] btCipher) throws BadPaddingException,
            IllegalBlockSizeException, InvalidAlgorithmParameterException,
            InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException
    {
        return encodeDecode(btCipher, BT_KEY, BT_IV, 1);
    }

    /**
     * @param btCipher 密文
     * @param btKey 密钥
     * @param btIV 初始向量
     * @return 明文
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static byte[] decode(byte[] btCipher, byte[] btKey, byte[] btIV)
            throws BadPaddingException, IllegalBlockSizeException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException
    {
        return encodeDecode(btCipher, btKey, btIV, 1);
    }

    /**
     * @param btData 数据
     * @param btKey 密钥
     * @param btIV 初始向量
     * @param iFlag 0 - 加密 else 解密
     * @return 处理后的数据
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    private static byte[] encodeDecode(byte[] btData, byte[] btKey,
            byte[] btIV, int iFlag) throws BadPaddingException,
            IllegalBlockSizeException, InvalidAlgorithmParameterException,
            InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException
    {
        int ii;
        int l_iMode;
        byte[] l_btKey = null;
        Cipher l_oCipher = null;

        if ((btData == null) || (btKey == null))
        {
            return null;
        }

        int iLen = btData.length;
        int iKeyLen = btKey.length;
        int iIVLen = btIV == null ? 0 : btIV.length;

        if (iKeyLen > AES_128_KEY_LEN) // 16 Bytes
        {
            iKeyLen = AES_128_KEY_LEN; // 16 Bytes
        }

        l_btKey = new byte[AES_128_KEY_LEN]; // 16 Bytes

        for (ii = 0; ii < AES_128_KEY_LEN; ii++)
        {
            l_btKey[ii] = (byte) 0x00;
        }

        for (ii = 0; ii < iKeyLen; ii++)
        {
            l_btKey[ii] = btKey[ii];
        }

        l_oCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        if (iFlag == 0)
        {
            l_iMode = Cipher.ENCRYPT_MODE;
        }
        else
        {
            l_iMode = Cipher.DECRYPT_MODE;
        }

        if (btIV == null)
        {
            l_oCipher.init(l_iMode, new SecretKeySpec(l_btKey, 0,
                    AES_128_KEY_LEN, "AES"));
        }
        else
        {
            l_oCipher.init(l_iMode, new SecretKeySpec(l_btKey, 0,
                    AES_128_KEY_LEN, "AES"), new IvParameterSpec(btIV, 0,
                    iIVLen));
        }

        l_btKey = null;

        return l_oCipher.doFinal(btData, 0, iLen);
    }
    
    public static String decodeFromBase64(String password)
    {
        if(StringUtils.isNullOrEmpty(password))
        {
            return password;
        }
        
        try
        {
            return Base64Utils.encode(AESCbc128Utils.encode(password.getBytes()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
}