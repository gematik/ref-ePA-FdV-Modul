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

public class SubjectConfirmationType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public BaseIDAbstractType BaseID;
    
    public NameIDType NameID;
    
    public EncryptedElementType EncryptedID;
    
    public SubjectConfirmationDataType SubjectConfirmationData;
    
    public String Method;
        
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

if (inObj.hasAttribute("Method"))
        {	
            java.lang.Object j = inObj.getAttribute("Method");
            if (j != null)
            {
                Method = j.toString();
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("BaseID"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.BaseID = (BaseIDAbstractType)__envelope.get(j,BaseIDAbstractType.class,false);
            }
            return true;
        }
        if (info.name.equals("NameID"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.NameID = (NameIDType)__envelope.get(j,NameIDType.class,false);
            }
            return true;
        }
        if (info.name.equals("EncryptedID"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.EncryptedID = (EncryptedElementType)__envelope.get(j,EncryptedElementType.class,false);
            }
            return true;
        }
        if (info.name.equals("SubjectConfirmationData"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.SubjectConfirmationData = (SubjectConfirmationDataType)__envelope.get(j,SubjectConfirmationDataType.class,false);
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
            return this.BaseID!=null?this.BaseID:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.NameID!=null?this.NameID.getSimpleValue():null;
        }
        if(propertyIndex==2)
        {
            return this.EncryptedID!=null?this.EncryptedID:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.SubjectConfirmationData!=null?this.SubjectConfirmationData:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = BaseIDAbstractType.class;
            info.name = "BaseID";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex==1)
        {
            info.type = org.ksoap2.serialization.SoapPrimitive.class;
            info.name = "NameID";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex==2)
        {
            info.type = EncryptedElementType.class;
            info.name = "EncryptedID";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex==3)
        {
            info.type = SubjectConfirmationDataType.class;
            info.name = "SubjectConfirmationData";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
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
                info.name = "Method";
                info.namespace= "";
                if(this.Method!=null)
                {
                    info.setValue(this.Method);
                }
            
                }    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
