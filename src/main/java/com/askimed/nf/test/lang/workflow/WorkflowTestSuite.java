package com.askimed.nf.test.lang.workflow;

import java.io.IOException;

import com.askimed.nf.test.core.AbstractTestSuite;
import com.askimed.nf.test.core.ITest;
import com.askimed.nf.test.lang.TestCode;
import com.askimed.nf.test.lang.process.ProcessTest;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class WorkflowTestSuite extends AbstractTestSuite {

	private String workflow;

	private TestCode setup;

	public void workflow(String workflow) {
		setWorkflow(workflow);
	}

	public void setWorkflow(String workflow) {
		this.workflow = workflow;
		tag(workflow);
	}

	public String getWorkflow() {
		return workflow;
	}

	public void test(String name, Closure closure) throws IOException {
		addTestClosure(name, closure);
	}

	public void setup(@DelegatesTo(value = ProcessTest.class, strategy = Closure.DELEGATE_ONLY) final Closure closure) {
		setup = new TestCode(closure);
	}

	public TestCode getSetup() {
		return setup;
	}

	@Override
	protected ITest getNewTestInstance(String name) {
		WorkflowTest test = new WorkflowTest(this);
		test.name(name);
		return test;
	}

}