package de.gematik.ti.epa.fdv.gen.authentication;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.6.2.0
//
// Created by Quasar Development 
//
//---------------------------------------------------



import org.ksoap2.serialization.*;

/**
* This type is for elements whose [children] is an anyURI and can have arbitrary attributes.
*/
public class AttributedURI  implements java.io.Serializable
{
    
    public String value;
        
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
            value = j.toString();
        }



    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("value"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.value = j.toString();
                    }
                }
                else{
                    this.value = obj.toString();
                }
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
        SoapPrimitive primitive = new SoapPrimitive("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "value",value);
        
        return primitive;
    }    
}
