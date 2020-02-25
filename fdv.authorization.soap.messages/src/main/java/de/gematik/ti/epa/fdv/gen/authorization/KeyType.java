package de.gematik.ti.epa.fdv.gen.authorization;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.6.2.0
//
// Created by Quasar Development 
//
//---------------------------------------------------



import org.ksoap2.serialization.*;

public class KeyType  implements java.io.Serializable
{
    
    public byte[] value;
    
    public String algorithm;
        
    private transient java.lang.Object __source;    
    

    
    
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        __source=inObj; 
        if(!(inObj instanceof SoapObject))
        {
            java.lang.Object j =(java.lang.Object)inObj;
            value = Helper.getBinary(j,false);
        }

if (inObj.hasAttribute("algorithm"))
        {	
            java.lang.Object j = inObj.getAttribute("algorithm");
            if (j != null)
            {
                algorithm = j.toString();
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("value"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.value = Helper.getBinary(j,false);
            }
            return true;
        }
        return false;
    }
    
    public java.lang.Object getOriginalXmlSource()
    {
        return __source;
    }    
    
    public Object getSimpleValue()
    {
        Object value=this.value != null ? this.value.toString() : "";
        SoapPrimitive primitive = new SoapPrimitive("http://ws.gematik.de/fa/phr/v1.1", "value",value);
        
        if (this.algorithm != null)
        {
            AttributeInfo attrInfo = new AttributeInfo();
            attrInfo.setName("algorithm");
            attrInfo.setValue(this.algorithm);
            attrInfo.setNamespace("");
            primitive.addAttribute(attrInfo);
        }
        return primitive;
    }    
}
