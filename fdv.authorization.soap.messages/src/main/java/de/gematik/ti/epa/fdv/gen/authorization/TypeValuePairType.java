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

public class TypeValuePairType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public String type;
    
    public byte[] value;
        
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

if (inObj.hasAttribute("type"))
        {	
            java.lang.Object j = inObj.getAttribute("type");
            if (j != null)
            {
                type = j.toString();
            }
        }if (inObj.hasAttribute("value"))
        {	
            java.lang.Object j = inObj.getAttribute("value");
            if (j != null)
            {
                value = org.kobjects.base64.Base64.decode(j.toString());
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
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
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }


    @Override
    public int getAttributeCount() {
        return 2;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if(index==0)
                {
                info.name = "type";
                info.namespace= "";
                if(this.type!=null)
                {
                    info.setValue(this.type);
                }
            
                }if(index==1)
                {
                info.name = "value";
                info.namespace= "";
                if(this.value!=null)
                {
                    info.setValue(org.kobjects.base64.Base64.encode(this.value));
                }
            
                }    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
