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

public class KeyInfoType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public ArrayList< String> KeyName =new ArrayList<String >();
    
    public ArrayList< KeyValueType> KeyValue =new ArrayList<KeyValueType >();
    
    public ArrayList< RetrievalMethodType> RetrievalMethod =new ArrayList<RetrievalMethodType >();
    
    public ArrayList< X509DataType> X509Data =new ArrayList<X509DataType >();
    
    public ArrayList< PGPDataType> PGPData =new ArrayList<PGPDataType >();
    
    public ArrayList< SPKIDataType> SPKIData =new ArrayList<SPKIDataType >();
    
    public ArrayList< String> MgmtData =new ArrayList<String >();
    
    public String Id;
    
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
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("KeyName"))
        {
            if(obj!=null)
            {
if(this.KeyName==null)
                {
                    this.KeyName = new java.util.ArrayList< String>();
                }
                java.lang.Object j =obj;
                String j1= j.toString();
                this.KeyName.add(j1);            }
            return true;
        }
        if (info.name.equals("KeyValue"))
        {
            if(obj!=null)
            {
if(this.KeyValue==null)
                {
                    this.KeyValue = new java.util.ArrayList< KeyValueType>();
                }
                java.lang.Object j =obj;
                KeyValueType j1= (KeyValueType)__envelope.get(j,KeyValueType.class,false);
                this.KeyValue.add(j1);            }
            return true;
        }
        if (info.name.equals("RetrievalMethod"))
        {
            if(obj!=null)
            {
if(this.RetrievalMethod==null)
                {
                    this.RetrievalMethod = new java.util.ArrayList< RetrievalMethodType>();
                }
                java.lang.Object j =obj;
                RetrievalMethodType j1= (RetrievalMethodType)__envelope.get(j,RetrievalMethodType.class,false);
                this.RetrievalMethod.add(j1);            }
            return true;
        }
        if (info.name.equals("X509Data"))
        {
            if(obj!=null)
            {
if(this.X509Data==null)
                {
                    this.X509Data = new java.util.ArrayList< X509DataType>();
                }
                java.lang.Object j =obj;
                X509DataType j1= (X509DataType)__envelope.get(j,X509DataType.class,false);
                this.X509Data.add(j1);            }
            return true;
        }
        if (info.name.equals("PGPData"))
        {
            if(obj!=null)
            {
if(this.PGPData==null)
                {
                    this.PGPData = new java.util.ArrayList< PGPDataType>();
                }
                java.lang.Object j =obj;
                PGPDataType j1= (PGPDataType)__envelope.get(j,PGPDataType.class,false);
                this.PGPData.add(j1);            }
            return true;
        }
        if (info.name.equals("SPKIData"))
        {
            if(obj!=null)
            {
if(this.SPKIData==null)
                {
                    this.SPKIData = new java.util.ArrayList< SPKIDataType>();
                }
                java.lang.Object j =obj;
                SPKIDataType j1= (SPKIDataType)__envelope.get(j,SPKIDataType.class,false);
                this.SPKIData.add(j1);            }
            return true;
        }
        if (info.name.equals("MgmtData"))
        {
            if(obj!=null)
            {
if(this.MgmtData==null)
                {
                    this.MgmtData = new java.util.ArrayList< String>();
                }
                java.lang.Object j =obj;
                String j1= j.toString();
                this.MgmtData.add(j1);            }
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
        if(propertyIndex>=0 && propertyIndex < 0+this.KeyName.size())
        {
                java.lang.Object KeyName = this.KeyName.get(propertyIndex-(0));
                return KeyName!=null?KeyName:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=0+this.KeyName.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size())
        {
                java.lang.Object KeyValue = this.KeyValue.get(propertyIndex-(0+this.KeyName.size()));
                return KeyValue!=null?KeyValue:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size())
        {
                java.lang.Object RetrievalMethod = this.RetrievalMethod.get(propertyIndex-(0+this.KeyName.size()+this.KeyValue.size()));
                return RetrievalMethod!=null?RetrievalMethod:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size())
        {
                java.lang.Object X509Data = this.X509Data.get(propertyIndex-(0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()));
                return X509Data!=null?X509Data:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size())
        {
                java.lang.Object PGPData = this.PGPData.get(propertyIndex-(0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()));
                return PGPData!=null?PGPData:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size())
        {
                java.lang.Object SPKIData = this.SPKIData.get(propertyIndex-(0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()));
                return SPKIData!=null?SPKIData:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size())
        {
                java.lang.Object MgmtData = this.MgmtData.get(propertyIndex-(0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()));
                return MgmtData!=null?MgmtData:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size()+this.any.size())
        {
        return this.any.get(propertyIndex-(0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size())).getValue();
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0+KeyName.size()+KeyValue.size()+RetrievalMethod.size()+X509Data.size()+PGPData.size()+SPKIData.size()+MgmtData.size()+ any.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex>=0 && propertyIndex < 0+this.KeyName.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "KeyName";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex>=0+this.KeyName.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size())
        {
            info.type = KeyValueType.class;
            info.name = "KeyValue";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size())
        {
            info.type = RetrievalMethodType.class;
            info.name = "RetrievalMethod";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size())
        {
            info.type = X509DataType.class;
            info.name = "X509Data";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size())
        {
            info.type = PGPDataType.class;
            info.name = "PGPData";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size())
        {
            info.type = SPKIDataType.class;
            info.name = "SPKIData";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size())
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "MgmtData";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex>=0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size() && propertyIndex < 0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size()+this.any.size())
        {
        PropertyInfo j=this.any.get(propertyIndex-(0+this.KeyName.size()+this.KeyValue.size()+this.RetrievalMethod.size()+this.X509Data.size()+this.PGPData.size()+this.SPKIData.size()+this.MgmtData.size()));
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
