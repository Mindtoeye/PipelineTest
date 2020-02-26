package com.knossys.rnd.test;

import org.apache.log4j.Logger;

import com.knossys.rnd.KnossysConfig;
import com.knossys.rnd.TaskManager;

/**
 * @author vvelsen
 */
public class KPipelineTestApp {

	private static Logger logger = Logger.getLogger(KPipelineTestApp.class);
	
	private String testFile="";

	private TaskManager taskManager = null;
	
	private KnossysConfig config = null;
	
	/**
	 * 
	 */
	public KPipelineTestApp () {
	}

  /**
   * @return
   */
	public String getTestFile() {
		return testFile;
	}

	/**
	 * 
	 * @param testFile
	 */
	public void setTestFile(String testFile) {
		this.testFile = testFile;
	}	  
	
  /**
   * Run a pipeline in local drydock mode, which means:
   * 
   * - Use the HiVis version of a dataset
   * - Don't use any clustering or distribution
   * - Use disk synchronization if possible instead of a network
   */
	private Boolean runPipelineLocal(String aPipelineFile) {
		logger.info ("runPipelineLocal ()");
		
		config = new KnossysConfig ();
		config.init ();
			
		taskManager=new TaskManager (config);
		
		return (taskManager.runPipelineLocal(aPipelineFile));
	}

	/**
	 * 
	 * @param args
	 */
	private void parseArgs(String[] args) {
	  logger.info ("parseArgs ()");
	  
	  for (int i=0;i<args.length;i++) {
	  	String anArg=args [i];
	  	if (anArg.equalsIgnoreCase("-f")==true) {
	  		setTestFile (args [i+1]);
	  	}
	  }
	}
	
  /**
   * @param args
   */
  public static void main(String[] args) {  	 	  	
  	KPipelineTestApp testApp = new KPipelineTestApp();
  	testApp.parseArgs (args);
  	testApp.runPipelineLocal (testApp.getTestFile());
  }
}
