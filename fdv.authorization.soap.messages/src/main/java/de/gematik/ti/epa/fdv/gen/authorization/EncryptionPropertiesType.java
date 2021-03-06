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

public class EncryptionPropertiesType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public ArrayList< EncryptionPropertyType> EncryptionProperty =new ArrayList<EncryptionPropertyType >();
    
    public String Id;
        
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

if (inObj.hasAttribute("Id"))
        {	
            java.lang.Object j = inObj.getAttribute("Id");
            if (j != null)
            {
                Id = j.toString();
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("EncryptionProperty"))
        {
            if(obj!=null)
            {
if(this.EncryptionProperty==null)
                {
                    this.EncryptionProperty = new java.util.ArrayList< EncryptionPropertyType>();
                }
                java.lang.Object j =obj;
                EncryptionPropertyType j1= (EncryptionPropertyType)__envelope.get(j,EncryptionPropertyType.class,false);
                this.EncryptionProperty.add(j1);            }
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
        if(propertyIndex>=0 && propertyIndex < 0+this.EncryptionProperty.size())
        {
                java.lang.Object EncryptionProperty = this.EncryptionProperty.get(propertyIndex-(0));
                return EncryptionProperty;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0+EncryptionProperty.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.EncryptionProperty.size())
        {
            info.type = EncryptionPropertyType.class;
            info.name = "EncryptionProperty";
            info.namespace= "http://www.w3.org/2001/04/xmlenc#";
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
                info.name = "Id";
                info.namespace= "";
                if(this.Id!=null)
                {
                    info.setValue(this.Id);
                }
            
                }    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
