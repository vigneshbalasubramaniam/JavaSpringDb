/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;

import com.db.DbCreate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.vendor.Database;

/**
 *
 * @author VI391762
 */
public class springmain {
    public static void main(String[] args)
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        DbCreate dc=(DbCreate)context.getBean("id3");
        // dc.create();
        //dc.insert(391760,"Balaji");
        //dc.display();
        //dc.displaymap();
        //dc.dispSingleRecord(391762);
        dc.dispsinglerec(391760);
    }
    
}
