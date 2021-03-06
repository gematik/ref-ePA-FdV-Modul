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

public class PolicyAttachment extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public AppliesTo AppliesTo;
    
    public ArrayList< Policy> Policy =new ArrayList<Policy >();
    
    public ArrayList< PolicyReference> PolicyReference =new ArrayList<PolicyReference >();
    
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



    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("AppliesTo"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.AppliesTo = (AppliesTo)__envelope.get(j,AppliesTo.class,false);
            }
            return true;
        }
        if (info.name.equals("Policy"))
        {
            if(obj!=null)
            {
if(this.Policy==null)
                {
                    this.Policy = new java.util.ArrayList< Policy>();
                }
                java.lang.Object j =obj;
                Policy j1= (Policy)__envelope.get(j,Policy.class,false);
                this.Policy.add(j1);            }
            return true;
        }
        if (info.name.equals("PolicyReference"))
        {
            if(obj!=null)
            {
if(this.PolicyReference==null)
                {
                    this.PolicyReference = new java.util.ArrayList< PolicyReference>();
                }
                java.lang.Object j =obj;
                PolicyReference j1= (PolicyReference)__envelope.get(j,PolicyReference.class,false);
                this.PolicyReference.add(j1);            }
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
            return AppliesTo;
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.Policy.size())
        {
                java.lang.Object Policy = this.Policy.get(propertyIndex-(1));
                return Policy!=null?Policy:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=1+this.Policy.size() && propertyIndex < 1+this.Policy.size()+this.PolicyReference.size())
        {
                java.lang.Object PolicyReference = this.PolicyReference.get(propertyIndex-(1+this.Policy.size()));
                return PolicyReference!=null?PolicyReference:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=1+this.Policy.size()+this.PolicyReference.size() && propertyIndex < 1+this.Policy.size()+this.PolicyReference.size()+this.any.size())
        {
        return this.any.get(propertyIndex-(1+this.Policy.size()+this.PolicyReference.size())).getValue();
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+Policy.size()+PolicyReference.size()+ any.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = AppliesTo.class;
            info.name = "AppliesTo";
            info.namespace= "http://schemas.xmlsoap.org/ws/2004/09/policy";
        }
        if(propertyIndex>=1 && propertyIndex < 1+this.Policy.size())
        {
            info.type = Policy.class;
            info.name = "Policy";
            info.namespace= "http://schemas.xmlsoap.org/ws/2004/09/policy";
        }
        if(propertyIndex>=1+this.Policy.size() && propertyIndex < 1+this.Policy.size()+this.PolicyReference.size())
        {
            info.type = PolicyReference.class;
            info.name = "PolicyReference";
            info.namespace= "http://schemas.xmlsoap.org/ws/2004/09/policy";
        }
        if(propertyIndex>=1+this.Policy.size()+this.PolicyReference.size() && propertyIndex < 1+this.Policy.size()+this.PolicyReference.size()+this.any.size())
        {
        PropertyInfo j=this.any.get(propertyIndex-(1+this.Policy.size()+this.PolicyReference.size()));
        info.type = j.type;
        info.name = j.name;
        info.namespace= j.namespace;
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
