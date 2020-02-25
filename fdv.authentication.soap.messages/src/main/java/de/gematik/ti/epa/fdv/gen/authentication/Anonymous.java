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

public class Anonymous  implements java.io.Serializable
{
    
    public Enums.AnonymousType value=Enums.AnonymousType.optional;
        
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
            value = Enums.AnonymousType.fromString(j.toString());
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
                        this.value = Enums.AnonymousType.fromString(j.toString());
                    }
                }
                else if (obj instanceof Enums.AnonymousType){
                    this.value = (Enums.AnonymousType)obj;
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
        SoapPrimitive primitive = new SoapPrimitive("http://www.w3.org/2006/05/addressing/wsdl", "value",value);
        
        return primitive;
    }    
}
