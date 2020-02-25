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

public class RTO_MO_PQ extends QTY implements KvmSerializable,java.io.Serializable
{
    
	/**
	* The quantity that is being divided in the ratio.  The
	*                         default is the integer number 1 (one).
	*/
    public MO numerator;
    
	/**
	* The quantity that devides the numerator in the ratio.
	*                         The default is the integer number 1 (one).
	*                         The denominator must not be zero.
	*/
    public PQ denominator;
        

    
    
    @Override
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        super.loadFromSoap(paramObj, __envelope);



    }

    @Override
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("numerator"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.numerator = (MO)__envelope.get(j,MO.class,false);
            }
            return true;
        }
        if (info.name.equals("denominator"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.denominator = (PQ)__envelope.get(j,PQ.class,false);
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
            return numerator;
        }
        if(propertyIndex==count+1)
        {
            return denominator;
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
            info.type = MO.class;
            info.name = "numerator";
            info.namespace= "urn:hl7-org:v3";
        }
        if(propertyIndex==count+1)
        {
            info.type = PQ.class;
            info.name = "denominator";
            info.namespace= "urn:hl7-org:v3";
        }
        super.getPropertyInfo(propertyIndex,arg1,info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
