package edu.ucsb.cs56.pconrad;

import static spark.Spark.port;


/**
 * Hello world!
 *
 */

public class SparkDemo01 {

    public static void main(String[] args) {
	    
	    	String html = "<h1><a href='/hello'>Hello</a> World!</h1>\n" +
    "<p>This web app is powered by \n" +
    "<a href='https://github.com/zcy4014/sparkjava-01'>this github repo</a></p>\n";

		System.out.println("About to set the port...");
		port(getHerokuAssignedPort());
		
		System.out.println("");
		System.out.println("(Don't worry about the warnings below about SLF4J... we'll deal with those later)");
		System.out.println("");						  
		System.out.println("In browser, visit: http://localhost:" + getHerokuAssignedPort() + "/hello");
		System.out.println("");
		//spark.Spark.get("/hello", (req, res) -> "<b>Hello World!</b>\n");

		spark.Spark.get("/nihao", (req, res) -> "<b>Ni Hao</b>\n");

		spark.Spark.get("/hola", (req, res) -> "<b>¡Hola!</b>\n");
		spark.Spark.get("/", (req, res) -> html);
	    
	    	spark.Spark.get("/hello", (req, res) -> "<p><b>Hello, World!</b>  You just clicked the first link on my web app.</p>");

	}
	
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

	
}
