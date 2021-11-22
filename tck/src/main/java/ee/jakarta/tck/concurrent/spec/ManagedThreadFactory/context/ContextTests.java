/*
 * Copyright (c) 2013, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package jakarta.enterprise.concurrent.spec.ManagedThreadFactory.context;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.annotations.Test;

import jakarta.enterprise.concurrent.tck.framework.TestClient;

public class ContextTests extends TestClient {
	
	@ArquillianResource(SecurityServlet.class)
	URL baseURL;
	
	@Deployment(name="ManagedThreadFactory.context", testable=false)
	public static EnterpriseArchive createDeployment() {
		WebArchive war = ShrinkWrap.create(WebArchive.class, "Context.war")
				.addPackages(true, getFrameworkPackage(), getAPICommonPackage(), ContextTests.class.getPackage())
				.addAsWebInfResource(ContextTests.class.getPackage(), "web.xml", "web.xml");
		
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "Context_ejb.jar")
				.addClasses(SecurityTestRemote.class, SecurityTestEjb.class);
		
		EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "Context.ear")
				.addAsModules(war, jar)
				.addAsManifestResource(ContextTests.class.getPackage(), "sun-ejb-jar.xml", "sun-ejb-jar.xml");
		
		return ear;
	}
	
	@Override
	protected String getServletPath() {
		return "SecurityServlet";
	}
	
	/*
	 * @testName: jndiClassloaderPropagationTest
	 * 
	 * @assertion_ids: CONCURRENCY:SPEC:96.7; CONCURRENCY:SPEC:100;
	 * CONCURRENCY:SPEC:106;
	 * 
	 * @test_Strategy:
	 */
	@Test
	public void jndiClassloaderPropagationTest() {
		runTest(baseURL);
	}
	
	@Test
	public void jndiClassloaderPropagationWithSecurityTest() {
		runTest(baseURL);
	}

}
