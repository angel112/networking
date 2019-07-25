

package networks;

import java.io.*;


public class process {
	public static void main(String args[]) {
		String command = "ipconfig /all";
		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader sc = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String str = sc.readLine();
			String ip = "";
			String subnet = "";
			while(str!=null) {
				if(str.contains("IPv4")) {
					ip = str;
				}
				else if(str.contains("Subnet")) {
					subnet = str;
				}
				str = sc.readLine();
			}
			sc.close();
			ip = ip.split(":")[1].trim();
			ip = ip.split("\\(")[0];
			subnet = subnet.split(":")[1].trim();
			
			System.out.println("IPv4: "+ip+"\nSubnet: "+subnet);
			
			
			int i[] = new int[4];
			int s[]  = new int[4]; 
			int n[] = new int[4];
			for(int x = 0;x<=3; x++) {
				i[x] = Integer.parseInt(ip.split("\\.")[x]);
			}
			for(int x = 0;x<=3; x++) {
				s[x] = Integer.parseInt(subnet.split("\\.")[x]);
				n[x] = i[x]&s[x];
			}
			if(i[0]>=1 && i[0]<=127)
				System.out.println("IP Class A");
			if(i[0]>=128 && i[0]<=191)
				System.out.println("IP Class B");
			if(i[0]>=192 && i[0]<=223)
				System.out.println("IP Class C");
			System.out.print("Network Address: ");
			System.out.print(n[0] + "." + n[1] +"." + n[2] + "." + n[3]);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}


