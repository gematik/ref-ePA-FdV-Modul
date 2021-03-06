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

/**
* A dimensioned quantity expressing the result of a
*                 measurement act.
*/
public class PQ extends QTY implements KvmSerializable,java.io.Serializable
{
    
	/**
	* An alternative representation of the same physical
	*                                 quantity expressed in a different unit, of a different
	*                                 unit code system and possibly with a different value.
	*/
    public ArrayList< PQR> translation =new ArrayList<PQR >();
    
	/**
	* The magnitude of the quantity measured in terms of
	*                             the unit.
	*/
    public String value;
    
	/**
	* The unit of measure specified in the Unified Code for
	*                             Units of Measure (UCUM)
	*                             [http://aurora.rg.iupui.edu/UCUM].
	*/
    public String unit;
        

    
    
    @Override
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        super.loadFromSoap(paramObj, __envelope);

if (inObj.hasAttribute("value"))
        {	
            java.lang.Object j = inObj.getAttribute("value");
            if (j != null)
            {
                value = j.toString();
            }
        }if (inObj.hasAttribute("unit"))
        {	
            java.lang.Object j = inObj.getAttribute("unit");
            if (j != null)
            {
                unit = j.toString();
            }
        }

    }

    @Override
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("translation"))
        {
            if(obj!=null)
            {
if(this.translation==null)
                {
                    this.translation = new java.util.ArrayList< PQR>();
                }
                java.lang.Object j =obj;
                PQR j1= (PQR)__envelope.get(j,PQR.class,false);
                this.translation.add(j1);            }
            return true;
        }
        return super.loadProperty(info,soapObject,__envelope);
    }
    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        int count = super.getPropertyCount();
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex>=count+0 && propertyIndex < count+0+this.translation.size())
        {
                java.lang.Object translation = this.translation.get(propertyIndex-(count+0));
                return translation!=null?translation:SoapPrimitive.NullNilElement;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+0+translation.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        int count = super.getPropertyCount();
        if(propertyIndex>=count+0 && propertyIndex < count+0+this.translation.size())
        {
            info.type = PQR.class;
            info.name = "translation";
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
                info.name = "value";
                info.namespace= "";
                if(this.value!=null)
                {
                    info.setValue(this.value);
                }
            
                }if(index==count+1)
                {
                info.name = "unit";
                info.namespace= "";
                if(this.unit!=null)
                {
                    info.setValue(this.unit);
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
