package com.huawei.esdk.tp.professional.local;

import java.util.Iterator;
import java.util.Locale;

import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

public class MyFaultException implements SOAPFault{
	private String faultCode;
	@Override
	public SOAPElement addChildElement(Name paramName) throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addChildElement(QName paramQName)
			throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addChildElement(String paramString)
			throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addChildElement(String paramString1,
			String paramString2) throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addChildElement(String paramString1,
			String paramString2, String paramString3) throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addChildElement(SOAPElement paramSOAPElement)
			throws SOAPException {
		
		return null;
	}

	@Override
	public void removeContents() {
		
		
	}

	@Override
	public SOAPElement addTextNode(String paramString) throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addAttribute(Name paramName, String paramString)
			throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addAttribute(QName paramQName, String paramString)
			throws SOAPException {
		
		return null;
	}

	@Override
	public SOAPElement addNamespaceDeclaration(String paramString1,
			String paramString2) throws SOAPException {
		
		return null;
	}

	@Override
	public String getAttributeValue(Name paramName) {
		
		return null;
	}

	@Override
	public String getAttributeValue(QName paramQName) {
		
		return null;
	}

	@Override
	public Iterator getAllAttributes() {
		
		return null;
	}

	@Override
	public Iterator getAllAttributesAsQNames() {
		
		return null;
	}

	@Override
	public String getNamespaceURI(String paramString) {
		
		return null;
	}

	@Override
	public Iterator getNamespacePrefixes() {
		
		return null;
	}

	@Override
	public Iterator getVisibleNamespacePrefixes() {
		
		return null;
	}

	@Override
	public QName createQName(String paramString1, String paramString2)
			throws SOAPException {
		
		return null;
	}

	@Override
	public Name getElementName() {
		
		return null;
	}

	@Override
	public QName getElementQName() {
		
		return null;
	}

	@Override
	public SOAPElement setElementQName(QName paramQName)
			throws SOAPException {
		
		return null;
	}

	@Override
	public boolean removeAttribute(Name paramName) {
		
		return false;
	}

	@Override
	public boolean removeAttribute(QName paramQName) {
		
		return false;
	}

	@Override
	public boolean removeNamespaceDeclaration(String paramString) {
		
		return false;
	}

	@Override
	public Iterator getChildElements() {
		
		return null;
	}

	@Override
	public Iterator getChildElements(Name paramName) {
		
		return null;
	}

	@Override
	public Iterator getChildElements(QName paramQName) {
		
		return null;
	}

	@Override
	public void setEncodingStyle(String paramString) throws SOAPException {
		
		
	}

	@Override
	public String getEncodingStyle() {
		
		return null;
	}

	@Override
	public String getValue() {
		
		return null;
	}

	@Override
	public void setValue(String paramString) {
		
		
	}

	@Override
	public void setParentElement(SOAPElement paramSOAPElement)
			throws SOAPException {
		
		
	}

	@Override
	public SOAPElement getParentElement() {
		
		return null;
	}

	@Override
	public void detachNode() {
		
		
	}

	@Override
	public void recycleNode() {
		
		
	}

	@Override
	public String getNodeName() {
		
		return null;
	}

	@Override
	public String getNodeValue() throws DOMException {
		
		return null;
	}

	@Override
	public void setNodeValue(String paramString) throws DOMException {
		
		
	}

	@Override
	public short getNodeType() {
		
		return 0;
	}

	@Override
	public Node getParentNode() {
		
		return null;
	}

	@Override
	public NodeList getChildNodes() {
		
		return null;
	}

	@Override
	public Node getFirstChild() {
		
		return null;
	}

	@Override
	public Node getLastChild() {
		
		return null;
	}

	@Override
	public Node getPreviousSibling() {
		
		return null;
	}

	@Override
	public Node getNextSibling() {
		
		return null;
	}

	@Override
	public NamedNodeMap getAttributes() {
		
		return null;
	}

	@Override
	public Document getOwnerDocument() {
		
		return null;
	}

	@Override
	public Node insertBefore(Node paramNode1, Node paramNode2)
			throws DOMException {
		
		return null;
	}

	@Override
	public Node replaceChild(Node paramNode1, Node paramNode2)
			throws DOMException {
		
		return null;
	}

	@Override
	public Node removeChild(Node paramNode) throws DOMException {
		
		return null;
	}

	@Override
	public Node appendChild(Node paramNode) throws DOMException {
		
		return null;
	}

	@Override
	public boolean hasChildNodes() {
		
		return false;
	}

	@Override
	public Node cloneNode(boolean paramBoolean) {
		
		return null;
	}

	@Override
	public void normalize() {
		
		
	}

	@Override
	public boolean isSupported(String paramString1, String paramString2) {
		
		return false;
	}

	@Override
	public String getNamespaceURI() {
		
		return null;
	}

	@Override
	public String getPrefix() {
		
		return null;
	}

	@Override
	public void setPrefix(String paramString) throws DOMException {
		
		
	}

	@Override
	public String getLocalName() {
		
		return null;
	}

	@Override
	public boolean hasAttributes() {
		
		return false;
	}

	@Override
	public String getBaseURI() {
		
		return null;
	}

	@Override
	public short compareDocumentPosition(Node paramNode)
			throws DOMException {
		
		return 0;
	}

