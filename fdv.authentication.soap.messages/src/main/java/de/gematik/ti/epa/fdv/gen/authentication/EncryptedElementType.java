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
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class EncryptedElementType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public EncryptedDataType EncryptedData;
    
    public ArrayList< EncryptedKeyType> EncryptedKey =new ArrayList<EncryptedKeyType >();
        
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



    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("EncryptedData"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.EncryptedData = (EncryptedDataType)__envelope.get(j,EncryptedDataType.class,false);
            }
            return true;
        }
        if (info.name.equals("EncryptedKey"))
        {
            if(obj!=null)
            {
if(this.EncryptedKey==null)
                {
                    this.EncryptedKey = new java.util.ArrayList< EncryptedKeyType>();
                }
                java.lang.Object j =obj;
                EncryptedKeyType j1= (EncryptedKeyType)__envelope.get(j,EncryptedKeyType.class,false);
                this.EncryptedKey.add(j1);            }
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
            return EncryptedData;
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.EncryptedKey.size())
        {
                java.lang.Object EncryptedKey = this.EncryptedKey.get(propertyIndex-(1));
                return EncryptedKey!=null?EncryptedKey:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+EncryptedKey.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = EncryptedDataType.class;
            info.name = "EncryptedData";
            info.namespace= "http://www.w3.org/2001/04/xmlenc#";
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.EncryptedKey.size())
        {
            info.type = EncryptedKeyType.class;
            info.name = "EncryptedKey";
            info.namespace= "http://www.w3.org/2001/04/xmlenc#";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
