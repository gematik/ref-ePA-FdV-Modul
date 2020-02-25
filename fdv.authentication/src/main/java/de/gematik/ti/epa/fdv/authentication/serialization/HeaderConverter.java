package de.gematik.ti.epa.fdv.authentication.serialization;

import java.util.Hashtable;

import org.ksoap2.serialization.*;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;

import de.gematik.ti.epa.fdv.gen.authentication.Helper;

/**
 * Converts object to header element
 */
public final class HeaderConverter {
    private HeaderConverter() {
    }

    public static Element convertToHeader(final java.lang.Object headerElement, final java.lang.String namespace, final java.lang.String name) {
        final org.kxml2.kdom.Element parentElement = new org.kxml2.kdom.Element().createElement(namespace, name);
        if (headerElement == null) {
            return parentElement;
        }
        if (headerElement instanceof IPreMarshalledXmlSerializable) {
            final PreMarshalledElement element = new PreMarshalledElement();
            element.setPreMarshalledXml(headerElement.toString());
            return element;
        }
        if (headerElement instanceof KvmSerializable) {
            final KvmSerializable soapObject = (KvmSerializable) headerElement;
            convertKvmSerializableElement(parentElement, soapObject);
        } else if (headerElement != SoapPrimitive.NullSkip && headerElement != SoapPrimitive.NullNilElement) {
            createDateElement(headerElement, parentElement);
        }
        if (headerElement instanceof AttributeContainer) {
            convertAttributeContainerElement((AttributeContainer) headerElement, parentElement);
        }
        return parentElement;
    }

    private static void convertKvmSerializableElement(final Element parentElement, final KvmSerializable soapObject) {
        for (int i = 0; i < soapObject.getPropertyCount(); i++) {
            final PropertyInfo info = new PropertyInfo();
            soapObject.getPropertyInfo(i, new Hashtable(), info);
            final Object value = soapObject.getProperty(i);
            if (value != null && value != SoapPrimitive.NullSkip && value != SoapPrimitive.NullNilElement) {
                info.setValue(value);
                final Element el1 = convertToHeader(info.getValue(), info.getNamespace(), info.getName());
                parentElement.addChild(Node.ELEMENT, el1);
            }
        }
    }

    private static void convertAttributeContainerElement(final AttributeContainer headerElement, final Element parentElement) {
        final AttributeContainer attrContainer = headerElement;
        for (int i = 0; i < attrContainer.getAttributeCount(); i++) {
            final AttributeInfo info = new AttributeInfo();
            attrContainer.getAttributeInfo(i, info);
            final Object value = info.getValue();
            String valueString = "";
            if (value != null) {
                valueString = value.toString();
            }
            parentElement.setAttribute(info.namespace, info.name, valueString);
        }
    }

    private static void createDateElement(final Object headerElement, final Element parentElement) {
        String value = headerElement.toString();
        if (headerElement instanceof java.util.Date) {
            final java.util.Date date = (java.util.Date) headerElement;
            value = Helper.getDateFormat().format(date);
        }
        parentElement.addChild(Node.TEXT, value);
    }
}
