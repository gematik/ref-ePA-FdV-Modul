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
import java.math.BigInteger;

public class UC_GeschuetzteVersichertendatenXML_RuhenderLeistungsanspruch extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public String Beginn;
    
    public String Ende;
    
	/**
	* Dieses Feld dient ausschließlich zur Angabe des ruhenden Leistungsanpruchs nach § 16 Abs. 3a und § 16 Abs. 1 bis 3 SGB V.
	* Mögliche Ausprägungen des ruhenden Leistungsanspruchs sind:
	* 1 = vollständig
	* 2 = eingeschränkt
	*/
    public BigInteger ArtDesRuhens=BigInteger.ZERO;
        
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
        if (info.name.equals("Beginn"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Beginn = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Beginn = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Ende"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Ende = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Ende = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ArtDesRuhens"))
        {
            if(obj!=null)
            {
                if (obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ArtDesRuhens = new BigInteger(j.toString());
                    }
                }
                else if (obj instanceof BigInteger){
                    this.ArtDesRuhens = (BigInteger)obj;
                }
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
            return Beginn;
        }
        if(propertyIndex==1)
        {
            return this.Ende!=null?this.Ende:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.ArtDesRuhens!=null?this.ArtDesRuhens.toString():SoapPrimitive.NullSkip;
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
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Beginn";
            info.namespace= "http://ws.gematik.de/fa/vsdm/vsd/v5.2";
        }
        if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Ende";
            info.namespace= "http://ws.gematik.de/fa/vsdm/vsd/v5.2";
        }
        if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ArtDesRuhens";
            info.namespace= "http://ws.gematik.de/fa/vsdm/vsd/v5.2";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
