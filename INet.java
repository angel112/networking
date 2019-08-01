import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class INet {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        try {

            NetworkInterface net = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            System.out.println(net.getHardwareAddress());
            //System.out.println(net.getInetAddresses());
            System.out.println(net.getInterfaceAddresses());
            System.out.println(net.getDisplayName());
           // System.out.println(net.getIndex());
            //System.out.println(net.getParent());
            System.out.println("Prefix Lengh = " + net.getInterfaceAddresses().get(0).getNetworkPrefixLength());
            int pl = net.getInterfaceAddresses().get(0).getNetworkPrefixLength();
            String sub = "";
            for(int i = 0 ; i<pl ; i++){
                sub+='1';
            }
            for(int i =pl ; i<32 ; i++){
                sub+='0';
            }
            System.out.println(sub);
            int[] subnet = {0,0,0,0};
            for(int i = 0 ; i<=3 ; i++){
                int x = 7;
                for(int j = i*8 ; j<(i+1)*8 ; j++) {
                    if (sub.charAt(j) == '1') {
                        subnet[i] += Math.pow(2, x);
                    }
                    x--;
                }
                //System.out.println(subnet[i]);
            }

            System.out.println("Subnet Mask: " + subnet[0] + "." + subnet[1] + "." + subnet[2] + "." + subnet[3]);

            String url = "www.google.com";
            InetAddress addr = InetAddress.getByName(url);
            System.out.println(addr.getHostName());
            System.out.println(addr.getHostAddress());


            InetAddress[] addrs = InetAddress.getAllByName(url);
            for (int i = 0; i < addrs.length; i++) {
                //System.out.println(addrs[i].getCanonicalHostName());
                System.out.println(addrs[i].getHostName());
                System.out.println(addrs[i].getHostAddress());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
