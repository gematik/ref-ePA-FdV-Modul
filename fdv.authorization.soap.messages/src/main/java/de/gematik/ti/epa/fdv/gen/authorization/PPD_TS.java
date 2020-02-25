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

public class PPD_TS extends TS implements KvmSerializable,java.io.Serializable
{
    
	/**
	* The primary measure of variance/uncertainty of the
	*                         value (the square root of the sum of the squares of
	*                         the differences between all data points and the mean).
	*                         The standard deviation is used to normalize the data
	*                         for computing the distribution function. Applications
	*                         that cannot deal with probability distributions can
	*                         still get an idea about the confidence level by looking
	*                         at the standard deviation.
	*/
    public PQ standardDeviation;
    
	/**
	* A code specifying the type of probability distribution.
	*                      Possible values are as shown in the attached table.
	*                      The NULL value (unknown) for the type code indicates
	*                      that the probability distribution type is unknown. In
	*                      that case, the standard deviation has the meaning of an
	*                      informal guess.
	*/
    public Enums.ProbabilityDistributionType distributionType;
        

    
    
    @Override
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        super.loadFromSoap(paramObj, __envelope);

if (inObj.hasAttribute("distributionType"))
        {	
            java.lang.Object j = inObj.getAttribute("distributionType");
            if (j != null)
            {
                distributionType = Enums.ProbabilityDistributionType.fromString(j.toString());
            }
        }

    }

    @Override
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("standardDeviation"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.standardDeviation = (PQ)__envelope.get(j,PQ.class,false);
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
            return this.standardDeviation!=null?this.standardDeviation:SoapPrimitive.NullSkip;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+1;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex==count+0)
        {
            info.type = PQ.class;
            info.name = "standardDeviation";
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
        return super.getAttributeCount() + 1;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
        int count=super.getAttributeCount();
        if(index==count+0)
                {
                info.name = "distributionType";
                info.namespace= "";
                if(this.distributionType!=null)
                {
                    info.setValue(this.distributionType);
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
