//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.20 at 03:13:47 PM MEZ 
//


package de.osmembrane.model.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes a single Osmosis task.
 * 
 * <p>Java class for XMLTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XMLTask">
 *   &lt;complexContent>
 *     &lt;extension base="{http://osmembrane.de/model/xml}XMLHasDescription">
 *       &lt;sequence>
 *         &lt;element ref="{http://osmembrane.de/model/xml}inputPipe" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://osmembrane.de/model/xml}outputPipe" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://osmembrane.de/model/xml}parameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="shortName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="friendlyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="helpURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLTask", propOrder = {
    "inputPipe",
    "outputPipe",
    "parameter"
})
public class XMLTask
    extends XMLHasDescription
    implements Serializable
{

    private final static long serialVersionUID = 2011011810070001L;
    protected List<XMLPipe> inputPipe;
    protected List<XMLPipe> outputPipe;
    protected List<XMLParameter> parameter;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute
    protected String shortName;
    @XmlAttribute
    protected String friendlyName;
    @XmlAttribute
    @XmlSchemaType(name = "anyURI")
    protected String helpURI;

    /**
     * Gets the value of the inputPipe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputPipe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputPipe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLPipe }
     * 
     * 
     */
    public List<XMLPipe> getInputPipe() {
        if (inputPipe == null) {
            inputPipe = new ArrayList<XMLPipe>();
        }
        return this.inputPipe;
    }

    public boolean isSetInputPipe() {
        return ((this.inputPipe!= null)&&(!this.inputPipe.isEmpty()));
    }

    public void unsetInputPipe() {
        this.inputPipe = null;
    }

    /**
     * Gets the value of the outputPipe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputPipe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputPipe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLPipe }
     * 
     * 
     */
    public List<XMLPipe> getOutputPipe() {
        if (outputPipe == null) {
            outputPipe = new ArrayList<XMLPipe>();
        }
        return this.outputPipe;
    }

    public boolean isSetOutputPipe() {
        return ((this.outputPipe!= null)&&(!this.outputPipe.isEmpty()));
    }

    public void unsetOutputPipe() {
        this.outputPipe = null;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLParameter }
     * 
     * 
     */
    public List<XMLParameter> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<XMLParameter>();
        }
        return this.parameter;
    }

    public boolean isSetParameter() {
        return ((this.parameter!= null)&&(!this.parameter.isEmpty()));
    }

    public void unsetParameter() {
        this.parameter = null;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    public boolean isSetShortName() {
        return (this.shortName!= null);
    }

    /**
     * Gets the value of the friendlyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Sets the value of the friendlyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriendlyName(String value) {
        this.friendlyName = value;
    }

    public boolean isSetFriendlyName() {
        return (this.friendlyName!= null);
    }

    /**
     * Gets the value of the helpURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHelpURI() {
        return helpURI;
    }

    /**
     * Sets the value of the helpURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHelpURI(String value) {
        this.helpURI = value;
    }

    public boolean isSetHelpURI() {
        return (this.helpURI!= null);
    }

}
