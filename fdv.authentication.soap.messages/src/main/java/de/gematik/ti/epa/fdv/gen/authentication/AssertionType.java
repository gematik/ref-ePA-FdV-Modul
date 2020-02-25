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

public class AssertionType extends AttributeContainer implements KvmSerializable,java.io.Serializable
{
    
    public NameIDType Issuer;
    
    public SignatureType Signature;
    
    public SubjectType Subject;
    
    public ConditionsType Conditions;
    
    public AdviceType Advice;
    
    public ArrayList< StatementAbstractType> Statement =new ArrayList<StatementAbstractType >();
    
    public ArrayList< AuthnStatementType> AuthnStatement =new ArrayList<AuthnStatementType >();
    
    public ArrayList< AuthzDecisionStatementType> AuthzDecisionStatement =new ArrayList<AuthzDecisionStatementType >();
    
    public ArrayList< AttributeStatementType> AttributeStatement =new ArrayList<AttributeStatementType >();
    
    public String Version;
    
    public String ID;
    
    public java.util.Date IssueInstant;
        
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

if (inObj.hasAttribute("Version"))
        {	
            java.lang.Object j = inObj.getAttribute("Version");
            if (j != null)
            {
                Version = j.toString();
            }
        }if (inObj.hasAttribute("ID"))
        {	
            java.lang.Object j = inObj.getAttribute("ID");
            if (j != null)
            {
                ID = j.toString();
            }
        }if (inObj.hasAttribute("IssueInstant"))
        {	
            java.lang.Object j = inObj.getAttribute("IssueInstant");
            if (j != null)
            {
                IssueInstant = Helper.ConvertFromWebService(j.toString());
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Issuer"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Issuer = (NameIDType)__envelope.get(j,NameIDType.class,false);
            }
            return true;
        }
        if (info.name.equals("Signature"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Signature = (SignatureType)__envelope.get(j,SignatureType.class,false);
            }
            return true;
        }
        if (info.name.equals("Subject"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Subject = (SubjectType)__envelope.get(j,SubjectType.class,false);
            }
            return true;
        }
        if (info.name.equals("Conditions"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Conditions = (ConditionsType)__envelope.get(j,ConditionsType.class,false);
            }
            return true;
        }
        if (info.name.equals("Advice"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Advice = (AdviceType)__envelope.get(j,AdviceType.class,false);
            }
            return true;
        }
        if (info.name.equals("Statement"))
        {
            if(obj!=null)
            {
if(this.Statement==null)
                {
                    this.Statement = new java.util.ArrayList< StatementAbstractType>();
                }
                java.lang.Object j =obj;
                StatementAbstractType j1= (StatementAbstractType)__envelope.get(j,StatementAbstractType.class,false);
                this.Statement.add(j1);            }
            return true;
        }
        if (info.name.equals("AuthnStatement"))
        {
            if(obj!=null)
            {
if(this.AuthnStatement==null)
                {
                    this.AuthnStatement = new java.util.ArrayList< AuthnStatementType>();
                }
                java.lang.Object j =obj;
                AuthnStatementType j1= (AuthnStatementType)__envelope.get(j,AuthnStatementType.class,false);
                this.AuthnStatement.add(j1);            }
            return true;
        }
        if (info.name.equals("AuthzDecisionStatement"))
        {
            if(obj!=null)
            {
if(this.AuthzDecisionStatement==null)
                {
                    this.AuthzDecisionStatement = new java.util.ArrayList< AuthzDecisionStatementType>();
                }
                java.lang.Object j =obj;
                AuthzDecisionStatementType j1= (AuthzDecisionStatementType)__envelope.get(j,AuthzDecisionStatementType.class,false);
                this.AuthzDecisionStatement.add(j1);            }
            return true;
        }
        if (info.name.equals("AttributeStatement"))
        {
            if(obj!=null)
            {
if(this.AttributeStatement==null)
                {
                    this.AttributeStatement = new java.util.ArrayList< AttributeStatementType>();
                }
                java.lang.Object j =obj;
                AttributeStatementType j1= (AttributeStatementType)__envelope.get(j,AttributeStatementType.class,false);
                this.AttributeStatement.add(j1);            }
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
            return this.Issuer!=null?this.Issuer.getSimpleValue():null;
        }
        if(propertyIndex==1)
        {
            return this.Signature!=null?this.Signature:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==2)
        {
            return this.Subject!=null?this.Subject:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==3)
        {
            return this.Conditions!=null?this.Conditions:SoapPrimitive.NullSkip;
        }
        if(propertyIndex==4)
        {
            return this.Advice!=null?this.Advice:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=5 && propertyIndex < 5+this.Statement.size())
        {
                java.lang.Object Statement = this.Statement.get(propertyIndex-(5));
                return Statement!=null?Statement:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=5+this.Statement.size() && propertyIndex < 5+this.Statement.size()+this.AuthnStatement.size())
        {
                java.lang.Object AuthnStatement = this.AuthnStatement.get(propertyIndex-(5+this.Statement.size()));
                return AuthnStatement!=null?AuthnStatement:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=5+this.Statement.size()+this.AuthnStatement.size() && propertyIndex < 5+this.Statement.size()+this.AuthnStatement.size()+this.AuthzDecisionStatement.size())
        {
                java.lang.Object AuthzDecisionStatement = this.AuthzDecisionStatement.get(propertyIndex-(5+this.Statement.size()+this.AuthnStatement.size()));
                return AuthzDecisionStatement!=null?AuthzDecisionStatement:SoapPrimitive.NullSkip;
        }
        if(propertyIndex>=5+this.Statement.size()+this.AuthnStatement.size()+this.AuthzDecisionStatement.size() && propertyIndex < 5+this.Statement.size()+this.AuthnStatement.size()+this.AuthzDecisionStatement.size()+this.AttributeStatement.size())
        {
                java.lang.Object AttributeStatement = this.AttributeStatement.get(propertyIndex-(5+this.Statement.size()+this.AuthnStatement.size()+this.AuthzDecisionStatement.size()));
                return AttributeStatement!=null?AttributeStatement:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 5+Statement.size()+AuthnStatement.size()+AuthzDecisionStatement.size()+AttributeStatement.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = org.ksoap2.serialization.SoapPrimitive.class;
            info.name = "Issuer";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex==1)
        {
            info.type = SignatureType.class;
            info.name = "Signature";
            info.namespace= "http://www.w3.org/2000/09/xmldsig#";
        }
        if(propertyIndex==2)
        {
            info.type = SubjectType.class;
            info.name = "Subject";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex==3)
        {
            info.type = ConditionsType.class;
            info.name = "Conditions";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex==4)
        {
            info.type = AdviceType.class;
            info.name = "Advice";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex>=5 && propertyIndex < 5+this.Statement.size())
        {
            info.type = StatementAbstractType.class;
            info.name = "Statement";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex>=5+this.Statement.size() && propertyIndex < 5+this.Statement.size()+this.AuthnStatement.size())
        {
            info.type = AuthnStatementType.class;
            info.name = "AuthnStatement";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex>=5+this.Statement.size()+this.AuthnStatement.size() && propertyIndex < 5+this.Statement.size()+this.AuthnStatement.size()+this.AuthzDecisionStatement.size())
        {
            info.type = AuthzDecisionStatementType.class;
            info.name = "AuthzDecisionStatement";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
        }
        if(propertyIndex>=5+this.Statement.size()+this.AuthnStatement.size()+this.AuthzDecisionStatement.size() && propertyIndex < 5+this.Statement.size()+this.AuthnStatement.size()+this.AuthzDecisionStatement.size()+this.AttributeStatement.size())
        {
            info.type = AttributeStatementType.class;
            info.name = "AttributeStatement";
            info.namespace= "urn:oasis:names:tc:SAML:2.0:assertion";
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
                info.name = "Version";
                info.namespace= "";
                if(this.Version!=null)
                {
                    info.setValue(this.Version);
                }
            
                }if(index==1)
                {
                info.name = "ID";
                info.namespace= "";
                if(this.ID!=null)
                {
                    info.setValue(this.ID);
                }
            
                }if(index==2)
                {
                info.name = "IssueInstant";
                info.namespace= "";
                if(this.IssueInstant!=null)
                {
                    info.setValue(this.IssueInstant);
                }
            
                }    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
