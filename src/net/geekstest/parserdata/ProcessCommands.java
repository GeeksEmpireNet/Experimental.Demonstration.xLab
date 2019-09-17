package net.geekstest.parserdata;

public class ProcessCommands {

	public static void main(String args[]) {
		try {
			//Floating Shortcuts Pro
			/*Runtime.getRuntime()
			.exec("C:\\Users\\Xtation\\AppData\\Roaming\\npm\\firebase.cmd auth:export C:\\Users\\Xtation\\Desktop\\FloatingShortcutsPro.json --project floating-shortcuts-pro")
			.waitFor();*/
			
			//Floating Shortcuts Free
			/*Runtime.getRuntime()
			.exec("C:\\Users\\Xtation\\AppData\\Roaming\\npm\\firebase.cmd auth:export C:\\Users\\Xtation\\Desktop\\FloatingShortcutsFree.json --project floating-shortcuts-free")
			.waitFor();*/
			
			//Super Shortcuts Free
			/*Runtime.getRuntime()
			.exec("C:\\Users\\Xtation\\AppData\\Roaming\\npm\\firebase.cmd auth:export C:\\Users\\Xtation\\Desktop\\SuperShortcutsFree.json --project super-shortcuts-free")
			.waitFor();*/
			
			//Super Shortcuts Pro
			Runtime.getRuntime()
			.exec("C:\\Users\\Xtation\\AppData\\Roaming\\npm\\firebase.cmd auth:export C:\\Users\\Xtation\\Desktop\\SuperShortcutsPro.json --project super-shortcuts-pro")
			.waitFor();
			
			//Pin Pics On Map
			/*Runtime.getRuntime()
			.exec("C:\\Users\\Xtation\\AppData\\Roaming\\npm\\firebase.cmd auth:export C:\\Users\\Xtation\\Desktop\\PinPicsOnMap.json --project compass-c34b4")
			.waitFor();*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
