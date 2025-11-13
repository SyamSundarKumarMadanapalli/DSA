class Solution {
public:
    int maxOperations(string s) {
        int ones=0,operations=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='1' && i>0 && s[i-1]=='0'){
                operations += ones;
                ones++;
            }else if(s[i]=='1'){
                ones++;
            }
        }
        if(s[s.length()-1] != '1'){
            operations +=ones;
        }
        return operations;
    }
};