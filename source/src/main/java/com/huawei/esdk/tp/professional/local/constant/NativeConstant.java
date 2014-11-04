package com.huawei.esdk.tp.professional.local.constant;

public interface NativeConstant {
	/**
	 * session无效
	 */
	int SESSION_NOT_CORRECT = 1351614476;
	/**
	 * siteUri为空
	 */
	int SITEURI_IS_NULL = 570789891;
	/**
	 * 未登录
	 */
	int AUTHORIZE_ERRORCODE = 571052032;
	/**
	 * 系统错误
	 */
	int SYSTEM_ERRORCODE = 2130000010;
	/**
	 * 参数不合法
	 */
	int SDK_DATA_INCORRECT_ERRORCODE = 1342177281;
	/**
	 * 必填参数未填
	 */
	int SDK_PARAM_NOT_COMPLETE_ERRORCODE =570462210;
	/**
	 * native网络异常
	 */
	int ERROR_CODE_NETWORK_ERROR = 2130000023;
	/**
	 * SSL握手失败
	 */
	int SSL_HANDSHAKE_FAILURE=2130000019;
	/**
	 * native处理异常
	 */
	int NATIVE_EXCEPTION = 2130000020;
	/**
	 * URL格式错误
	 */
	int NATIVE_URL_FORMAT_ERRORCODE = 2130000021;
	/**
	 * 密码输入错误次数超过限定值，账户被锁定
	 */
	int ACCOUNT_LOCKED = 2130000027;
}