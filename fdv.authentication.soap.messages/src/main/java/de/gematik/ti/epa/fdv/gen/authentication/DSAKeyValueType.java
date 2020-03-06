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

public class DSAKeyValueType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public byte[] P;
    
    public byte[] Q;
    
    public byte[] G;
    
    public byte[] Y;
    
    public byte[] J;
    
    public byte[] Seed;
    
    public byte[] PgenCounter;
        
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
        if (info.name.equals("P"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.P = Helper.getBinary(j,false);
            }
            return true;
        }
        if (info.name.equals("Q"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Q = Helper.getBinary(j,false);
            }
            return true;
        }
        if (info.name.equals("G"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.G = Helper.getBinary(j,false);
            }
            return true;
        }
        if (info.name.equals("Y"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Y = Helper.getBinary(j,false);
            }
            return true;
        }
        if (info.name.equals("J"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.J = Helper.getBinary(j,false);
            }
            return true;
        }
        if (info.name.equals("Seed"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Seed = Helper.getBinary(j,false);
            }
            return true;
        }
        if (info.name.equals("PgenCounter"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.PgenCounter = Helper.getBinary(j,false);
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
            return this.P!=null?org.kobjects.base64.Base64.encode((byte[])this.P):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==1)
        {
            return this.Q!=null?org.kobjects.base64.Base64.encode((byte[])this.Q):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.G!=null?org.kobjects.base64.Base64.encode((byte[])this.G):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.Y!=null?org.kobjects.base64.Base64.encode((byte[])this.Y):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return this.J!=null?org.kobjects.base64.Base64.encode((byte[])this.J):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==5)
        {
            return this.Seed!=null?org.kobjects.base64.Base64.encode((byte[])this.Seed):SoapPrimitive.NullSkip;
        }
        if(propertyIndex==6)
        {
            return this.PgenCounter!=null?org.kobjects.base64.Base64.encode((byte[])this.PgenCounter):SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "P";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Q";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "G";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Y";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "J";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Seed";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==6)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "PgenCounter";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}