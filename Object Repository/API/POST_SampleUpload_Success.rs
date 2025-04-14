<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST_SampleUpload_Success</name>
   <tag></tag>
   <elementGuidId>8e59145b-5016-4572-9a4d-d04065fed776</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>a9ca4853c1d79385cda06428aaf4e0c5d5f276e3</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;project\&quot;: \&quot;13583\&quot;,\n  \&quot;tags\&quot;: [\&quot;api-test\&quot;],\n  \&quot;files\&quot;: [\n    {\n      \&quot;name\&quot;: \&quot;sample.ab1\&quot;,\n      \&quot;type\&quot;: \&quot;application/ab1\&quot;,\n      \&quot;size\&quot;: 1.178,\n      \&quot;url\&quot;: \&quot;https://basepair-uploaded-files.s3.amazonaws.com/sample.fastq.gz?X-Amz-Signature\u003d...\&quot;\n    }\n  ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>multipart/form-data</value>
      <webElementGuid>33fec0b5-5a0b-4b3b-a45f-c4a8d8364f88</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>multipart/form-data</value>
      <webElementGuid>ef4fc59a-8de8-47a0-b347-4abc4bb9f68f</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer a9ca4853c1d79385cda06428aaf4e0c5d5f276e3</value>
      <webElementGuid>8af3ad65-8c02-49f2-b128-718900b4c63e</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.1.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://test.basepairtech.com/api/v3/uploads/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

//def response = WSResponseManager.getInstance().getCurrentResponse()

// Check for status 200
assertThat(response.getStatusCode()).isEqualTo(200)

// Check response body
assertThat(response.getResponseBodyContent()).contains('Sample added successfully')
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
