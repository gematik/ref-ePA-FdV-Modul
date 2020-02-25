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

public class ReferenceType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public TransformsType Transforms;
    
    public DigestMethodType DigestMethod;
    
    public byte[] DigestValue;
    
    public String Id;
    
    public String URI;
    
    public String Type;
        
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
        }if (inObj.hasAttribute("URI"))
        {	
            java.lang.Object j = inObj.getAttribute("URI");
            if (j != null)
            {
                URI = j.toString();
            }
        }if (inObj.hasAttribute("Type"))
        {	
            java.lang.Object j = inObj.getAttribute("Type");
            if (j != null)
            {
                Type = j.toString();
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Transforms"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Transforms = (TransformsType)__envelope.get(j,TransformsType.class,false);
            }
            return true;
        }
        if (info.name.equals("DigestMethod"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.DigestMethod = (DigestMethodType)__envelope.get(j,DigestMethodType.class,false);
            }
            return true;
        }
        if (info.name.equals("DigestValue"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.DigestValue = Helper.getBinary(j,false);
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
            return this.Transforms!=null?this.Transforms:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return DigestMethod;
        }
        if(propertyIndex==2)
        {
            return this.DigestValue!=null?org.kobjects.base64.Base64.encode((byte[])this.DigestValue):SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Transforms";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==1)
        {
            info.type = DigestMethodType.class;
            info.name = "DigestMethod";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DigestValue";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
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
                info.name = "URI";
                info.namespace= "";
                if(this.URI!=null)
                {
                    info.setValue(this.URI);
                }
            
                }if(index==2)
                {
                info.name = "Type";
                info.namespace= "";
                if(this.Type!=null)
                {
                    info.setValue(this.Type);
                }
            
                }    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
