package com.huawei.esdk.tp.professional.local.impl.interceptor;

import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

@SuppressWarnings("rawtypes")
public class MsgInInterceptor extends AbstractPhaseInterceptor
{
    public MsgInInterceptor()
    {
        super(Phase.PRE_INVOKE);
    }

    @SuppressWarnings("unchecked")
    public void handleMessage(Message message) throws Fault
    {
        // 对返回参数中的sessionId截取
        // 通过拆分字符串的方式解析出SMC中的sessionId，
        // 最终是通过解析SDK Server端返回过来的soap消息提取出sessionID
        Map<String, List> headers = (Map<String, List>) message
                .get(Message.PROTOCOL_HEADERS);
        if (message.toString().contains("LoginRequestResponse") || message.toString().contains("AuthenticateResponse"))
        {
            List<String> msgSession = headers.get("Set-Cookie");
            if (null != msgSession && !msgSession.isEmpty())
            {
                // 发消息到SDK的情况，如果不是loginRequest接口，不赋值
                MsgSessionHolder.getInstance().setSession(msgSession);
            }
        }

    }
}
