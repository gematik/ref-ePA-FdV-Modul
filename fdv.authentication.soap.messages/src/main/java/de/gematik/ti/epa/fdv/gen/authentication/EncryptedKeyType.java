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

public class EncryptedKeyType extends EncryptedType implements KvmSerializable,java.io.Serializable
{
    
    public ReferenceList ReferenceList;
    
    public String CarriedKeyName;
    
    public String Recipient;
        

    
    
    @Override
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        super.loadFromSoap(paramObj, __envelope);

if (inObj.hasAttribute("Recipient"))
        {	
            java.lang.Object j = inObj.getAttribute("Recipient");
            if (j != null)
            {
                Recipient = j.toString();
            }
        }

    }

    @Override
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("ReferenceList"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.ReferenceList = (ReferenceList)__envelope.get(j,ReferenceList.class,false);
            }
            return true;
        }
        if (info.name.equals("CarriedKeyName"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.CarriedKeyName = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.CarriedKeyName = (String)obj;
                }
            }
            return true;
        }
        return super.loadProperty(info,soapObject,__envelope);
    }
    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        int count = super.getPropertyCount();
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==count+0)
        {
            return this.ReferenceList!=null?this.ReferenceList:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==count+1)
        {
            return this.CarriedKeyName!=null?this.CarriedKeyName:SoapPrimitive.NullSkip;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = ReferenceList.class;
            info.name = "ReferenceList";
            info.namespace= "http://www.w3.org/2001/04/xmlenc#";
        }
        if(propertyIndex==count+1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "CarriedKeyName";
            info.namespace= "http://www.w3.org/2001/04/xmlenc#";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }


    @Override
    public int getAttributeCount() {
        return super.getAttributeCount() + 1;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        int count=super.getAttributeCount();
        if(index==count+0)
                {
                info.name = "Recipient";
                info.namespace= "";
                if(this.Recipient!=null)
                {
                    info.setValue(this.Recipient);
                }
            
                }    if(index < count)
    {
        super.getAttributeInfo(index, info);
    }
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
