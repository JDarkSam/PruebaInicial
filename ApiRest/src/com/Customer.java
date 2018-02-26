package com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONException;
import org.json.JSONObject;
@XmlRootElement
public class Customer {
       // @XmlElement(name = "companyname")
        String companyname;
        float precio;
        public Customer() {
        }
        public Customer(String companyname,float precio) {
                this.companyname = companyname;
                this.precio = precio;
        }
        @Override
        public String toString() {
                try {
                        return new JSONObject().put("companyname", companyname).toString();
                } catch (JSONException e) {
                        return null;
                }
        }
        
}