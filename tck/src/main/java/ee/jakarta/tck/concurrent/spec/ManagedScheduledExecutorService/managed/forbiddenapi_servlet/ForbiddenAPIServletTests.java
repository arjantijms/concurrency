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

package jakarta.enterprise.concurrent.spec.ManagedScheduledExecutorService.managed.forbiddenapi_servlet;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.annotations.Test;

import jakarta.enterprise.concurrent.tck.framework.TestClient;

public class ForbiddenAPIServletTests extends TestClient {

	@ArquillianResource
	URL baseURL;
	
	@Deployment(name="ManagedScheduledExecutorService.managed.forbiddenapi_servlet", testable=false)
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class)
				.addPackages(true, getFrameworkPackage(), getCommonCounterPackage(), ForbiddenAPIServletTests.class.getPackage());
	}
	
	@Override
	protected String getServletPath() {
		return "ForbiddenServlet";
	}

	/*
	 * @testName: testAwaitTermination
	 * 
	 * @assertion_ids: CONCURRENCY:SPEC:57.1
	 * 
	 * @test_Strategy:
	 */
	@Test
	public void testAwaitTermination() {
		runTest(baseURL);
	}

	/*
	 * @testName: testIsShutdown
	 * 
	 * @assertion_ids: CONCURRENCY:SPEC:57.2
	 * 
	 * @test_Strategy:
	 */
	@Test
	public void testIsShutdown() {
		runTest(baseURL);
	}

	/*
	 * @testName: testIsTerminated
	 * 
	 * @assertion_ids: CONCURRENCY:SPEC:57.3
	 * 
	 * @test_Strategy:
	 */
	@Test
	public void testIsTerminated() {
		runTest(baseURL);
	}

	/*
	 * @testName: testShutdown
	 * 
	 * @assertion_ids: CONCURRENCY:SPEC:57.4
	 * 
	 * @test_Strategy:
	 */
	@Test
	public void testShutdown() {
		runTest(baseURL);
	}

	/*
	 * @testName: testShutdownNow
	 * 
	 * @assertion_ids: CONCURRENCY:SPEC:57.5
	 * 
	 * @test_Strategy:
	 */
	@Test
	public void testShutdownNow() {
		runTest(baseURL);
	}
}
