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
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public class GetAuthorizationListResponse extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public ArrayList< AuthorizationInfoType> AuthorizationInfo =new ArrayList<AuthorizationInfoType >();
    
    public ArrayList< AuthorizationKeyType> AuthorizationKey =new ArrayList<AuthorizationKeyType >();
        
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
        if (info.name.equals("AuthorizationInfo"))
        {
            if(obj!=null)
            {
if(this.AuthorizationInfo==null)
                {
                    this.AuthorizationInfo = new java.util.ArrayList< AuthorizationInfoType>();
                }
                java.lang.Object j =obj;
                AuthorizationInfoType j1= (AuthorizationInfoType)__envelope.get(j,AuthorizationInfoType.class,false);
                this.AuthorizationInfo.add(j1);            }
            return true;
        }
        if (info.name.equals("AuthorizationKey"))
        {
            if(obj!=null)
            {
if(this.AuthorizationKey==null)
                {
                    this.AuthorizationKey = new java.util.ArrayList< AuthorizationKeyType>();
                }
                java.lang.Object j =obj;
                AuthorizationKeyType j1= (AuthorizationKeyType)__envelope.get(j,AuthorizationKeyType.class,false);
                this.AuthorizationKey.add(j1);            }
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
        if(propertyIndex>=0 && propertyIndex < 0+this.AuthorizationInfo.size())
        {
                java.lang.Object AuthorizationInfo = this.AuthorizationInfo.get(propertyIndex-(0));
                return AuthorizationInfo!=null?AuthorizationInfo:SoapPrimitive.NullNilElement;
        }
        if(propertyIndex>=0+this.AuthorizationInfo.size() && propertyIndex < 0+this.AuthorizationInfo.size()+this.AuthorizationKey.size())
        {
                java.lang.Object AuthorizationKey = this.AuthorizationKey.get(propertyIndex-(0+this.AuthorizationInfo.size()));
                return AuthorizationKey!=null?AuthorizationKey:SoapPrimitive.NullNilElement;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0+AuthorizationInfo.size()+AuthorizationKey.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.AuthorizationInfo.size())
        {
            info.type = AuthorizationInfoType.class;
            info.name = "AuthorizationInfo";
            info.namespace= "http://ws.gematik.de/fd/phrs/AuthorizationService/v1.1";
        }
        if(propertyIndex>=0+this.AuthorizationInfo.size() && propertyIndex < 0+this.AuthorizationInfo.size()+this.AuthorizationKey.size())
        {
            info.type = AuthorizationKeyType.class;
            info.name = "AuthorizationKey";
            info.namespace= "http://ws.gematik.de/fd/phrs/AuthorizationService/v1.1";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
