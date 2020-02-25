package de.gematik.ti.epa.fdv.gen.authentication;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.6.2.0
//
// Created by Quasar Development 
//
//---------------------------------------------------



import java.util.Hashtable;
import org.ksoap2.serialization.*;

/**
* This complex type ties together the timestamp related elements into a composite type.
*/
public class TimestampType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public AttributedDateTime Created;
    
    public AttributedDateTime Expires;
    
    public java.util.ArrayList< PropertyInfo> any =new java.util.ArrayList< PropertyInfo>();
        
    private transient java.lang.Object __source;    
    

    
    
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        __source=inObj; 
        
        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                if(!loadProperty(info,soapObject,__envelope))
                {
                    info= __envelope.getAny(info);
                    this.any.add(info);
                }
            } 
        }



    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Created"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Created = (AttributedDateTime)__envelope.get(j,AttributedDateTime.class,false);
            }
            return true;
        }
        if (info.name.equals("Expires"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Expires = (AttributedDateTime)__envelope.get(j,AttributedDateTime.class,false);
            }
            return true;
        }
        return false;
    }
    
    public java.lang.Object getOriginalXmlSource()
    {
        return __source;
    }    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.Created!=null?this.Created.getSimpleValue():null;
        }
        if(propertyIndex==1)
        {
            return this.Expires!=null?this.Expires.getSimpleValue():null;
        }
        if(propertyIndex>=2 && propertyIndex < 2+this.any.size())
        {
        return this.any.get(propertyIndex-(2)).getValue();
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+ any.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = org.ksoap2.serialization.SoapPrimitive.class;
            info.name = "Created";
            info.namespace= "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
        }
        if(propertyIndex==1)
        {
            info.type = org.ksoap2.serialization.SoapPrimitive.class;
            info.name = "Expires";
            info.namespace= "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
        }
        if(propertyIndex>=2 && propertyIndex < 2+this.any.size())
        {
        PropertyInfo j=this.any.get(propertyIndex-(2));
        info.type = j.type;
        info.name = j.name;
        info.namespace= j.namespace;
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