	@Override
	public String getTextContent() throws DOMException {
		
		return null;
	}

	@Override
	public void setTextContent(String paramString) throws DOMException {
		
		
	}

	@Override
	public boolean isSameNode(Node paramNode) {
		
		return false;
	}

	@Override
	public String lookupPrefix(String paramString) {
		
		return null;
	}

	@Override
	public boolean isDefaultNamespace(String paramString) {
		
		return false;
	}

	@Override
	public String lookupNamespaceURI(String paramString) {
		
		return null;
	}

	@Override
	public boolean isEqualNode(Node paramNode) {
		
		return false;
	}

	@Override
	public Object getFeature(String paramString1, String paramString2) {
		
		return null;
	}

	@Override
	public Object setUserData(String paramString, Object paramObject,
			UserDataHandler paramUserDataHandler) {
		
		return null;
	}

	@Override
	public Object getUserData(String paramString) {
		
		return null;
	}

	@Override
	public String getTagName() {
		
		return null;
	}

	@Override
	public String getAttribute(String paramString) {
		
		return null;
	}

	@Override
	public void setAttribute(String paramString1, String paramString2)
			throws DOMException {
		
		
	}

	@Override
	public void removeAttribute(String paramString) throws DOMException {
		
		
	}

	@Override
	public Attr getAttributeNode(String paramString) {
		
		return null;
	}

	@Override
	public Attr setAttributeNode(Attr paramAttr) throws DOMException {
		
		return null;
	}

	@Override
	public Attr removeAttributeNode(Attr paramAttr) throws DOMException {
		
		return null;
	}

	@Override
	public NodeList getElementsByTagName(String paramString) {
		
		return null;
	}

	@Override
	public String getAttributeNS(String paramString1, String paramString2)
			throws DOMException {
		
		return null;
	}

	@Override
	public void setAttributeNS(String paramString1, String paramString2,
			String paramString3) throws DOMException {
		
		
	}

	@Override
	public void removeAttributeNS(String paramString1, String paramString2)
			throws DOMException {
		
		
	}

	@Override
	public Attr getAttributeNodeNS(String paramString1, String paramString2)
			throws DOMException {
		
		return null;
	}

	@Override
	public Attr setAttributeNodeNS(Attr paramAttr) throws DOMException {
		
		return null;
	}

	@Override
	public NodeList getElementsByTagNameNS(String paramString1,
			String paramString2) throws DOMException {
		
		return null;
	}

	@Override
	public boolean hasAttribute(String paramString) {
		
		return false;
	}

	@Override
	public boolean hasAttributeNS(String paramString1, String paramString2)
			throws DOMException {
		
		return false;
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		
		return null;
	}

	@Override
	public void setIdAttribute(String paramString, boolean paramBoolean)
			throws DOMException {
		
		
	}

	@Override
	public void setIdAttributeNS(String paramString1, String paramString2,
			boolean paramBoolean) throws DOMException {
		
		
	}

	@Override
	public void setIdAttributeNode(Attr paramAttr, boolean paramBoolean)
			throws DOMException {
		
		
	}

	@Override
	public void setFaultCode(Name paramName) throws SOAPException {
		
		
	}

	@Override
	public void setFaultCode(QName paramQName) throws SOAPException {
		
		
	}

	@Override
	public void setFaultCode(String paramString) throws SOAPException {
		faultCode = paramString;
	}

	@Override
	public Name getFaultCodeAsName() {
		
		return null;
	}

	@Override
	public QName getFaultCodeAsQName() {
		
		return null;
	}

	@Override
	public Iterator getFaultSubcodes() {
		
		return null;
	}

	@Override
	public void removeAllFaultSubcodes() {
		
		
	}

	@Override
	public void appendFaultSubcode(QName paramQName) throws SOAPException {
		
		
	}

	@Override
	public String getFaultCode() {
		return this.faultCode;
	}

	@Override
	public void setFaultActor(String paramString) throws SOAPException {
		
		
	}

	@Override
	public String getFaultActor() {
		
		return null;
	}

	@Override
	public void setFaultString(String paramString) throws SOAPException {
		
		
	}

	@Override
	public void setFaultString(String paramString, Locale paramLocale)
			throws SOAPException {
		
		
	}

	@Override
	public String getFaultString() {
		
		return null;
	}

	@Override
	public Locale getFaultStringLocale() {
		
		return null;
	}

	@Override
	public boolean hasDetail() {
		
		return false;
	}

	@Override
	public Detail getDetail() {
		
		return null;
	}

	@Override
	public Detail addDetail() throws SOAPException {
		
		return null;
	}

	@Override
	public Iterator getFaultReasonLocales() throws SOAPException {
		
		return null;
	}

	@Override
	public Iterator getFaultReasonTexts() throws SOAPException {
		
		return null;
	}

	@Override
	public String getFaultReasonText(Locale paramLocale)
			throws SOAPException {
		
		return null;
	}

	@Override
	public void addFaultReasonText(String paramString, Locale paramLocale)
			throws SOAPException {
		
		
	}

	@Override
	public String getFaultNode() {
		
		return null;
	}

	@Override
	public void setFaultNode(String paramString) throws SOAPException {
		
		
	}

	@Override
	public String getFaultRole() {
		
		return null;
	}

	@Override
	public void setFaultRole(String paramString) throws SOAPException {
		
		
	}
	
}