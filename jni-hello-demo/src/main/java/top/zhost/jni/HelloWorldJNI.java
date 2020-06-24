package top.zhost.jni;

public class HelloWorldJNI {
	
	public native void helloJNI(String name);
	
	public static void main(String[] args) {
		System.loadLibrary("hellojni");
		//System.load("C:\\Program Files\\Java\\jdk1.8.0_31\\bin\\hellojni.dll");
		HelloWorldJNI demo = new HelloWorldJNI();
		demo.helloJNI("jni test");
	}
	
}
