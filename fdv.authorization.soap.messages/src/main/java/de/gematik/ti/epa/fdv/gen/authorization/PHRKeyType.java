package de.gematik.ti.epa.fdv.gen.authorization;
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

public class PHRKeyType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public KeyType RecordKey;
    
    public KeyType ContextKey;
    
    public String insurant;
        
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
                }
            } 
        }

if (inObj.hasAttribute("insurant"))
        {	
            java.lang.Object j = inObj.getAttribute("insurant");
            if (j != null)
            {
                insurant = j.toString();
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("RecordKey"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.RecordKey = (KeyType)__envelope.get(j,KeyType.class,false);
            }
            return true;
        }
        if (info.name.equals("ContextKey"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.ContextKey = (KeyType)__envelope.get(j,KeyType.class,false);
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
            return this.RecordKey!=null?this.RecordKey.getSimpleValue():null;
        }
        if(propertyIndex==1)
        {
            return this.ContextKey!=null?this.ContextKey.getSimpleValue():null;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = org.ksoap2.serialization.SoapPrimitive.class;
            info.name = "RecordKey";
            info.namespace= "http://ws.gematik.de/fa/phr/v1.1";
        }
        if(propertyIndex==1)
        {
            info.type = org.ksoap2.serialization.SoapPrimitive.class;
            info.name = "ContextKey";
            info.namespace= "http://ws.gematik.de/fa/phr/v1.1";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }


    @Override
    public int getAttributeCount() {
        return 1;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if(index==0)
                {
                info.name = "insurant";
                info.namespace= "";
                if(this.insurant!=null)
                {
                    info.setValue(this.insurant);
                }
            
                }    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
