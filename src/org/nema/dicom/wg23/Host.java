/*
Copyright (c) 2013, Washington University in St.Louis.
All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.nema.dicom.wg23;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Host", targetNamespace = "http://wg23.dicom.nema.org/")
@XmlSeeAlso({
    ObjectFactoryHost.class
})
public interface Host {


    /**
     * 
     * @return
     *     returns org.nema.dicom.wg23.Uid
     */
    @WebMethod
    @WebResult(name = "retval", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "generateUID", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GenerateUID")
    @ResponseWrapper(localName = "generateUIDResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GenerateUIDResponse")
    public Uid generateUID();

    /**
     * 
     * @param appPreferredScreen
     * @return
     *     returns org.nema.dicom.wg23.Rectangle
     */
    @WebMethod
    @WebResult(name = "retval", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "getAvailableScreen", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetAvailableScreen")
    @ResponseWrapper(localName = "getAvailableScreenResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetAvailableScreenResponse")
    public Rectangle getAvailableScreen(
        @WebParam(name = "appPreferredScreen", targetNamespace = "http://wg23.dicom.nema.org/")
        Rectangle appPreferredScreen);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "retval", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "getOutputDir", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetOutputDir")
    @ResponseWrapper(localName = "getOutputDirResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetOutputDirResponse")
    public String getOutputDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "retval", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "getTmpDir", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetTmpDir")
    @ResponseWrapper(localName = "getTmpDirResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetTmpDirResponse")
    public String getTmpDir();

    /**
     * 
     * @param newState
     */
    @WebMethod
    @RequestWrapper(localName = "notifyStateChanged", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.NotifyStateChanged")
    @ResponseWrapper(localName = "notifyStateChangedResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.NotifyStateChangedResponse")
    public void notifyStateChanged(
        @WebParam(name = "newState", targetNamespace = "http://wg23.dicom.nema.org/")
        State newState);

    /**
     * 
     * @param newStatus
     */
    @WebMethod
    @RequestWrapper(localName = "notifyStatus", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.NotifyStatus")
    @ResponseWrapper(localName = "notifyStatusResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.NotifyStatusResponse")
    public void notifyStatus(
        @WebParam(name = "newStatus", targetNamespace = "http://wg23.dicom.nema.org/")
        Status newStatus);

    /**
     * 
     * @param transferSyntaxUID
     * @param uuids
     * @param classUID
     * @return
     *     returns org.nema.dicom.wg23.ModelSetDescriptor
     */
    @WebMethod
    @WebResult(name = "retval", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "getAsModels", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetAsModels")
    @ResponseWrapper(localName = "getAsModelsResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetAsModelsResponse")
    public ModelSetDescriptor getAsModels(
        @WebParam(name = "uuids", targetNamespace = "http://wg23.dicom.nema.org/")
        ArrayOfUUID uuids,
        @WebParam(name = "classUID", targetNamespace = "http://wg23.dicom.nema.org/")
        Uid classUID,
        @WebParam(name = "transferSyntaxUID", targetNamespace = "http://wg23.dicom.nema.org/")
        Uid transferSyntaxUID);

    /**
     * 
     * @param includeBulkData
     * @param uuids
     * @return
     *     returns org.nema.dicom.wg23.ArrayOfObjectLocator
     */
    @WebMethod
    @WebResult(name = "objectLocators", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "getDataAsFile", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetDataAsFile")
    @ResponseWrapper(localName = "getDataAsFileResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetDataAsFileResponse")
    public ArrayOfObjectLocator getDataAsFile(
        @WebParam(name = "uuids", targetNamespace = "http://wg23.dicom.nema.org/")
        ArrayOfUUID uuids,
        @WebParam(name = "includeBulkData", targetNamespace = "http://wg23.dicom.nema.org/")
        boolean includeBulkData);

    /**
     * 
     * @param includeBulkData
     * @param transferSyntaxUID
     * @param objectUUIDs
     * @param mimeType
     * @return
     *     returns org.nema.dicom.wg23.ArrayOfObjectLocator
     */
    @WebMethod
    @WebResult(name = "objectLocators", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "getDataAsSpecificTypeFile", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetDataAsSpecificTypeFile")
    @ResponseWrapper(localName = "getDataAsSpecificTypeFileResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.GetDataAsSpecificTypeFileResponse")
    public ArrayOfObjectLocator getDataAsSpecificTypeFile(
        @WebParam(name = "objectUUIDs", targetNamespace = "http://wg23.dicom.nema.org/")
        ArrayOfUUID objectUUIDs,
        @WebParam(name = "mimeType", targetNamespace = "http://wg23.dicom.nema.org/")
        String mimeType,
        @WebParam(name = "transferSyntaxUID", targetNamespace = "http://wg23.dicom.nema.org/")
        Uid transferSyntaxUID,
        @WebParam(name = "includeBulkData", targetNamespace = "http://wg23.dicom.nema.org/")
        boolean includeBulkData);

    /**
     * 
     * @param availableData
     * @param lastData
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "retval", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "notifyDataAvailable", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.NotifyDataAvailable")
    @ResponseWrapper(localName = "notifyDataAvailableResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.NotifyDataAvailableResponse")
    public boolean notifyDataAvailable(
        @WebParam(name = "availableData", targetNamespace = "http://wg23.dicom.nema.org/")
        AvailableData availableData,
        @WebParam(name = "lastData", targetNamespace = "http://wg23.dicom.nema.org/")
        boolean lastData);

    /**
     * 
     * @param modelXpaths
     * @param objUUIDs
     * @param includeBulkDataPointers
     * @return
     *     returns org.nema.dicom.wg23.ArrayOfQueryResult
     */
    @WebMethod
    @WebResult(name = "queryResults", targetNamespace = "http://wg23.dicom.nema.org/")
    @RequestWrapper(localName = "queryModel", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.QueryModel")
    @ResponseWrapper(localName = "queryModelResponse", targetNamespace = "http://wg23.dicom.nema.org/", className = "org.nema.dicom.wg23.QueryModelResponse")
    public ArrayOfQueryResult queryModel(
        @WebParam(name = "objUUIDs", targetNamespace = "http://wg23.dicom.nema.org/")
        ArrayOfUUID objUUIDs,
        @WebParam(name = "modelXpaths", targetNamespace = "http://wg23.dicom.nema.org/")
        ArrayOfString modelXpaths,
        @WebParam(name = "includeBulkDataPointers", targetNamespace = "http://wg23.dicom.nema.org/")
        boolean includeBulkDataPointers);

}
