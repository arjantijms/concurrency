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

package jakarta.enterprise.concurrent.spec.ManagedThreadFactory.apitests;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManageableThread;
import jakarta.enterprise.concurrent.ManagedThreadFactory;
import jakarta.enterprise.concurrent.tck.framework.TestConstants;
import jakarta.enterprise.concurrent.tck.framework.TestServlet;
import jakarta.enterprise.concurrent.tck.framework.TestUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("APIServlet")
public class APIServlet extends TestServlet {

	@Resource(lookup = TestConstants.DefaultManagedThreadFactory)
	private ManagedThreadFactory factory;

	public void interruptThreadApiTest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		CounterRunnable task = new CounterRunnable();
		Thread thread = factory.newThread(task);
		thread.start();
		thread.interrupt();
		TestUtil.waitTillThreadFinish(thread);
		TestUtil.assertEquals(0, task.getCount());
	}
	
	public void implementsManageableThreadInterfaceTest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		CounterRunnable task = new CounterRunnable();
		Thread thread = factory.newThread(task);
		if (!(thread instanceof ManageableThread)) {
			throw new RuntimeException(
					"The thread returned by ManagedThreadFactory should be instance of ManageableThread.");
		}
	}

	public static class CounterRunnable implements Runnable {
		private volatile int count = 0;

		public int getCount() {
			return count;
		}

		public void run() {
			try {
				TestUtil.sleep(TestConstants.PollInterval);
				count++;
			} catch (InterruptedException ignore) {
				return;
			}
		}
	}
}
