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

public class GLIST_PQ extends ANY implements KvmSerializable,java.io.Serializable
{
    
	/**
	* This is the start-value of the generated list.
	*/
    public PQ head;
    
	/**
	* The difference between one value and its previous
	*                      different value. For example, to generate the sequence
	*                      (1; 4; 7; 10; 13; ...) the increment is 3; likewise to
	*                      generate the sequence (1; 1; 4; 4; 7; 7; 10; 10; 13;
	*                      13; ...) the increment is also 3.
	*/
    public PQ increment;
    
	/**
	* If non-NULL, specifies that the sequence alternates,
	*                      i.e., after this many increments, the sequence item
	*                      values roll over to start from the initial sequence
	*                      item value. For example, the sequence (1; 2; 3; 1; 2;
	*                      3; 1; 2; 3; ...) has period 3; also the sequence
	*                      (1; 1; 2; 2; 3; 3; 1; 1; 2; 2; 3; 3; ...) has period
	*                      3 too.
	*/
    public BigInteger period;
    
	/**
	* The integer by which the index for the sequence is
	*                      divided, effectively the number of times the sequence
	*                      generates the same sequence item value before
	*                      incrementing to the next sequence item value. For
	*                      example, to generate the sequence (1; 1; 1; 2; 2; 2; 3; 3;
	*                      3; ...)  the denominator is 3.
	*/
    public BigInteger denominator;
        

    
    
    @Override
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        super.loadFromSoap(paramObj, __envelope);

if (inObj.hasAttribute("period"))
        {	
            java.lang.Object j = inObj.getAttribute("period");
            if (j != null)
            {
                period = new BigInteger(j.toString());
            }
        }if (inObj.hasAttribute("denominator"))
        {	
            java.lang.Object j = inObj.getAttribute("denominator");
            if (j != null)
            {
                denominator = new BigInteger(j.toString());
            }
        }

    }

    @Override
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("head"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.head = (PQ)__envelope.get(j,PQ.class,false);
            }
            return true;
        }
        if (info.name.equals("increment"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.increment = (PQ)__envelope.get(j,PQ.class,false);
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
            return head;
        }
        if(propertyIndex==count+1)
        {
            return increment;
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
            info.type = PQ.class;
            info.name = "head";
            info.namespace= "urn:hl7-org:v3";
        }
        if(propertyIndex==count+1)
        {
            info.type = PQ.class;
            info.name = "increment";
            info.namespace= "urn:hl7-org:v3";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }


    @Override
    public int getAttributeCount() {
        return super.getAttributeCount() + 2;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        int count=super.getAttributeCount();
        if(index==count+0)
                {
                info.name = "period";
                info.namespace= "";
                if(this.period!=null)
                {
                    info.setValue(this.period);
                }
            
                }if(index==count+1)
                {
                info.name = "denominator";
                info.namespace= "";
                if(this.denominator!=null)
                {
                    info.setValue(this.denominator);
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
