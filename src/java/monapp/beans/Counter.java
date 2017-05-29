/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monapp.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Counter {

    Integer value = 1000;

    public String inc() {
        value++;
        return null; // ne pas se déplacer
    }

    public Integer getValue() {
        return value;
    }
}
