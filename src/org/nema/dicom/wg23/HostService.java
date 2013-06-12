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

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HostService", targetNamespace = "http://wg23.dicom.nema.org/")
public class HostService
    extends Service
{

    private final static URL HOSTSERVICE_WSDL_LOCATION;

    static {
        URL url = null;        
        HOSTSERVICE_WSDL_LOCATION = url;
    }

    public HostService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HostService() {
        super(HOSTSERVICE_WSDL_LOCATION, new QName("http://wg23.dicom.nema.org/", "HostService"));
    }

    /**
     * 
     * @return
     *     returns Host
     */
    @WebEndpoint(name = "HostPort")
    public Host getHostPort() {
        return (Host)super.getPort(new QName("http://wg23.dicom.nema.org/", "HostPort"), Host.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Host
     */
    @WebEndpoint(name = "HostPort")
    public Host getHostPort(WebServiceFeature... features) {
        return (Host)super.getPort(new QName("http://wg23.dicom.nema.org/", "HostPort"), Host.class, features);
    }

}
