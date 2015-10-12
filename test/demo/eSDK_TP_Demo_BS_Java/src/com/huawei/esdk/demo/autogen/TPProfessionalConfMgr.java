package com.huawei.esdk.demo.autogen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2014-04-29T10:32:46.546+08:00
 * Generated source version: 2.6.1
 * 
 */
@WebService(targetNamespace = "http://smc.huawei.com/", name = "TPProfessional.ConfMgr")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TPProfessionalConfMgr {

    @WebResult(name = "querySitesExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/querySitesEx")
    public QuerySitesExResponse querySitesEx(
        @WebParam(partName = "parameters", name = "querySitesEx", targetNamespace = "http://smc.huawei.com/")
        QuerySitesEx parameters
    );

    @WebResult(name = "editRecurrenceConferenceExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/editRecurrenceConferenceEx")
    public EditRecurrenceConferenceExResponse editRecurrenceConferenceEx(
        @WebParam(partName = "parameters", name = "editRecurrenceConferenceEx", targetNamespace = "http://smc.huawei.com/")
        EditRecurrenceConferenceEx parameters
    );

    @WebResult(name = "synchSiteStatusExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/synchSiteStatusEx")
    public SynchSiteStatusExResponse synchSiteStatusEx(
        @WebParam(partName = "parameters", name = "synchSiteStatusEx", targetNamespace = "http://smc.huawei.com/")
        SynchSiteStatusEx parameters
    );

    @WebResult(name = "queryConferencesStatusExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/queryConferencesStatusEx")
    public QueryConferencesStatusExResponse queryConferencesStatusEx(
        @WebParam(partName = "parameters", name = "queryConferencesStatusEx", targetNamespace = "http://smc.huawei.com/")
        QueryConferencesStatusEx parameters
    );

    @WebResult(name = "querySiteStatusExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/querySiteStatusEx")
    public QuerySiteStatusExResponse querySiteStatusEx(
        @WebParam(partName = "parameters", name = "querySiteStatusEx", targetNamespace = "http://smc.huawei.com/")
        QuerySiteStatusEx parameters
    );

    @WebResult(name = "addSiteToConfExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/addSiteToConfEx")
    public AddSiteToConfExResponse addSiteToConfEx(
        @WebParam(partName = "parameters", name = "addSiteToConfEx", targetNamespace = "http://smc.huawei.com/")
        AddSiteToConfEx parameters
    );

    @WebResult(name = "editScheduledConfExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/editScheduledConfEx")
    public EditScheduledConfExResponse editScheduledConfEx(
        @WebParam(partName = "parameters", name = "editScheduledConfEx", targetNamespace = "http://smc.huawei.com/")
        EditScheduledConfEx parameters
    );

    @WebResult(name = "delScheduledConfExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/delScheduledConfEx")
    public DelScheduledConfExResponse delScheduledConfEx(
        @WebParam(partName = "parameters", name = "delScheduledConfEx", targetNamespace = "http://smc.huawei.com/")
        DelScheduledConfEx parameters
    );

    @WebResult(name = "queryConfSitesStatusExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/queryConfSitesStatusEx")
    public QueryConfSitesStatusExResponse queryConfSitesStatusEx(
        @WebParam(partName = "parameters", name = "queryConfSitesStatusEx", targetNamespace = "http://smc.huawei.com/")
        QueryConfSitesStatusEx parameters
    );

    @WebResult(name = "prolongScheduledConfExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/prolongScheduledConfEx")
    public ProlongScheduledConfExResponse prolongScheduledConfEx(
        @WebParam(partName = "parameters", name = "prolongScheduledConfEx", targetNamespace = "http://smc.huawei.com/")
        ProlongScheduledConfEx parameters
    );

    @WebResult(name = "scheduleConfExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/scheduleConfEx")
    public ScheduleConfExResponse scheduleConfEx(
        @WebParam(partName = "parameters", name = "scheduleConfEx", targetNamespace = "http://smc.huawei.com/")
        ScheduleConfEx parameters
    );

    @WebResult(name = "disconnectSitesExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/disconnectSitesEx")
    public DisconnectSitesExResponse disconnectSitesEx(
        @WebParam(partName = "parameters", name = "disconnectSitesEx", targetNamespace = "http://smc.huawei.com/")
        DisconnectSitesEx parameters
    );

    @WebResult(name = "connectSitesExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/connectSitesEx")
    public ConnectSitesExResponse connectSitesEx(
        @WebParam(partName = "parameters", name = "connectSitesEx", targetNamespace = "http://smc.huawei.com/")
        ConnectSitesEx parameters
    );

    @WebResult(name = "delSiteFromConfExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/delSiteFromConfEx")
    public DelSiteFromConfExResponse delSiteFromConfEx(
        @WebParam(partName = "parameters", name = "delSiteFromConfEx", targetNamespace = "http://smc.huawei.com/")
        DelSiteFromConfEx parameters
    );

    @WebResult(name = "scheduleRecurrenceConferenceExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/scheduleRecurrenceConferenceEx")
    public ScheduleRecurrenceConferenceExResponse scheduleRecurrenceConferenceEx(
        @WebParam(partName = "parameters", name = "scheduleRecurrenceConferenceEx", targetNamespace = "http://smc.huawei.com/")
        ScheduleRecurrenceConferenceEx parameters
    );
}
