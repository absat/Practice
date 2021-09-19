class Solution {
    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.",-1);
        //Argument -1 for split will add empty string for leading and trailing empty strings
        //Otherwise 1.1.1. will return IPv4 instead of neither, since we will check 3 dots but no check that there are 4 grps
        for(String x: nums){
            if(x.length()==0 || x.length() > 3) return "Neither";
            if(x.charAt(0)=='0'&& x.length()!=1) return "Neither";
            for(char ch:x.toCharArray())
                if(!Character.isDigit(ch)) return "Neither";
            if(Integer.parseInt(x)>255) return "Neither";
        }
        return "IPv4";
    }
    
    public String validateIPv6(String IP){
        String[] nums = IP.split(":",-1);
        String hexDigits = "0123456789abcdefABCDEF";
        for(String x:nums){
            if (x.length() == 0 || x.length() > 4) return "Neither";
            for(char ch:x.toCharArray())
                if(hexDigits.indexOf(ch)==-1)  return "Neither";
        }
        return "IPv6";
    }
    
    public String validIPAddress(String IP) {
        if(IP.chars().filter(ch -> ch=='.').count()==3)
            return validateIPv4(IP);
        else if(IP.chars().filter(ch -> ch==':').count()==7)
            return validateIPv6(IP);
        else return "Neither";
    }
}