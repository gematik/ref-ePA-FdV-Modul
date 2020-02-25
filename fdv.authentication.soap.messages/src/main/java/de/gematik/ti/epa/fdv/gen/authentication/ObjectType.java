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

public class ObjectType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public String Id;
    
    public String MimeType;
    
    public String Encoding;
    
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

if (inObj.hasAttribute("Id"))
        {	
            java.lang.Object j = inObj.getAttribute("Id");
            if (j != null)
            {
                Id = j.toString();
            }
        }if (inObj.hasAttribute("MimeType"))
        {	
            java.lang.Object j = inObj.getAttribute("MimeType");
            if (j != null)
            {
                MimeType = j.toString();
            }
        }if (inObj.hasAttribute("Encoding"))
        {	
            java.lang.Object j = inObj.getAttribute("Encoding");
            if (j != null)
            {
                Encoding = j.toString();
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
        if(propertyIndex>=0 && propertyIndex < 0+this.any.size())
        {
        return this.any.get(propertyIndex-(0)).getValue();
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0+ any.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.any.size())
        {
        PropertyInfo j=this.any.get(propertyIndex-(0));
        info.type = j.type;
        info.name = j.name;
        info.namespace= j.namespace;
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }


    @Override
    public int getAttributeCount() {
        return 3;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        if(index==0)
                {
                info.name = "Id";
                info.namespace= "";
                if(this.Id!=null)
                {
                    info.setValue(this.Id);
                }
            
                }if(index==1)
                {
                info.name = "MimeType";
                info.namespace= "";
                if(this.MimeType!=null)
                {
                    info.setValue(this.MimeType);
                }
            
                }if(index==2)
                {
                info.name = "Encoding";
                info.namespace= "";
                if(this.Encoding!=null)
                {
                    info.setValue(this.Encoding);
                }
            
                }    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
