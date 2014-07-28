package com.generator;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JMethod;

public class CodeGenerator {

	private Logger logger = Logger.getLogger(this.getClass().getCanonicalName());
	
	public boolean generate() {
		boolean isSuccess = false;
		try {
			JCodeModel cm = new JCodeModel();
			JDefinedClass dc = cm._class("foo.Bar");
			JMethod m = dc.method(0, int.class, "foo");
			m.body()._return(JExpr.lit(5));

			File file = new File("./org/appops/entityStore/demo");
			file.mkdirs();
			cm.build(file);
			isSuccess = true;
			return isSuccess;
		} catch (JClassAlreadyExistsException e) {
			logger.log(Level.SEVERE, "[CodeGenerator] Exception In generate()", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "[CodeGenerator] Exception In generate()", e);
		}
		return isSuccess;
	}
}
